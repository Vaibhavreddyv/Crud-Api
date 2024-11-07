package com.luv2code.rest_crud_demo.dao;

import com.luv2code.rest_crud_demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
