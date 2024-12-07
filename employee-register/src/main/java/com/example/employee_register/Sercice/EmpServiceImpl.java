package com.example.employee_register.Sercice;


import com.example.employee_register.Entity.Employee;
import com.example.employee_register.Repository.EmpRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService{
    @Autowired
    private EmpRepository empRepository;


    @Override
    public List<Employee> getAllEmp() {
        return empRepository.findAll();
    }

    @Override
    public void saveEmp(Employee employee) {
         empRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> optional = empRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new RuntimeException("Employee Not Found"+id);
        }
    }

    @Override
    public void updateEmp(Long id, Employee employee) {
      Optional<Employee> optionalEmployee = empRepository.findById(id);
      if(optionalEmployee.isPresent()){
          Employee existingEmployee = optionalEmployee.get();
          existingEmployee.setEmpName(employee.getEmpName());
          existingEmployee.setRole(employee.getRole());
          existingEmployee.setEmail(employee.getEmail());
          empRepository.save(existingEmployee);


      }
    }

    @Override
    public void deleteEmp(long id) {
       empRepository.deleteById(id);
    }
}
