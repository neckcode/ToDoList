package com.neckginger.todolist.dao;

import com.neckginger.todolist.model.Work;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkDao extends CrudRepository<Work, Long> {
}
