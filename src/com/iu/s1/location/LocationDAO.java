package com.iu.s1.location;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iu.s1.util.DBConnect;

public class LocationDAO {
	
	private DBConnect dbConnect;
	
	public LocationDAO() {
		dbConnect = new DBConnect();
	}
	
	public void getOne1(int location_id) {
		
		PreparedStatement st =null;
		ResultSet rs = null;
		Connection con = null;
		
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
			
			st = con.prepareStatement(sql);
			st.setInt(1, location_id);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getString("DEPARTMENT_NAME"));
			}else {
				System.out.println("없어용");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}

	}
	
	
	
	public void getList() {
		String user = "user02";
		String password = "user02";
		
		String url = "jdbc:oracle:thin:@localhost:1522:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection co = null;
		PreparedStatement st = null;
		ResultSet re  = null;
		try {
			
			Class.forName(driver);
			System.out.println("Driver 연결 성공");
			
			co = DriverManager.getConnection(url, user, password);
			System.out.println("접속 성공");
			System.out.println(co);
			
			String sql="SELECT * FROM LOCATIONS";
			
			 st = co.prepareStatement(sql);
			
			 re = st.executeQuery();
			
			while(re.next()) {
				 System.out.println(re.getInt("LOCATION_ID")+"\t");
				 System.out.println(re.getString("STREET_ADDRESS")+"\t");
				 System.out.println(re.getString("POSTAL_CODE")+"\t");
				 System.out.println(re.getString("CITY")+"\t");
				 System.out.println(re.getString("STATE_PROVINCE")+"\t");
				 System.out.println(re.getString("COUNTRY_ID"));
				 System.out.println("----------------");
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
	}
	
	
	public void getOne() {
		//1. 연결 정보
		String user ="user02";
		String password="user02";
		String url = "jdbc:oracle:thin:@localhost:1522:xe";
		Connection con =null;
		PreparedStatement st =null;
		ResultSet rs = null;
		
		// connection
		try {
			con = DriverManager.getConnection(url,user,password);
			System.out.println("접속 완료");
			int id =40;
			
			// sql문 생성
			String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";
			
			// 미리 전송
			st=con.prepareStatement(sql);
			
			// ?값을 설정
			//setXXXX(?의 인덱스번호, 값)
			st.setInt(1, id);
			
			//최종 전송
			rs =st.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getString("DEPARTMENT_NAME"));
			}else {
				System.out.println("읎어요");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
			
		}
		
		
		
	}
	
	public void getCount() {
	
		Connection con=null;
		PreparedStatement st =null;
		ResultSet rs = null;
		
		try {
			
			String sql="SELECT COUNT(DEPARTMENT_ID) FROM DEPARTMENTS";
			
			
			st=con.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			rs.next(); //읽어야 데이터가 나온다!
			
			System.out.println(rs.getInt("COUNT(DEPARTMENT_ID)"));
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
			
		}
		
		
		
		
	}
	
	

}
