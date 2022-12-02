package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.converter.EmployeeConverter;
import com.example.employeepayrollapp.dto.EmployeeDto;
import com.example.employeepayrollapp.model.EmployeeModel;
import com.example.employeepayrollapp.repository.EmployeeRepo;
import com.example.employeepayrollapp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private EmployeeConverter employeeConverter;

    @Autowired
    private EmployeeRepo employeeRepo;

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
    @PutMapping("/update")
    public EmployeeModel updateGreets(@RequestBody EmployeeModel employeeModel) {
        return employeeService.updateById(employeeModel);
    }

    //delete
    @DeleteMapping("/Delete/{id}")
    public String deleteGreet(@PathVariable int id) {
        return employeeService.deleteById(id);
    }

    //dto
    @GetMapping("/findAll")
    public List<EmployeeDto> findAll() {
        List<EmployeeModel> findAll = employeeRepo.findAll();
        return employeeConverter.modelToDtos(findAll);
    }

    @GetMapping("/find/{ID}")
    public EmployeeDto findById(@PathVariable(value = "ID") Integer employeeId) {
        EmployeeModel emp = employeeRepo.findById(employeeId).orElse(null);
        return employeeConverter.modelToDto(emp);
    }

    @PostMapping("/saves")
    public EmployeeDto saves(@RequestBody EmployeeDto employeeDto) {
        EmployeeModel employeeModel = employeeConverter.dtoToEntity(employeeDto);
        employeeModel = employeeRepo.save(employeeModel);
        return employeeConverter.modelToDto(employeeModel);
    }
}
