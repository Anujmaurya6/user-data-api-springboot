package com.example.demo.bean;

public class Adminbean {
	    private String username;
	    private String password;
	    private String role = "admin";  // fixed role

	    // Getters and Setters
	    public String getUsername() {
	        return username;
	    }
	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getRole() {
	        return role;
	    }
	    public void setRole(String role) {
	        this.role = role;
	    }
	}

