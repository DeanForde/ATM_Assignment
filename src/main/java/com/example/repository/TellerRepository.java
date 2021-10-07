package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Teller;

@Repository
public interface TellerRepository extends JpaRepository<Teller, Integer>{

	
}
