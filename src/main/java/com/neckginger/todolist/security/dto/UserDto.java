package com.neckginger.todolist.security.dto;

import com.neckginger.todolist.security.model.Role;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserDto(
        Integer id,
        String password,
        String username,
        Role role,
        Boolean accountNonExpired,
        Boolean accountNonLocked,
        Boolean credentialsNonExpired,
        Boolean enabled,
        String firstName,
        String lastName,
        String emailAddress,
        LocalDate birthdate) {
}
