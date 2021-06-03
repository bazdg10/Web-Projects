package com.bazdg.springbootcrud.employeecrud.service;

import com.bazdg.springbootcrud.employeecrud.dao.EmployeeDAO;
import com.bazdg.springbootcrud.employeecrud.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public class EmployeeServiceImplementation implements EmployeeService{
    @Autowired
    private EmployeeDAO employeeDAO;

    @Transactional
    @Override
    public List<Employee> get() {
    List<Employee> list =employeeDAO.get();
        return list;
    }
    @Transactional
    @Override
    public Employee get(int id) {
        return employeeDAO.get(id);
    }
    @Transactional
    @Override
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }
    @Transactional
    @Override
    public void delete(int id) {
//     Employee employee = employeeDAO.get(id);
//       if (employee!=null)
       employeeDAO.delete(id);
    }
}
