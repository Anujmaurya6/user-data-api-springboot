package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.bean.Spbean;
import com.example.demo.service.Spservice;

@Controller
public class Spcontroller {
	@Autowired
	Spservice service;
	@PostMapping("/ppp")
	public String post(@RequestBody Spbean sp) {
	 return service.post(sp);
	}

}
