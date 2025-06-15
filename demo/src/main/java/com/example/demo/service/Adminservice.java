package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Adminentity;
import com.example.demo.entity.Employeeentity;

public interface Adminservice {   // <-- interface bana diya yahan

    Adminentity getByusername(String username);

    String addEmp(Employeeentity cb);

    String updateEmp(int id, Employeeentity cb);

    String deleteEmp(int id);

    List<Employeeentity> getAllEmp();

}
