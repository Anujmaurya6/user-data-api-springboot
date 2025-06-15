package com.example.demo.repo;


	import org.springframework.data.jpa.repository.JpaRepository;
	import com.example.demo.entity.Employeeentity;

	public interface EmployeeRepo extends JpaRepository<Employeeentity, Integer> {

		Employeeentity findByUsername(String username);
	    // JpaRepository me basic CRUD methods already hain
	}


