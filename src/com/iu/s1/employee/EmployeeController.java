package com.iu.s1.employee;

public class EmployeeController {

	private EmployeeDTO employeeDTO;
	private EmployeeDAO employeeDAO;
	private Emp_DepartDTO emp_DepartDTO;
	private EmployeeView employeeView;
	
	public EmployeeController() {
		// TODO Auto-generated constructor stub
		employeeDAO = new EmployeeDAO();
		employeeDTO = new EmployeeDTO();
		emp_DepartDTO = new Emp_DepartDTO();
		employeeView = new EmployeeView();
	
	}
	
	
	public void start() {
		
		Emp_DepartDTO samp1 = employeeDAO.getJoin(101);
		employeeView.view(samp1);
		
		
		
		
	}
	
	
}
