package com.srs.MongoDBProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    private int id;
    private String name;
    private int age;
    private String gender;
    private Department department;
    private Address address;
    private int yearOfJoining;
    private String dateOfJoining;
    private double salary;
}
