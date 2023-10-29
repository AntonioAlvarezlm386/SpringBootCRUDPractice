package com.Api.CRUDPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Api.CRUDPractice.models.User;

@Repository
public interface IuserRepository extends JpaRepository<User, Long>{
	
}
