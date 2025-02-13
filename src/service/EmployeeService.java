package service;

import model.Employee;


public interface EmployeeService {
	
	//create
	void addEmployee(Employee employee);
	
	//read
	Employee Login(String username, String password);
	boolean isUsernameBeenUse(String username);
	boolean isEmployeenoBeenUse(String employeeno);
	Employee findByEmployeeno(String employeeno);
	
	//update
	void updateEmployee( Employee employee);
	
	//delete
	void deleteEmployeeById(int id);

}
