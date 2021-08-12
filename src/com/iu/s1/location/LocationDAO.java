package com.iu.s1.location;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iu.s1.util.DBConnect;

public class LocationDAO {
	
	private DBConnect dbConnect;
	
	public LocationDAO() {
		dbConnect = new DBConnect();
	}
	
	//List
	public ArrayList<LocationDTO> getList() {
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs =null;
		LocationDTO result = null;
		try {
			con = dbConnect.getConnect();
			
			String sql="SELECT * FROM LOCATIONS ORDER BY LOCATION_ID ASC";
			
			st = con.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				result = new LocationDTO();
				result.setLocation_id(rs.getInt("LOCATION_ID"));
				result.setStreet_address("STREET_ADDRESS");
				result.setPostal_code("POSTAL_CODE");
				result.setCity("CITY");
				result.setState_province("STATE_PROVINCE");
				result.setCountry_id("COUNTRY_ID");
				
				ar.add(result);
			}
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		
		return ar;
		
		
	}
	
	//One
	public LocationDTO getOne(LocationDTO location) {
		Connection con=null;
		PreparedStatement st =null;
		ResultSet rs = null;
		LocationDTO result =null;
		
		try {
			con = dbConnect.getConnect();
			
			String sql="SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
			
			st = con.prepareStatement(sql);
			
			st.setInt(1, location.getLocation_id());
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				result = new LocationDTO(); //객체 생성
				result .setLocation_id(rs.getInt(1));
				result.setStreet_address("STREET_ADDRESS");
				result.setPostal_code("POSTAL_CODE");
				result.setCity("CITY");
				result.setState_province("STATE_PROVINCE");
				result.setCountry_id("COUNTRY_ID");
				
				
			}else {
				System.out.println("조회 실패");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		
		return result;
		
	}
	
	

}
