package com.neckginger.todolist.security.repository;

import com.neckginger.todolist.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String username);

	@Query("SELECT u FROM User u WHERE u.username = ?#{ principal.username}")
	Optional<User> findLoginUser();
}
