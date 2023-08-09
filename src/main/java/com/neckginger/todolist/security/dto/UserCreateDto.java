package com.neckginger.todolist.security.dto;

import com.neckginger.todolist.security.model.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserCreateDto {
    private String username;
    private String password;
    private Role role;
}
