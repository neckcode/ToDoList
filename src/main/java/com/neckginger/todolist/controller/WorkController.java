package com.neckginger.todolist.controller;

import com.neckginger.todolist.dao.WorkDao;
import com.neckginger.todolist.model.Work;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class WorkController {
    private final WorkDao dao;

    @GetMapping("/index")
    public String index(@ModelAttribute("work") Work work, Model model) {
        return "addwork";
    }

    @PostMapping("/addwork")
    public String addWork(@ModelAttribute("work") Work work, Model model) {
        dao.save(work);
        return "redirect:/index";
    }
}
