package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.converter.EmployeeConverter;
import com.example.employeepayrollapp.dto.EmployeeDto;
import com.example.employeepayrollapp.dto.ResponseDto;
import com.example.employeepayrollapp.model.EmployeeModel;
import com.example.employeepayrollapp.repository.EmployeeRepo;
import com.example.employeepayrollapp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ResponseDto> add(@RequestBody EmployeeModel employeeModel) {
        employeeService.save(employeeModel);
        ResponseDto responseDto = new ResponseDto("New Employee Added", employeeModel);
        ResponseEntity<ResponseDto> response = new ResponseEntity(responseDto, HttpStatus.OK);
        return response;
    }

    @PostMapping("/addGreets")
    public List<EmployeeModel> add(@RequestBody List<EmployeeModel> employeeModel) {
        return employeeService.save(employeeModel);
    }

    //Get Api
    @GetMapping("/getGreet")
    public List<EmployeeModel> findAllGreet() {
        EmployeeModel employeeModel = (EmployeeModel) employeeService.get();
        ResponseDto responseDto = new ResponseDto("getting all empdata" , employeeModel);
        ResponseEntity<ResponseDto>response = new ResponseEntity<>(responseDto,HttpStatus.OK);
        return (List<EmployeeModel>) response;
    }

    //get by id
    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseDto> findProductById(@PathVariable int id) {
        EmployeeModel employeeModel = employeeService.getById(id);
        ResponseDto responseDto = new ResponseDto("getting by id" , employeeModel);
        ResponseEntity<ResponseDto>response = new ResponseEntity<>(responseDto,HttpStatus.OK);
        return response;
    }

    //put
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateGreets(@RequestBody EmployeeModel employeeModel) {
        employeeService.updateById(employeeModel);
        ResponseDto responseDto = new ResponseDto("updating emp data" , employeeModel);
        ResponseEntity<ResponseDto>response = new ResponseEntity<>(responseDto,HttpStatus.OK);
        return response;
    }

    //delete
    @DeleteMapping("/Delete/{id}")
    public  ResponseEntity<ResponseDto> deleteGreet(@PathVariable int id) {
        employeeService.deleteById(id);
        EmployeeModel employeeModel = new EmployeeModel();
        ResponseDto responseDto = new ResponseDto("getting by id" , employeeModel);
        ResponseEntity<ResponseDto>response = new ResponseEntity<>(responseDto,HttpStatus.OK);
        return response;
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
