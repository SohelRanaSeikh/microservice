package com.srs.MongoDBProject.repository;

import com.srs.MongoDBProject.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee, Integer> {

    @Query("{'department.name':/?0/}")
    public List<Employee> getEmpByLike(String name);
    @Query("{'department.location.streetName':/?0/}")
    public List<Employee> getEmpByDeptLike(String name);

    @Query("{'department.name':/^?0/}")
    public List<Employee> getEmpByStart(String name);
    @Query("{'department.location.streetName':/^?0/}")
    public List<Employee> getEmpByDeptStart(String name);
}
