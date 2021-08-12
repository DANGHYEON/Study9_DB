package com.iu.s1.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iu.s1.employee.EmployeeDTO;
import com.iu.s1.util.DBConnect;

public class DepartmentDAO {
	private DepartmentDTO departmentDTO;
	private DBConnect dbConnect;
	
	
	public DepartmentDAO() {
		// TODO Auto-generated constructor stub
		departmentDTO = new DepartmentDTO();
		dbConnect = new DBConnect();
	}
	
	
	
	public int setInsert(DepartmentDTO departmentDTO) {
		Connection con=null;
		PreparedStatement st=null;
		int result = 0;
		
		try {
			con=dbConnect.getConnect();
			
			String sql= "INSERT INTO DEPARTMENTS VALUES(?,?,?,?)";
			
			st = con.prepareStatement(sql);
			
			
			st.setInt(1, departmentDTO.getDepartment_id());
			st.setString(2, departmentDTO.getDepartment_name());
			st.setInt(3, departmentDTO.getManager_id() );
			st.setInt(4, departmentDTO.getLocation_id());
			
			result = st.executeUpdate(); // INSERT, UPDATE, DELETE 쓸때 이걸 사용
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		return result;
		
	}
	
	
	
	
	
	//(DepartmentDTO aa)
	public Depart_EmpDTO getJoin(DepartmentDTO aa) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Depart_EmpDTO depart_EmpDTO=null;
		try {
			con = dbConnect.getConnect();
			String sql ="SELECT E.LAST_NAME, E.SALARY, E.HIRE_DATE, D.DEPARTMENT_NAME FROM EMPLOYEES E inner join DEPARTMENTS D USING(DEPARTMENT_ID)"
					+ "WHERE DEPARTMENT_ID =?";
			
			st = con.prepareStatement(sql);
			
			st.setInt(1, aa.getDepartment_id());
			
			rs= st.executeQuery();
			
			depart_EmpDTO = new Depart_EmpDTO();
			depart_EmpDTO.setAr(new ArrayList<EmployeeDTO>());
			
			while(rs.next()) {
				EmployeeDTO eDto = new EmployeeDTO();
				eDto.setLast_name(rs.getString("LAST_NAME"));
				eDto.setSalary(rs.getInt("salary"));
				eDto.setHire_date(rs.getString("hire_date"));
				depart_EmpDTO.getAr().add(eDto);
				depart_EmpDTO.setDepartment_name(rs.getString("department_name"));
				
			}
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		
		
		return depart_EmpDTO;
		
		
	}
	
	

}
