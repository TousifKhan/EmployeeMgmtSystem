package org.techzoo.ems.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.techzoo.ems.entity.Employee;
import org.techzoo.ems.util.Department;

@Repository("jdbcDao")
public class JdbcEmployeeDao implements EmployeeDao {

	@Autowired JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("unused")
	private static class EmployeeRowMapper implements RowMapper<Employee> {

		@Override
		public Employee mapRow(ResultSet rs, int update) throws SQLException {
			return new Employee(
					rs.getInt(1) , 
					rs.getString(2), 
					Department.toEnum(rs.getString(3)), 
					rs.getDouble(4)
				);
		}
		
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query("SELECT * FROM TBL_EMPLOYEES", new EmployeeRowMapper());
	}

	@Override
	public void upateEmployee(Employee e) {
	}

	@Override
	public void insertEmployee(Employee e) {
	}

	@Override
	public Employee getEmployeeById(int empId) {
		return jdbcTemplate.queryForObject("SELECT * FROM TBL_EMPLOYEES WHERE id=?", 
			new Object[] { empId },
			new BeanPropertyRowMapper<Employee>(Employee.class)
		);
	}

	@Override
	public void removeEmployee(String empId) {
	}

}
