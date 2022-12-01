package com.example.employeepayrollapp.converter;

import com.example.employeepayrollapp.dto.EmployeeDto;
import com.example.employeepayrollapp.model.EmployeeModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeConverter {

    public EmployeeDto modelToDto(EmployeeModel employeeModel) {
        EmployeeDto dto = new EmployeeDto();
        dto.setEmployeeId(employeeModel.getEmployeeId());
        dto.setName(employeeModel.getName());
        dto.setSalary(employeeModel.getSalary());
        return dto;
    }

    //basically its takes model list and return the dto list
    public List<EmployeeDto> modelToDtos(List<EmployeeModel> employee) {
        return employee.stream().map(x -> modelToDto(x)).collect(Collectors.toList());
    }


    public EmployeeModel dtoToEntity(EmployeeDto employeeDto) {
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setEmployeeId(employeeDto.getEmployeeId());
        employeeModel.setName(employeeDto.getName());
        employeeModel.setSalary(employeeDto.getSalary());
        return employeeModel;
    }

    public List<EmployeeModel> dtoToEntity(List<EmployeeDto> employee) {
        return employee.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
