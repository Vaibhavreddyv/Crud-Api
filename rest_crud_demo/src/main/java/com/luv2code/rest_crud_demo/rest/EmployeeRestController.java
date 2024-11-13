package com.luv2code.rest_crud_demo.rest;


import com.luv2code.rest_crud_demo.entity.Employee;
import com.luv2code.rest_crud_demo.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeServiceImpl employeeService;

    // quick and durty constructor injection

    //constructor injection without autowired
    public EmployeeRestController(EmployeeServiceImpl employeeService){
        this.employeeService =employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee id is not found "+ employeeId);
        }
        return  theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }


    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }


    @DeleteMapping("/employee/{employee_id}")
    public String deleteEMployeeById(@PathVariable int employee_id){

        Employee theEmployee = employeeService.findById(employee_id);

        if(theEmployee == null){
            throw new RuntimeException("Employee id not found -" + employee_id);
        }

        employeeService.deleteById(employee_id);

        return "Deleted employe_id" + employee_id;

    }












}
