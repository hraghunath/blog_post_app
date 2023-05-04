package com.raghunathit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghunathit.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
