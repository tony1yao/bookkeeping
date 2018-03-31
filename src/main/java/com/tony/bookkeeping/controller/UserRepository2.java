package com.tony.bookkeeping.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tony.bookkeeping.beans.User;

public interface UserRepository2 extends JpaRepository<User, Integer>{

}
