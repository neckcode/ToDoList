package com.neckginger.todolist.controller;

import com.neckginger.todolist.dao.WorkDao;
import com.neckginger.todolist.model.Work;
import com.neckginger.todolist.service.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class WorkController {
    private final WorkService service;

    @GetMapping("/")
    public String index(@ModelAttribute("work") Work work, Model model) {
        model.addAttribute("works", service.findAll());
        return "addwork";
    }

    @GetMapping("/work/{id}")
    public String getWork(@PathVariable("id") Long id, Model model) {
        service.getById(id).ifPresent(w->
                model.addAttribute("work", w));
        return "work";
    }

    @PostMapping("/work")
    public String addWork(@ModelAttribute("work") Work work, Model model) {
        service.save(work);
        return "redirect:/";
    }

    @DeleteMapping("/work/{id}")
    public String deleteWork(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
