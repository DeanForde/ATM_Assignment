package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Accounts;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Integer>{
	
}
