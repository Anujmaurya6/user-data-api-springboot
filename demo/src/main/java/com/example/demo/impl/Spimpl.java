package com.example.demo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Spbean;

import com.example.demo.entity.Spentity;
import com.example.demo.repo.Sprepo;
import com.example.demo.service.Spservice;
@Service
public class Spimpl implements Spservice{
	@Autowired
	Sprepo repo;
    @Override
	public String post(Spbean sp) {
    	Spentity anuj=new Spentity();
    	anuj.setEmail(sp.getEmail());
    	anuj.setName(sp.getName());
    	anuj.setUsername(sp.getUsername());
    	anuj.setAge(sp.getAge());
    	anuj.setPhone(sp.getPhone());
    	repo.save(anuj);
    		return "Record entered successfully";
    	}
}

