package com.jsp.service;

import java.util.List;

import com.jsp.model.Employee;

public interface EmployeeService {
    public  List<Employee> getEmployees();
    public String addEmployee(Employee employee);
    public String removeEmployee(long id);
    public Employee getEmployee(long id);
    public String updateEmployee(long id, Employee employee);
}
