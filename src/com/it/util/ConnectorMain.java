package com.it.util;

public class ConnectorMain {

	public static void main(String[] args) {
		DBConnector dbConnector = new DBConnector();
		
		try {
			dbConnector.getConnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
