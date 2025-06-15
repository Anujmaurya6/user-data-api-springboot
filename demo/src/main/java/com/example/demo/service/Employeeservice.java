package com.example.demo.service;

import com.example.demo.entity.Employeeentity;

public interface Employeeservice {

    Employeeentity getByUsername(String username);

    String updateName(int id, String name);

    String changePassword(int id, String oldPassword, String newPassword);
}

