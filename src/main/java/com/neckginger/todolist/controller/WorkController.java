package com.neckginger.todolist.controller;

import com.neckginger.todolist.model.Work;
import com.neckginger.todolist.security.dto.UserDto;
import com.neckginger.todolist.security.service.UserService;
import com.neckginger.todolist.service.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class WorkController {
    private final WorkService service;
    private final UserService userService;

    @GetMapping("/")
    public String index(@ModelAttribute("work") Work work, Model model, Authentication authentication) {
        if (authentication != null) {
            UserDto user = userService.getLoginUser();
            model.addAttribute("user", user);
            model.addAttribute("works", service.findAllByLoggedUser());
        }
        return "index";
    }

    @GetMapping("/work/{id}")
    public String getWork(@PathVariable("id") Long id, Model model) {
        service.getById(id).ifPresent(w ->
                model.addAttribute("work", w));
        return "work";
    }

    @PostMapping("/work")
    public String addWork(@ModelAttribute("work") Work work, Model model) {
        service.save(work);
        return "redirect:/";
    }

    @GetMapping("/work/edit/{id}")
    public String showUpdateForm(@ModelAttribute("work") Work work, @PathVariable("id") long id, Model model) {
        work = service.getById(id).orElseThrow(() -> new IllegalArgumentException("Invalid work Id:" + id));
        model.addAttribute("work", work);
        return "work-update";
    }

    @PostMapping("/work/update/{id}")
    public String updateWork(@ModelAttribute("work") Work work) {
        service.save(work);
        return "redirect:/work/" + work.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteWork(@ModelAttribute("work") Work work,
                             @PathVariable("id") long id,
                             Model model,
                             Authentication authentication) {
        if (authentication != null) {
            UserDto user = userService.getLoginUser();
            model.addAttribute("user", user);
        }
        service.getById(id).orElseThrow(() -> new IllegalArgumentException("Invalid work Id:" + id));
        service.delete(id);
        model.addAttribute("works", service.findAllByLoggedUser());
        return "index";
    }
}
