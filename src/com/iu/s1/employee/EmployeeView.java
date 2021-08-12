package com.iu.s1.employee;

import java.util.ArrayList;

public class EmployeeView {

	
	public void view(Emp_DepartDTO dto) {
		
		System.out.println(dto.getFirst_name());
		System.out.println(dto.getLast_name());
		System.out.println(dto.getSalary());
		System.out.println(dto.getHire_date());
		System.out.println(dto.getDepartmentDTO().getDepartment_name());
		
	}
	
	
	
	
	public void view(ArrayList<EmployeeDTO> ar) {
		
		for(int i = 0; i<ar.size(); i++) {
			
			this.view(ar.get(i));
			
		}
		
	}
	
	
	
	public void view(double avg) {
		System.out.println("Avg : "+avg);
	}
	
	
	public void view(EmployeeDTO employeeDTO) {
		
		System.out.println(employeeDTO.getEmployee_id());
		System.out.println(employeeDTO.getFirst_name());
		System.out.println(employeeDTO.getLast_name());
		System.out.println(employeeDTO.getEmail());
		System.out.println(employeeDTO.getPhone_number());
		System.out.println(employeeDTO.getDepartment_id());
		
	}
}
