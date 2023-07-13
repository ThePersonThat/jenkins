package com.alex.jenkins.controller;

import com.alex.jenkins.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@AllArgsConstructor
public class MainPageController {
    private final TestService testService;

    @GetMapping("/home")
    public String page(Model model) {
        testService.injectName(model);
        return testService.getMainPageName();
    }
}
