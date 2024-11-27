package com.neckginger.todolist.service;

import com.neckginger.todolist.dao.WorkDao;
import com.neckginger.todolist.model.Work;
import com.neckginger.todolist.model.statuses.WorkStatus;
import com.neckginger.todolist.security.mapper.UserMapper;
import com.neckginger.todolist.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkService {
    private final WorkDao dao;
    private final UserService userService;
    private final UserMapper userMapper;

    public List<Work> findAll() {
        return (List) dao.findAll();
    }

    public List<Work> findAllByLoggedUser() {
        return (List) dao.findAllByLoggedUser();
    }

    public Optional<Work> getById(long id){
        return dao.findById(id);
    }

    public long save(Work work) {
        if (work.getStatus() == null) {
            work.setStatus(WorkStatus.OPEN);
        }
        userService.getLoginUser();
        work.setUser(userMapper.userDtoToEntity(userService.getLoginUser(), ""));
        return dao.save(work).getId();
    }

    public void update(Work work) {
        dao.save(work);
    }

    public void delete(Long id) {
        dao.deleteById(id);
    }
}
