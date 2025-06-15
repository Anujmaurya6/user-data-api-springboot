package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Loginbean;
import com.example.demo.entity.Adminentity;
import com.example.demo.entity.Employeeentity;
import com.example.demo.service.Adminservice;

@RestController
@CrossOrigin(origins="http://127.0.0.1:5500")

public class Admincontroller {
	@Autowired
Adminservice service;
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Loginbean req) {
	    System.out.println("Username from frontend: " + req.getUsername());

	    Adminentity admin = service.getByusername(req.getUsername());
	    System.out.println("User found in DB: " + admin);

	    if (admin != null 
	        && admin.getPassword().equals(req.getPassword()) 
	        && admin.getRole().equalsIgnoreCase("admin")) {
	        
	        return ResponseEntity.ok("Admin login successful");
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
	    }
	}

	@PostMapping("/addEmp")
	public ResponseEntity <String>addEmployee(@RequestBody Employeeentity cb){
	String result=service.addEmp(cb);
	return ResponseEntity.ok("employee added successfully");
}
@PostMapping("/updateemp")
public ResponseEntity<String>updateEmployee(@PathVariable int id,@RequestBody Employeeentity cb){
	String result=service.updateEmp(id,cb);
	return ResponseEntity.ok("updated employee successfully");
} 
@DeleteMapping("/deleteEmp/{id}")
public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
    String result = service.deleteEmp(id);
    return ResponseEntity.ok(result);
}

@GetMapping("/getAllEmp")
public ResponseEntity<List<Employeeentity>> getAllEmployees() {
    List<Employeeentity> list = service.getAllEmp();
    return ResponseEntity.ok(list);
}
}

