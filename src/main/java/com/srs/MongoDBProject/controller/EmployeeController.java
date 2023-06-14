package com.srs.MongoDBProject.controller;

import com.srs.MongoDBProject.model.Employee;
import com.srs.MongoDBProject.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepo empRepo;

    @PostMapping("/employee")
    public Employee addEmp(@RequestBody Employee emp) {
        return empRepo.save(emp);
    }

    @PutMapping("/employee")
    public Employee updateEmp(@RequestBody Employee emp) {
        return empRepo.save(emp);
    }

    @GetMapping("/employee")
    public List<Employee> getEmp() {
        return empRepo.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmpById(@PathVariable("id") int id) {
        return empRepo.findById(id).get();
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmpById(@PathVariable("id") int id) {
        empRepo.deleteById(id);
    }
    @GetMapping("/empByLike")
    public List<Employee> getEmpByLike(@RequestParam("name") String name) {
        return empRepo.getEmpByLike(name);
    }
    @GetMapping("/empByDeptLike")
    public List<Employee> getEmpByDeptLike(@RequestParam("name") String name) {
        return empRepo.getEmpByDeptLike(name);
    }
    @GetMapping("/empByStart")
    public List<Employee> getEmpByStart(@RequestParam("name") String name) {
        return empRepo.getEmpByStart(name);
    }
    @GetMapping("/empByDeptStart/")
    public List<Employee> getEmpByDeptStart(@RequestParam("name") String name) {
        return empRepo.getEmpByDeptStart(name);
    }
}
