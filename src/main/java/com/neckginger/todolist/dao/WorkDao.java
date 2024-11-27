package com.neckginger.todolist.dao;

import com.neckginger.todolist.model.Work;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface WorkDao extends CrudRepository<Work, Long> {

    @Query("SELECT w FROM Work w WHERE w.user.username = ?#{ principal.username}")
    Collection<Work> findAllByLoggedUser();
}
