package com.example.demo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Adminentity;
import com.example.demo.entity.Employeeentity;
import com.example.demo.repo.AdminRepo;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.service.Adminservice;

@Service
public class ADminimpl implements Adminservice {

    @Autowired
    private AdminRepo repo;  // variable name small letter se start hona chahiye

    @Autowired
    private EmployeeRepo empRepo;

    @Override
    public Adminentity getByusername(String username) {
        return repo.findByUsername(username);  // instance se call kiya yahan
    }

    @Override
    public String addEmp(Employeeentity emp) {
        empRepo.save(emp);
        return "Employee added successfully";
    }

    @Override
    public String updateEmp(int id, Employeeentity emp) {
        Optional<Employeeentity> existingEmp = empRepo.findById(id);
        if (existingEmp.isPresent()) {
            Employeeentity e = existingEmp.get();
            e.setName(emp.getName());
            e.setUsername(emp.getUsername());
            e.setPassword(emp.getPassword());
            e.setRole(emp.getRole());
            empRepo.save(e);
            return "Employee updated successfully";
        }
        return "Employee not found";
    }

    @Override
    public String deleteEmp(int id) {
        Optional<Employeeentity> existingEmp = empRepo.findById(id);
        if (existingEmp.isPresent()) {
            empRepo.deleteById(id);
            return "Employee deleted successfully";
        }
        return "Employee not found";
    }

    @Override
    public List<Employeeentity> getAllEmp() {
        return empRepo.findAll();
    }
}
