package com.api.tia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.tia.models.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByMail(String mail);
	List<User> findByMailAndPassword(String mail, String pass);
	List<User> findByIdentification(String identification);
}
