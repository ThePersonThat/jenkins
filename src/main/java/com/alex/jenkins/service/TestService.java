package com.alex.jenkins.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class TestService {

    public String getMainPageName() {
        return "main";
    }

    public void injectName(Model model) {
        model.addAttribute("name", "alex");
    }
}
