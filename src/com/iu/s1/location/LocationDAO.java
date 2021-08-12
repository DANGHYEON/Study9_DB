package com.iu.s1.location;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.iu.s1.util.DBConnect;

public class LocationDAO {
	
	private DBConnect dbConnect;
	
	public LocationDAO() {
		dbConnect = new DBConnect();
	}
	
	
	public LocationDTO getLocation(int employee_id) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		LocationDTO locationDTO = null;
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID="
					+ " (SELECT LOCATION_ID FROM DEPARTMENTS WHERE DEPARTMENT_ID="
					+ " (SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE EMPLOYEE_ID = ?))";
			st= con.prepareStatement(sql);
			
			st.setInt(1, employee_id);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				locationDTO = new LocationDTO();
				locationDTO.setLocation_id(rs.getInt("location_id"));
				locationDTO.setStreet_address(rs.getString("street_address"));
				locationDTO.setPostal_code(rs.getString("postal_code"));
				locationDTO.setCity(rs.getString("city"));
				locationDTO.setState_province(rs.getString("state_province"));
				locationDTO.setCountry_id(rs.getString("country_id"));
			}else {
				System.out.println("없어용");
			}
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
			
		}
		
		return locationDTO;
		
		
		
	}
	
	
	
	
	
	
	
	//location table에서 id와 일치하는 정보를 조회
	public LocationDTO getOne1(int location_id) {
		
		//ADD-DTO Branch
		
		PreparedStatement st =null;
		ResultSet rs = null;
		Connection con = null;
		LocationDTO locationDTO = null;
		
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
			
			st = con.prepareStatement(sql);
			st.setInt(1, location_id);
			
			rs = st.executeQuery();
			
			
			if(rs.next()) {
				locationDTO = new LocationDTO();
				locationDTO.setLocation_id(rs.getInt("location_id"));
				locationDTO.setStreet_address(rs.getString("street_address"));
				locationDTO.setPostal_code(rs.getString("postal_code"));
				locationDTO.setCity(rs.getString("city"));
				locationDTO.setState_province(rs.getString("state_province"));
				locationDTO.setCountry_id(rs.getString("country_id"));
			}else {
				System.out.println("없어용");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}

		return locationDTO;
	}
	
	
	
	// location 정보 출력
	public ArrayList<LocationDTO> getList() {
		
		ArrayList<LocationDTO> a1 = new ArrayList<LocationDTO>();
		
		
		Connection co = null;
		PreparedStatement st = null;
		ResultSet re  = null;
		LocationDTO locationDTO = null;
		try {
			

			
			co = dbConnect.getConnect();
			System.out.println("접속 성공");
			System.out.println(co);
			
			String sql="SELECT * FROM LOCATIONS";
			
			 st = co.prepareStatement(sql);
			
			 re = st.executeQuery();
			 
			
			while(re.next()) {
				locationDTO = new LocationDTO();
				
				locationDTO.setLocation_id(re.getInt("location_id"));
				locationDTO.setStreet_address(re.getString("street_address"));
				locationDTO.setPostal_code(re.getString("postal_code"));
				locationDTO.setCity(re.getString("CITY"));
				locationDTO.setState_province(re.getString("STATE_PROVINCE"));
				locationDTO.setCountry_id(re.getString("COUNTRY_ID"));
				
				a1.add(locationDTO);
				
			}
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				re.close();
				st.close();
				co.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return a1;
	}
	
	
	
	
	
	
	public ArrayList<LocationDTO> getSearch(String search) {
		//1. 연결 정보
		Scanner sc = new Scanner(System.in);
		Connection con =null;
		PreparedStatement st =null;
		ResultSet rs = null;
		LocationDTO locationDTO = null;
		ArrayList<LocationDTO> a1 = new ArrayList<LocationDTO>();
		
		// connection
		try {
			con = dbConnect.getConnect();
			System.out.println("접속 완료");
			
			
			// sql문 생성
			String sql = "SELECT * FROM LOCATIONS WHERE STREET_ADDRESS LIKE ?"; // '%'||?||'%'
			
			// 미리 전송
			st=con.prepareStatement(sql);
			
			System.out.println("검색할 주소를 입력하세요");
			
			
			// ?값을 설정
			//setXXXX(?의 인덱스번호, 값)
			st.setString(1,'%'+search+'%');
			
			//최종 전송
			rs =st.executeQuery();
			
			while(rs.next()) {
				locationDTO = new LocationDTO();
				
				locationDTO.setLocation_id(rs.getInt("location_id"));
				locationDTO.setStreet_address(rs.getString("street_address"));
				locationDTO.setPostal_code(rs.getString("postal_code"));
				locationDTO.setCity(rs.getString("CITY"));
				locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
				locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
				
				a1.add(locationDTO);
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
			
		}
		
		return a1;
		
	}
	
	
	public int getCount() {
	
		Connection con=null;
		PreparedStatement st =null;
		ResultSet rs = null;
		int a = 0;
		
		try {
			con = dbConnect.getConnect();
			
			String sql="SELECT COUNT(LOCATION_ID) FROM LOCATIONS";
			
			
			st=con.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			rs.next(); //읽어야 데이터가 나온다!
			
			a = rs.getInt("COUNT(LOCATION_ID)");
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
			
		}
		
		return a;
		
		
	}
	
	
	
	
	

}
