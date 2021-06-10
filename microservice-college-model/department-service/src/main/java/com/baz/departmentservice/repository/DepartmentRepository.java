package com.baz.departmentservice.repository;

import com.baz.departmentservice.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long > {

    public Department findByDepartmentId(Long departmentId);
}
