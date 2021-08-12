package com.iu.s1.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.iu.s1.department.DepartmentDTO;
import com.iu.s1.util.DBConnect;

public class EmployeeDAO {
	
	private com.iu.s1.util.DBConnect dbConnect;
	
	public EmployeeDAO() {
		dbConnect = new DBConnect();
	}
	
	
	public Emp_DepartDTO getJoin(int em) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Emp_DepartDTO emp_DepartDTO = null;
		DepartmentDTO departmentDTO =null;
		
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT E.FIRST_NAME, E.LAST_NAME, E.SALARY, E.HIRE_DATE, D.DEPARTMENT_NAME FROM EMPLOYEES E inner join DEPARTMENTS D USING(DEPARTMENT_ID)"
					+ "WHERE E.EMPLOYEE_ID =?";
			
			st = con.prepareStatement(sql);
			
			st.setInt(1, em);
			
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				emp_DepartDTO = new Emp_DepartDTO();
				departmentDTO = new DepartmentDTO(); // emp_DepartDTO(new DepartmentDTO));
				emp_DepartDTO.setFirst_name(rs.getString("FIRST_NAME"));
				emp_DepartDTO.setLast_name(rs.getString("LAST_NAME"));
				emp_DepartDTO.setSalary(rs.getInt("SALARY"));
				emp_DepartDTO.setHire_date(rs.getString("HIRE_DATE"));
				departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
				emp_DepartDTO.setDepartmentDTO(departmentDTO);
				
				
			}else {
				System.out.println("데이터가 없어용");
			}
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		
		return emp_DepartDTO;
		
	}
	
	
	
	
	
	public ArrayList<EmployeeDTO> getList() {
		
		ArrayList<EmployeeDTO> a1 = new ArrayList<EmployeeDTO>();
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection con = null;
		EmployeeDTO employeeDTO;
		
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT * FROM EMPLOYEES";
			
			st =con.prepareStatement(sql);
			
			rs =st.executeQuery();
			
			while(rs.next()) {
				employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
				employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
				employeeDTO.setLast_name(rs.getString("LAST_NAME"));
				employeeDTO.setEmail(rs.getString("EMAIL"));
				employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
				employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
				
				a1.add(employeeDTO);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		
		return a1;
		
	}
	
	
	public EmployeeDTO getOne(int employee_id) {
		Connection con = null;
		PreparedStatement st=null;
		ResultSet rs = null;
		EmployeeDTO employeeDTO = null;
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
			
			st= con.prepareStatement(sql);
			
			st.setInt(1, employee_id);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
				employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
				employeeDTO.setLast_name(rs.getString("LAST_NAME"));
				employeeDTO.setEmail(rs.getString("EMAIL"));
				employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
				employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			}else {
				System.out.println("없어용");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		
		return employeeDTO;
		
		
	}
	
	public ArrayList<EmployeeDTO> searchL(String Last_name) {
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		Connection con=null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmployeeDTO employeeDTO = null;
		
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT * FROM EMPLOYEES WHERE LIKE ?";
			
			
			st = con.prepareStatement(sql);
			
			st.setString(1,'%'+Last_name+'%');
			
			rs= st.executeQuery();
			
			while(rs.next()) {
				employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
				employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
				employeeDTO.setLast_name(rs.getString("LAST_NAME"));
				employeeDTO.setEmail(rs.getString("EMAIL"));
				employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
				employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
				
				ar.add(employeeDTO);
			}
			
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		
		return ar;
		
	}
	
	
	
	public ArrayList<EmployeeDTO> searchF(String First_name) {
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		Connection con=null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmployeeDTO employeeDTO = null;
		
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT * FROM EMPLOYEES WHERE LIKE ?";
			
			
			st = con.prepareStatement(sql);
			
			st.setString(1,'%'+First_name+'%');
			
			rs= st.executeQuery();
			
			while(rs.next()) {
				employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
				employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
				employeeDTO.setLast_name(rs.getString("LAST_NAME"));
				employeeDTO.setEmail(rs.getString("EMAIL"));
				employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
				employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
				
				ar.add(employeeDTO);
			}
			
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		
		return ar;
		
	}
	
	public double allavg() {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		double avg = 0.0;
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT AVG(SALARY) FROM EMPLOYEES";
			
			st = con.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			avg = rs.getDouble("AVG(SALARY)");
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
			
		}
		
		
		return avg;
		
		
	}
	
	
	
	public void dpAvg() {
		HashMap<String, Object> obj = new HashMap<String, Object>();
		obj.put("id", 20);
		obj.put("avg", 1000.12);
		// map으로 활용
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmployeeDTO employeeDTO =null;
		
		try {
			
			con = st.getConnection();
			
			String spl = "SELECT DEPARTMENT_ID, AVG(SALARY) FROM EMPLOYEES GROUP BY DEPARTMENT_ID";
			
			st = con.prepareStatement(spl);
			
			rs = st.executeQuery();
			
		
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
			
		}
		
		
		
	}
	
	
	


}
