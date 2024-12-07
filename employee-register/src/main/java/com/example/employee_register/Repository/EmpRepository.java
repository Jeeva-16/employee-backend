package com.example.employee_register.Repository;

import com.example.employee_register.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpRepository extends JpaRepository<Employee,Long> {
  Optional<Employee> findById(Long id);
}
