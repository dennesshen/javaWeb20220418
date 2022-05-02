package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entity.Employee;

public class EmployeeService {
	
	public static final EmployeeService instance = new EmployeeService();
	private List<Employee> employees = new ArrayList<Employee>();
	private Employee employee;
	

	private EmployeeService() {
	}
	
	public static EmployeeService getEmployeeService() {
		return instance;
	}
	
	private void storeIntoList(Employee employee) {
		employees.add(employee);
	}
	
	public EmployeeService transDataToObject(Map<String, String[]> data) {
		employee = new Employee(data.get("employeeName")[0], 
								Integer.parseInt(data.get("employeeAge")[0]), 
								data.get("employeeSex")[0],
								data.get("employeePosition")[0], 
								data.get("employeeBirth")[0], 
								data.get("employeeLanguage"), 
								data.get("employeeMemo")[0]
							   );
		storeIntoList(employee);
		return instance;
	}
	
	public List<Employee> findAll() {
		return employees;
	}
	
}
