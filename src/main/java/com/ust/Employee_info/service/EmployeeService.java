package com.ust.Employee_info.service;

import com.ust.Employee_info.model.Employee;
import com.ust.Employee_info.exception.ResourceNotFoundException;
import com.ust.Employee_info.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(int empid) {
        return employeeRepository.findById(empid);
    }

    public Employee updateEmployee(int empid, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(empid).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        employee.setName(employeeDetails.getName());
        employee.setBasicSalary(employeeDetails.getBasicSalary());
        employee.setGrade(employeeDetails.getGrade());
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(int empid) {
        Employee employee = employeeRepository.findById(empid).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        employeeRepository.delete(employee);
    }
}

