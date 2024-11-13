package com.luv2code.rest_crud_demo.service;

import com.luv2code.rest_crud_demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById( int theid);

    Employee save(Employee theEmployee);

    void deleteById(int theid);
}
