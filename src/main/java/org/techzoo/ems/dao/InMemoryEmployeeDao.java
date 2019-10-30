package org.techzoo.ems.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.techzoo.ems.entity.Employee;
import org.techzoo.ems.util.Department;

@SuppressWarnings("serial")
@Repository("employeeDao")
public class InMemoryEmployeeDao implements EmployeeDao {

	private static Map<String, Employee> employees = new HashMap<String, Employee>();
			
	static {
		employees.put("1001", new Employee(1001, "Tousif", Department.IT, 20000D));
		employees.put("1002", new Employee(1002, "Asif", Department.Finance, 22000D));
		employees.put("1003", new Employee(1003, "Rehan", Department.IT, 32000D));
		employees.put("1004", new Employee(1004, "Rizwan", Department.Management, 50000D));
		employees.put("1005", new Employee(1005, "Ramiz", Department.Security, 15000D));
		employees.put("1006", new Employee(1006, "Rojer", Department.IT, 12000D));
		employees.put("1007", new Employee(1007, "Suman", Department.Security, 28000D));
		employees.put("1008", new Employee(1008, "Zeba", Department.Service, 16000D));
		employees.put("1009", new Employee(1009, "Maryam", Department.Finance, 12000D));
		employees.put("1010", new Employee(1010, "Zahir Khan", Department.HR, 38000D));
		employees.put("1011", new Employee(1011, "Ayesha", Department.IT, 34000D));
	}
	
	@Override
	public Employee getEmployeeById(int empId) {
		return employees.get(empId);
	}

	@Override
	public Collection<Employee> getAllEmployees() {
		return employees.values();
	}

	@Override
	public void upateEmployee(Employee e) {
		Employee tmp = employees.get(e.getId());
		tmp.setDepartment(e.getDepartment());
		tmp.setName(e.getName());
		tmp.setSalary(e.getSalary());
		employees.put(e.getId()+"", tmp);
	}

	@Override
	public void insertEmployee(Employee e) {
		employees.put(e.getId()+"", e);
	}

	@Override
	public void removeEmployee(String empId) {
		employees.remove(empId);
	}

}
