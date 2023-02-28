package com.caiopivetta6.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiopivetta6.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer>{

	Optional<UserModel> findByLoginAndPassword(String email, String password);
}
