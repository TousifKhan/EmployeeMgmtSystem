package org.techzoo.ems.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.techzoo.ems.entity.Employee;

@SuppressWarnings("serial")
@Repository("employeeDao")
//@Qualifier("employeeDao")
public class InMemoryEmployeeDao implements EmployeeDao {

	private static Map<String, Employee> employees = new HashMap<String, Employee>();
			
	static {
		employees.put("1001", new Employee("1001", "Tousif", "IT", 20000D));
		employees.put("1002", new Employee("1002", "Asif", "Service", 22000D));
		employees.put("1003", new Employee("1003", "Rehan", "HR", 32000D));
	}
	
	@Override
	public Employee getEmployeeById(String empId) {
		return employees.get(empId);
	}

	@Override
	public Collection<Employee> getAllEmployees() {
		return employees.values();
	}

	@Override
	public void upateEmployee(Employee e) {
		Employee tmp = employees.get(e.getEmpId());
		tmp.setDepartment(e.getDepartment());
		tmp.setName(e.getName());
		tmp.setSalary(e.getSalary());
		employees.put(e.getEmpId(), tmp);
	}

	@Override
	public void insertEmployee(Employee e) {
		employees.put(e.getEmpId(), e);
	}

	@Override
	public void removeEmployee(String empId) {
		employees.remove(empId);
	}

}
