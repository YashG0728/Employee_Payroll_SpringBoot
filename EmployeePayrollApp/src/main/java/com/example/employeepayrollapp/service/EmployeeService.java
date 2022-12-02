package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.model.EmployeeModel;
import com.example.employeepayrollapp.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    private List<EmployeeModel> list = new ArrayList();
    @Autowired
    private EmployeeRepo employeeRepo;

    public EmployeeModel save(EmployeeModel employeeModel) {
        list.add(employeeModel);
        return employeeRepo.save(employeeModel);
    }

    //Post method Saved list of Objects
    public List<EmployeeModel> save(List<EmployeeModel> employeeModel) {
        return employeeRepo.saveAll(employeeModel);
    }

    //getmethod return all
    public List<EmployeeModel> get() {
        return employeeRepo.findAll();
    }

    //return by id
    public EmployeeModel getById(int id) {

        EmployeeModel employee = employeeRepo.findById(id).orElse(null);
        list.add(employee);
        return employee;
    }


    //delete
    public String deleteById(int id) {
        employeeRepo.deleteById(id);
        return "Delete Succesfully";
    }

    //Update
    public EmployeeModel updateById(EmployeeModel employeeModel) {
        EmployeeModel employee = new EmployeeModel();
        EmployeeModel existing = employeeRepo.findById(employeeModel.getEmployeeId()).orElse(null);
        existing.setName(employeeModel.getName());
        existing.setSalary(employeeModel.getSalary());
        existing.setGender(employeeModel.getGender());
        existing.setStartDate(employeeModel.getStartDate());
        existing.setNote(employeeModel.getNote());
        existing.setProfilePic(employeeModel.getProfilePic());
        list.add(employee);
        return employeeRepo.save(existing);
    }


}
