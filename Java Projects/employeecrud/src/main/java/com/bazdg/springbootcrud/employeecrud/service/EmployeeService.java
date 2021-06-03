package com.bazdg.springbootcrud.employeecrud.service;

import com.bazdg.springbootcrud.employeecrud.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> get();

    Employee get(int id);

    void save(Employee employee);

    void delete(int id);
}
