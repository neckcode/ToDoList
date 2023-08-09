package com.neckginger.todolist.security.controller;

import com.neckginger.todolist.security.dto.UserCreateDto;
import com.neckginger.todolist.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import static com.neckginger.todolist.security.model.Role.USER;

@Controller
@RequiredArgsConstructor
public class SecurityController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("title", "Login");
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("title", "Login");
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping("/signun")
    public String signun(Model model) {
        model.addAttribute("user", new UserCreateDto());
        return "signun";
    }

    @PostMapping("/signin")
    public String signinCreate(@ModelAttribute("user") UserCreateDto user,
                               Model model) {
        user.setRole(USER);
        userService.createUser(user);
        return "redirect:/";
    }
}
