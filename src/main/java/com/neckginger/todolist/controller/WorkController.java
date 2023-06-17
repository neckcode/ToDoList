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
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class WorkController {
    private final WorkService service;

    @GetMapping("/")
    public String index(@ModelAttribute("work") Work work, Model model) {
        model.addAttribute("works", service.findAll());
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
    public String deleteWork(@ModelAttribute("work") Work work, @PathVariable("id") long id, Model model) {
        service.getById(id).orElseThrow(() -> new IllegalArgumentException("Invalid work Id:" + id));
        service.delete(id);
        model.addAttribute("works", service.findAll());
        return "index";
    }
}
