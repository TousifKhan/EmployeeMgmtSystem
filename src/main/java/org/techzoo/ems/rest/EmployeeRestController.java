package org.techzoo.ems.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.techzoo.ems.entity.Employee;
import org.techzoo.ems.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

	@Autowired EmployeeService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}
	
	@CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id){
        try
        {
        	Employee tempUser = service.getEmployeeById(id);
            return new ResponseEntity<Employee>(tempUser, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }

    }
	
}
