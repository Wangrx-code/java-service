package com.pj.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
private static ComboPooledDataSource cpds;
	
	static {
		cpds=new ComboPooledDataSource("Connection");
	}
	
	public static DataSource getDataSource(){
		return cpds;
	}
	
	public static Connection getConnection() throws SQLException{
		return cpds.getConnection();
	}
}
