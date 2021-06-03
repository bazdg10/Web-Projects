package com.bazdg.springbootcrud.employeecrud.dao;
import java.util.List;
import com.bazdg.springbootcrud.employeecrud.model.Employee;

public interface EmployeeDAO {
    List<Employee> get();

    Employee get(int id);

    void save(Employee employee);

    void delete(int id);
}
