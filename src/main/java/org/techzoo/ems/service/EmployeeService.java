package org.techzoo.ems.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techzoo.ems.dao.InMemoryEmployeeDao;
import org.techzoo.ems.entity.Employee;

@Service
public class EmployeeService {

	@Autowired private InMemoryEmployeeDao dao;
	
	public Collection<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}
	
	public Employee getEmployeeById(String id) {
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
