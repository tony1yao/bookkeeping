package com.tony.bookkeeping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tony.bookkeeping.beans.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
