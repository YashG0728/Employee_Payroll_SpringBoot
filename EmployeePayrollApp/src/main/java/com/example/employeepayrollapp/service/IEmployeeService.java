package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.model.EmployeeModel;

import java.util.List;

//To Hide the data from the user we r using interface it contains abstract methods only
public interface IEmployeeService {

    public EmployeeModel save(EmployeeModel employeeModel);

    public List<EmployeeModel> save(List<EmployeeModel> employeeModel);

    public List<EmployeeModel> get();

    public EmployeeModel getById(int id);

    public String deleteById(int id);

    public EmployeeModel updateById(EmployeeModel employeeModel);
}
