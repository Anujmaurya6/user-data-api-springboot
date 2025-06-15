package com.example.demo.repo;



	import org.springframework.data.jpa.repository.JpaRepository;
	import com.example.demo.entity.Adminentity;

	public interface AdminRepo extends JpaRepository<Adminentity, String> {
	    Adminentity findByUsername(String username);
	}


