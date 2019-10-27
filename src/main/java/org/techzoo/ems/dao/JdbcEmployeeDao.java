package org.techzoo.ems.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.techzoo.ems.entity.Employee;

@Repository("jdbcDao")
public class JdbcEmployeeDao implements EmployeeDao {

	@Override
	public List<Employee> getAllEmployees() {
		return null;
	}

	@Override
	public void upateEmployee(Employee e) {
	}

	@Override
	public void insertEmployee(Employee e) {
	}

	@Override
	public Employee getEmployeeById(String empId) {
		return null;
	}

	@Override
	public void removeEmployee(String empId) {
	}

}
