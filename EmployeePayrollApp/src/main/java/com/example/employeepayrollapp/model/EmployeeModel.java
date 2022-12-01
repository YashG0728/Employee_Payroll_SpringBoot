package com.example.employeepayrollapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Employee_Table")
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int employeeId;
    @Column
    private String name;
    @Column
    private long salary;
    @Column
    private String gender;
    @Column
    private LocalDate startDate;
    @Column
    private String note;
    @Column
    private String profilePic;
}
