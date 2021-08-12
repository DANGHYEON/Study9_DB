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
	
	
	
	public int insert(LocationDTO locationDTO) {
		Connection con=null;
		PreparedStatement st =null;
		int result=0;
		
		try {
			con= dbConnect.getConnect();
			
			String sql="INSERT INTO LOCATIONS VALUES(?,?,?,?,?,?)";
			
			st= con.prepareStatement(sql);
			
			st.setInt(1, locationDTO.getLocation_id());
			st.setString(2, locationDTO.getStreet_address());
			st.setString(3, locationDTO.getPostal_code());
			st.setString(4, locationDTO.getCity());
			st.setString(5, locationDTO.getState_province());
			st.setString(6, locationDTO.getCountry_id());
			
			result = st.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(st, con);
		}
		return result;
	}
	
	
	public int delete(LocationDTO locationDTO) {
		Connection con=null;
		PreparedStatement st = null;
		int result=0;
		try {
			con = dbConnect.getConnect();
			
			String sql="DELETE LOCATIONS WHERE LOCATION_ID=?";
			
			st = con.prepareStatement(sql);
			
			st.setInt(1, locationDTO.getLocation_id());
			
			result = st.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(st, con);
			
		}
		
		return result;
		
		
	}
	
	
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
				result.setLocation_id(rs.getInt(1));
				result.setStreet_address(rs.getString(2));
				result.setPostal_code(rs.getString(3));
				result.setCity(rs.getString(4));
				result.setState_province(rs.getString(5));
				result.setCountry_id(rs.getString(6));
				
				
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
