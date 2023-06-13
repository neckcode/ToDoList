package com.neckginger.todolist.dao;

import com.neckginger.todolist.model.Work;
import org.springframework.data.repository.CrudRepository;

interface UserDao extends CrudRepository<Work, Long> {
}
