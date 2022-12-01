package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.model.EmployeeModel;
import com.example.employeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //Post Api
    @PostMapping("/add")
    public EmployeeModel add(@RequestBody EmployeeModel employeeModel) {
        return employeeService.save(employeeModel);
    }

    @PostMapping("/addGreets")
    public List<EmployeeModel> add(@RequestBody List<EmployeeModel> employeeModel) {
        return employeeService.save(employeeModel);
    }

    //Get Api
    @GetMapping("/getGreet")
    public List<EmployeeModel> findAllGreet() {
        return employeeService.get();
    }

    //get by id
    @GetMapping("/getById/{id}")
    public EmployeeModel findProductById(@PathVariable int id) {
        return employeeService.getById(id);
    }

    //put
    @PutMapping("/Update")
    public EmployeeModel updateGreets(@RequestBody EmployeeModel employeeModel) {
        return employeeService.updateById(employeeModel);
    }

    //delete
    @DeleteMapping("/Delete/{id}")
    public String deleteGreet(@PathVariable int id) {
        return employeeService.deleteById(id);
    }
}
