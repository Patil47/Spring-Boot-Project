package com.jsp.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.jsp.entity.EmployeeEntity;
import com.jsp.model.Employee;
import com.jsp.repository.EmployeeRepository;

@Service
@ComponentScan(basePackages = "com.jsp.repository")
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    public List<Employee> getEmployees() {
        List<EmployeeEntity> employeeList = employeeRepository.findAll();
        ArrayList<Employee> employees = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeList) {
            Employee employee = new Employee();
            employee.setId(employeeEntity.getId());
            employee.setName(employeeEntity.getName());
            employee.setNumber(employeeEntity.getNumber());
            employee.setLocation(employeeEntity.getLocation());
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public String addEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return "Added Successfully";
        
    }

    @Override
    public String removeEmployee(long id) {
        EmployeeEntity emp = employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
        return "Deleted Successfully";        
    }

    @Override
    public Employee getEmployee(long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
        
    }

    @Override
    public String updateEmployee(long id, Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeEntity.setName(employee.getName());
        employeeEntity.setNumber(employee.getNumber());
        employeeEntity.setLocation(employee.getLocation());
        employeeRepository.save(employeeEntity);
        return "Updated Successfully";
        
    }

}
