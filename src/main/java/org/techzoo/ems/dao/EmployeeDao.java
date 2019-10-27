package org.techzoo.ems.dao;

import java.util.Collection;

import org.techzoo.ems.entity.Employee;

public interface EmployeeDao {

	Employee getEmployeeById(String empId);

	Collection<Employee> getAllEmployees();

	void upateEmployee(Employee e);

	void insertEmployee(Employee e);
	
	void removeEmployee(String empId);

}
