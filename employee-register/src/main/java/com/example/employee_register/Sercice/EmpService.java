package com.example.employee_register.Sercice;


import com.example.employee_register.Entity.Employee;

import java.util.List;

public interface EmpService {
    List<Employee> getAllEmp();
     void saveEmp(Employee employee);
    Employee getEmployeeById(Long id);
    void updateEmp(Long id, Employee employee);
    void deleteEmp(long id);

}
