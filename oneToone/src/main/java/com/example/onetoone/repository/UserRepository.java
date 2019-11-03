package com.example.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onetoone.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

}
