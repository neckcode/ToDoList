package com.neckginger.todolist.security.mapper;

import com.neckginger.todolist.security.dto.UserCreateDto;
import com.neckginger.todolist.security.dto.UserDto;
import com.neckginger.todolist.security.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UserMapper {
	private final PasswordEncoder passwordEncoder;

	public User userFromUserCreateDto(UserCreateDto dto){
		return  User.builder()
				.username(dto.getUsername())
				.password(passwordEncoder.encode(dto.getPassword()))
				.role(dto.getRole())
				.build();
	}
	public UserDto userEntityToDto(User user) {
		return UserDto.builder()
				.id(user.getId())
				.username(user.getUsername())
				.role(user.getRole())
				.accountNonExpired(user.getAccountNonExpired())
				.accountNonLocked(user.getAccountNonLocked())
				.credentialsNonExpired(user.getCredentialsNonExpired())
				.enabled(user.getEnabled())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.emailAddress(user.getEmailAddress())
				.birthdate(user.getBirthdate())
				.build();
	}
	
	public List<UserDto> userListEntityToDto(List<User> users) {
		return users.stream()
				.map(user -> userEntityToDto(user))
				.toList();
	}
	
	public User userDtoToEntity(UserDto user, String password) {
		return User.builder()
				.id(user.id())
				.username(user.username())
				.password(password)
				.role(user.role())
				.accountNonExpired(user.accountNonExpired())
				.accountNonLocked(user.accountNonLocked())
				.credentialsNonExpired(user.credentialsNonExpired())
				.enabled(user.enabled())
				.firstName(user.firstName())
				.lastName(user.lastName())
				.emailAddress(user.emailAddress())
				.birthdate(user.birthdate())
				.build();
	}
}
