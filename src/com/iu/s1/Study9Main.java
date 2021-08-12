package com.iu.s1;

import java.sql.Connection;

import com.iu.s1.department.Depart_EmpDTO;
import com.iu.s1.department.DepartmentDAO;
import com.iu.s1.department.DepartmentDTO;
import com.iu.s1.employee.EmployeeController;
import com.iu.s1.location.LocationController;
import com.iu.s1.location.LocationDAO;
import com.iu.s1.util.DBConnect;

public class Study9Main {

	public static void main(String[] args) {
		
//		LocationController lc = new LocationController();
//		lc.start();
//		EmployeeController ec = new EmployeeController();
//		ec.start();
		
		DepartmentDAO dao = new DepartmentDAO();
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_id(80);
		
		//d1.setDepartment_id(90)
		Depart_EmpDTO dto = dao.getJoin(departmentDTO);
		
		System.out.println(dto.getDepartment_name());
		
		for(int i=0;i<dto.getAr().size();i++) {
			System.out.println("=============================");
			System.out.println(dto.getAr().get(i).getLast_name());
			System.out.println(dto.getAr().get(i).getSalary());
			System.out.println(dto.getAr().get(i).getHire_date());
			System.out.println("=============================");
		}
		

	}

}
