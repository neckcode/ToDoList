package com.neckginger.todolist.security.service;

import com.neckginger.todolist.security.dto.UserCreateDto;
import com.neckginger.todolist.security.dto.UserDto;
import com.neckginger.todolist.security.mapper.UserMapper;
import com.neckginger.todolist.security.model.User;
import com.neckginger.todolist.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto getLoginUser() {
        return userMapper.userEntityToDto(userRepository.findLoginUser().orElse(null));
    }

    public UserDto getUserById(Integer id) {
        return userMapper.userEntityToDto(userRepository.findById(id).orElse(null));
    }

    public List<UserDto> getAllUsers() {
        return userMapper.userListEntityToDto(userRepository.findAll());
    }

    public UserDto createUser(User user) {
        return userMapper.userEntityToDto(userRepository.save(user));
    }

    public UserDto createUser(UserCreateDto dto) {
        return userMapper.userEntityToDto(
                userRepository.save(
                        userMapper.userFromUserCreateDto(dto))
        );
    }

    public UserDto updateUser(User user) {
        return userMapper.userEntityToDto(userRepository.save(user));
    }

    public void deleteUser(User user) {
        userRepository.delete(user);;
    }
}
