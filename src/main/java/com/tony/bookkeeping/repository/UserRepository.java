package com.tony.bookkeeping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tony.bookkeeping.beans.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
