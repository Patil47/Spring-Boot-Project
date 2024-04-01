package com.jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.model.Employee;
import com.jsp.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@ComponentScan(basePackages = {"com.jsp.service","com.jsp.repository"})
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("employee")
    public List<Employee> getAllEmployee(){
        return employeeService.getEmployees();
    }

    @PostMapping("employee")
    public String addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("employee/{id}")
    public String removeEmployee(@PathVariable long id){
        return employeeService.removeEmployee(id);
    }

    @PutMapping("employee/{id}")
    public String putMethodName(@PathVariable long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @GetMapping("employee/{id}")
    public Employee getEmployee(@PathVariable long id) {
        return employeeService.getEmployee(id);
    }
    
    
}
