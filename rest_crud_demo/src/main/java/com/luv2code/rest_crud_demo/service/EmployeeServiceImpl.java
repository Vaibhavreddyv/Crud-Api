package com.luv2code.rest_crud_demo.service;

import com.luv2code.rest_crud_demo.dao.EmployeeRepository;
import com.luv2code.rest_crud_demo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{



    private EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<Employee> findAll() {


        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;
        if(result.isPresent()){
              theEmployee= result.get();
        }
        else{
            throw new RuntimeException("Did not find employee id "+ theId);
        }

        return theEmployee;
    }

    @Override

    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override

    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);

    }
}
