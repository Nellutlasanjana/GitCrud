package com.example.springboot.GitCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.GitCrud.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

