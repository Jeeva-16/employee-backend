package com.example.employee_register.Controller;

import com.example.employee_register.Entity.Employee;
import com.example.employee_register.Sercice.EmpService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.util.List;

@Controller
@AllArgsConstructor
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping("/index")
    public String index(Model model){
        List<Employee> employee=empService.getAllEmp();
        model.addAttribute("empList",employee);
        return "index";
    }

    @GetMapping("/add/{id}")
    public String regForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "add";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        empService.saveEmp(employee);
        return "redirect:/index";
    }
    @GetMapping("/updateForm/{id}")
    public String updateForm(@PathVariable("id") long id,Model model){
        Employee employee = empService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return"updateForm";
    }
    @PostMapping("/updateEmployees/{id}")
    public String updateEmployee(@PathVariable("id") Long id, @ModelAttribute("employee") Employee updatedEmployee){
        empService.updateEmp(id,updatedEmployee );
        return "redirect:/index";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id, Model model) {
        empService.deleteEmp(id);
        return "redirect:/index";
    }
    @GetMapping("/viewEmployee/{id}")
    public String viewEmployee(@PathVariable Long id, Model model) {
        // Retrieve the employee by ID
        Employee employee = empService.getEmployeeById(id);


        // Add the employee to the model to pass it to the view
        model.addAttribute("employee", employee);

        // Return the name of the view to render
        return "viewEmployee";
    }

}
