package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.model.EmployeeModel;
import com.example.employeepayrollapp.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public EmployeeModel save(EmployeeModel employeeModel) {
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
        return employeeRepo.findById(id).orElse(null);
    }


    //delete
    public String deleteById(int id){
        employeeRepo.deleteById(id);
        return "Delete Succesfully";
    }

    //Update
    public EmployeeModel updateById(EmployeeModel employeeModel){
        EmployeeModel existing = employeeRepo.findById(employeeModel.getEmployeeId()).orElse(null);
        existing.setName(employeeModel.getName());
        existing.setSalary(employeeModel.getSalary());
        existing.setGender(employeeModel.getGender());
        existing.setStartDate(employeeModel.getStartDate());
        existing.setNote(employeeModel.getNote());
        existing.setProfilePic(employeeModel.getProfilePic());

        return employeeRepo.save(existing);
    }
}
