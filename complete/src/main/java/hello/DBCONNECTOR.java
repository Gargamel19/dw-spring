package hello;

/* Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.*/
/*
   DESCRIPTION    
   The code sample shows how to use the DataSource API to establish a connection
   to the Database. You can specify properties with "setConnectionProperties".
   This is the recommended way to create connections to the Database.

   Note that an instance of oracle.jdbc.pool.OracleDataSource doesn't provide
   any connection pooling. It's just a connection factory. A connection pool,
   such as Universal Connection Pool (UCP), can be configured to use an
   instance of oracle.jdbc.pool.OracleDataSource to create connections and 
   then cache them.
    
    Step 1: Enter the Database details in this file. 
            DB_USER, DB_PASSWORD and DB_URL are required
    Step 2: Run the sample with "ant DataSourceSample"
  
   NOTES
    Use JDK 1.7 and above

   MODIFIED    (MM/DD/YY)
    nbsundar    02/17/15 - Creation 
 */

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.json.JSONException;

import oracle.jdbc.pool.OracleDataSource;
import oracle.jdbc.OracleConnection;
import java.sql.DatabaseMetaData;

public class DBCONNECTOR {
	final static String DB_URL = "jdbc:oracle:thin:@ora14.informatik.haw-hamburg.de:1521:inf14";
	final static String DB_USER = "acf040";
	final static String DB_PASSWORD = "";

	static OracleConnection oracleConnection = null;
	
	
	public void setup() throws SQLException {
		Properties info = new Properties();
		info.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, DB_USER);
		info.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, DB_PASSWORD);
		info.put(OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH, "20");

		OracleDataSource ods = new OracleDataSource();
		ods.setURL(DB_URL);
		ods.setConnectionProperties(info);

		try {
			oracleConnection = (OracleConnection) ods.getConnection();
			DatabaseMetaData dbmd = oracleConnection.getMetaData();
			System.out.println("Driver Name: " + dbmd.getDriverName());
			System.out.println("Driver Version: " + dbmd.getDriverVersion());
			System.out.println("Default Row Prefetch Value is: " + oracleConnection.getDefaultRowPrefetch());
			System.out.println("Database Username is: " + oracleConnection.getUserName());
			System.out.println();
		} catch (Exception e) {
		}
	}
	
	public String get(String table) throws SQLException, IOException, JSONException {
		try (Statement statement = oracleConnection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery("select * from "+table)) {

				String msg = ResultSet2JSON.convert(resultSet).toString();
				return msg;
			}
		}
	}

}
