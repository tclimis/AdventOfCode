package com.adventofcode.y2018.day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.adventofcode.AbstractChallenge;

public class Day4Challenge1 extends AbstractChallenge {
	
	private Connection connection;

	@Override
	public void initialize() {
		
		try {
			String password = "To yoga, to yogurt, to rice and beans and cheese";
			Connection connection = DriverManager.getConnection("jdbc:sqlserver://0.0.0.0:1433;DatabaseName=master", "sa", password);
			setConnection(connection);
			
			setupDB();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	private Connection getConnection() {
		return this.connection;
	}
	
	private void setupDB() throws SQLException {
		if( !dbExists("AdventOfCode") ) {
			createDB();
		}
		if( !tableExists("actionLog") ) {
			createActionLogTable();
		}
		else {
			resetActionLog();
		}
		if( !tableExists("sleepLog") ) {
			createSleepLogTable();
		}
		else {
			resetSleepLog();
		}
	}
	
	private boolean dbExists(String dbName) {
		try {
			ResultSet resultSet = getConnection().getMetaData().getCatalogs();
			while( resultSet.next() ) {
				if( resultSet.getString(1).equals(dbName) ) {
					return true;
				}
			}
		}
		catch( SQLException e ) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	private void createDB() throws SQLException {
		queryExecute("CREATE DATABASE AdventOfCode");
	}
	
	private void queryExecute(String sql) throws SQLException {
		queryExecute(sql, new Object[0]);
	}
	
	private void queryExecute(String sql, Object[] params) throws SQLException {
		PreparedStatement query = getConnection().prepareStatement(sql);
		for( int i = 0; i < params.length; i++ ) {
			query.setObject(i+1, params[i]);
		}
		query.execute();
	}
	
	private boolean tableExists(String tableName) throws SQLException {
		String sql = "SELECT 1\n"
				+ "FROM INFORMATION_SCHEMA.TABLES\n"
				+ "WHERE TABLE_NAME = ?";
		Object[] params = {tableName};
		return getResult(sql, params).next();
	}
	
	private ResultSet getResult(String sql, Object[] params) throws SQLException {
		PreparedStatement query = getConnection().prepareStatement(sql);
		for( int i = 0; i < params.length; i++ ) {
			query.setObject(i+1, params[i]);
		}
		return query.executeQuery();
	}
	
	private void createActionLogTable() throws SQLException {
		String sql = "CREATE TABLE actionLog (\n"
				+ "recnum INT NOT NULL IDENTITY(1,1) CONSTRAINT PK_actionLog PRIMARY KEY\n"
				+ ", timestamp DATETIME2 NOT NULL\n"
				+ ", action NVARCHAR(100) NOT NULL\n"
				+ ")";
		queryExecute(sql);
	}
	
	private void resetActionLog() throws SQLException {
		queryExecute("TRUNCATE TABLE actionLog");
	}
		
	private void createSleepLogTable() throws SQLException {
		String sql = "CREATE TABLE sleepLog(\n"
				+ "recnum INT NOT NULL IDENTITY(1,1) CONSTRAINT PK_sleepLog PRIMARY KEY\n"
				+ ", guardID INT NOT NULL\n"
				+ ", minute INT NOT NULL\n"
				+ ", asleep BIT NOT NULL\n"
				+ ")";
		queryExecute(sql);
	}
	
	private void resetSleepLog() throws SQLException {
		queryExecute("TRUNCATE TABLE sleepLog");
	}

	@Override
	public void processLine(String input) {
		String[] parsedLine = input.replace("[", "").replace("] ", ":00;").split(";");
		if( parsedLine.length == 2 ) {
			String time = parsedLine[0];
			String log = parsedLine[1];
		
			String sql = "INSERT INTO actionLog(timestamp, action)\n"
					+ "VALUES(?, ?)";
			Object[] params = {Timestamp.valueOf(time), log};
			try {
				queryExecute(sql, params);
			}
			catch( SQLException e ) { 
				System.err.println("Statement failed: \"" + sql + "\"");
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getOutput() {
		StringBuilder builder = new StringBuilder();
		
		try {
			populateSleepLog();
			
			String sql = getOutputQuery();
			ResultSet results = getResult(sql);
			while( results.next() ) {
				builder.append(results.getString(1)).append("\n");
			}
		}
		catch( SQLException e ) {
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	
	private void populateSleepLog() throws SQLException {
		int guardID = 0;
		boolean asleep = false;
		int minute = 0;
		
		String insert = "INSERT INTO sleepLog(guardID, minute, asleep)\n"
				+ "SELECT ?, minute, ?";
		
		String sql = "SELECT timestamp\n"
				+ ", action\n"
				+ "FROM actionLog\n"
				+ "ORDER BY timestamp";
		ResultSet results = getResult(sql);
		
		while( results.next() ) {
			if( results.getString("action").contains("Guard") ) {
				guardID = parseGuardID(results.getString("action"));
			}
			if( results.getString("action").contains("falls asleep") ) {
				asleep = true;
				minute = results.getInt("minute");
				Object[] params = {Integer.valueOf(guardID), Integer.valueOf(minute), Boolean.valueOf(asleep)};
				queryExecute(insert, params);
			}
			if( results.getString("action").contains("wakes up") ) {
				asleep = false;
				minute = results.getInt("minute");
				Object[] params = {Integer.valueOf(guardID), Integer.valueOf(minute), Boolean.valueOf(asleep)};
				queryExecute(insert, params);
			}
		}
	}
	
	private ResultSet getResult(String sql) throws SQLException {
		return getResult(sql, new Object[0]);
	}
	
	private int parseGuardID(String action) {
		return 0;
	}
	
	protected String getOutputQuery() {
		// CTE to rank guards by time asleep
		// query to get minute most likely to be sleeping
		
		return "SELECT 1";
	}

}
