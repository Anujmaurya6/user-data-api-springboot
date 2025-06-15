
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.bean.UpdateNameRequest;
import com.example.demo.bean.ChangePassword;
import com.example.demo.service.Employeeservice;

@RestController
@CrossOrigin(origins="http://127.0.0.1:5500")

@RequestMapping("/employee")
public class Employeecontroller {

    @Autowired
    private Employeeservice service;

    // ✅ Update employee name
    @PutMapping("/updateName/{id}")
    public ResponseEntity<String> updateName(@PathVariable int id, @RequestBody UpdateNameRequest request) {
        String result = service.updateName(id, request.getName());
        return ResponseEntity.ok(result);
    }

    // ✅ Change employee password
    @PutMapping("/changePassword/{id}")
    public ResponseEntity<String> changePassword(@PathVariable int id, @RequestBody ChangePassword request) {
        String result = service.changePassword(id, request.getOldPassword(), request.getNewPassword());
        return ResponseEntity.ok(result);
    }
}
