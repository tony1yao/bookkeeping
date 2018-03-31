package com.tony.bookkeeping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tony.bookkeeping.beans.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public List<User> findByGender(String gender);
}
