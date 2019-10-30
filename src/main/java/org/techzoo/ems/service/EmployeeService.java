package org.techzoo.ems.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.techzoo.ems.dao.EmployeeDao;
import org.techzoo.ems.entity.Employee;

@Service("employeeService")
public class EmployeeService {

	@Autowired 
	@Qualifier("jdbcDao")
	private EmployeeDao dao;
	
	public Collection<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}
	
	public Employee getEmployeeById(int id) {
		return dao.getEmployeeById(id);
	}
	
	public void insertEmployee(Employee e){
		dao.insertEmployee(e);
	}
	
	public void deleteEmployee(String empId){
		dao.removeEmployee(empId);
	}
	
	public void updateEmployee(Employee e){
		dao.upateEmployee(e);
	}
	
}
