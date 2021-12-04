package com.adventofcode.y2018.day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.adventofcode.AbstractChallenge;

public class Day4Challenge1 extends AbstractChallenge {
	
	private Connection connection;

	private static final String ACTION = "action";

	@Override
	public void initialize() {
		
		try {
			String password = "To yoga, to yogurt, to rice and beans and cheese";
			Connection tempConnection = DriverManager.getConnection("jdbc:sqlserver://0.0.0.0:1433;DatabaseName=master", "sa", password);
			setConnection(tempConnection);
			
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
		try( PreparedStatement query = getConnection().prepareStatement(sql) ) {
			for( int i = 0; i < params.length; i++ ) {
				query.setObject(i+1, params[i]);
			}
			query.execute();
		}
	}
	
	private boolean tableExists(String tableName) throws SQLException {
		String sql = """
			SELECT 1
			FROM INFORMATION_SCHEMA.TABLES
			WHERE TABLE_NAME = ?""";
		Object[] params = {tableName};
		return getResult(sql, params).next();
	}
	
	private ResultSet getResult(String sql, Object[] params) throws SQLException {
		try( PreparedStatement query = getConnection().prepareStatement(sql) ) {
			for( int i = 0; i < params.length; i++ ) {
				query.setObject(i+1, params[i]);
			}
			return query.executeQuery();
		}
	}
	
	private void createActionLogTable() throws SQLException {
		String sql = """
			CREATE TABLE actionLog (
			\trecnum INT NOT NULL IDENTITY(1,1) CONSTRAINT PK_actionLog PRIMARY KEY
			\t, timestamp DATETIME2 NOT NULL
			\t, action NVARCHAR(100) NOT NULL
			)""";
		queryExecute(sql);
	}
	
	private void resetActionLog() throws SQLException {
		queryExecute("TRUNCATE TABLE actionLog");
	}
		
	private void createSleepLogTable() throws SQLException {
		String sql = """
			CREATE TABLE sleepLog(
			\trecnum INT NOT NULL IDENTITY(1,1) CONSTRAINT PK_sleepLog PRIMARY KEY
			\t, guardID INT NOT NULL
			\t, minute INT NOT NULL
			\t, asleep BIT NOT NULL
			)""";
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
				Logger.getGlobal().log(Level.SEVERE, e, () -> "Statement failed: \"" + sql + "\"");
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
		
		String insert = """
			INSERT INTO sleepLog(guardID, minute, asleep)
			SELECT ?, minute, ?""";
		
		String sql = """
			SELECT 
			\ttimestamp
			\t, action
			FROM actionLog
			ORDER BY timestamp""";
		ResultSet results = getResult(sql);
		
		while( results.next() ) {
			if( results.getString(ACTION).contains("Guard") ) {
				guardID = parseGuardID(results.getString(ACTION));
			}
			
			if( results.getString(ACTION).contains("falls asleep") ) {
				asleep = true;
				minute = results.getInt("minute");
				Object[] params = {Integer.valueOf(guardID), Integer.valueOf(minute), Boolean.valueOf(asleep)};
				queryExecute(insert, params);
			}
			if( results.getString(ACTION).contains("wakes up") ) {
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
