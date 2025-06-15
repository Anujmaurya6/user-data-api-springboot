package com.example.demo.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employeeentity;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.service.Employeeservice;

@Service
public class Employeeimpl implements Employeeservice {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employeeentity getByUsername(String username) {
        return employeeRepo.findByUsername(username);
    }

    @Override
    public String updateName(int id, String name) {
        Optional<Employeeentity> empOpt = employeeRepo.findById(id);
        if (empOpt.isPresent()) {
            Employeeentity emp = empOpt.get();
            emp.setName(name);
            employeeRepo.save(emp);
            return "Name updated successfully";
        }
        return "Employee not found";
    }

    @Override
    public String changePassword(int id, String oldPassword, String newPassword) {
        Optional<Employeeentity> empOpt = employeeRepo.findById(id);
        if (empOpt.isPresent()) {
            Employeeentity emp = empOpt.get();
            if (emp.getPassword().equals(oldPassword)) {
                emp.setPassword(newPassword);
                employeeRepo.save(emp);
                return "Password changed successfully";
            } else {
                return "Old password is incorrect";
            }
        }
        return "Employee not found";
    }
}

