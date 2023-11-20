package com.example.questionnaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionnaire.entity.User;

@Repository
public interface UserDao  extends JpaRepository<User, String>{

}
