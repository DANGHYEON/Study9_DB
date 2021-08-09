package com.iu.s1;

import java.sql.Connection;

import com.iu.s1.location.LocationDAO;
import com.iu.s1.util.DBConnect;

public class Study9Main {

	public static void main(String[] args) {
		
		LocationDAO locationDAO = new LocationDAO();
		locationDAO.getList();

	}

}
