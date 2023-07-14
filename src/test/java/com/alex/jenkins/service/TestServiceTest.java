package com.alex.jenkins.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.*;
class TestServiceTest {
    private TestService testService;

    @BeforeEach
    void setUp() {
        testService = new TestService();
    }

    @Test
    void getMainPageName() {
        assertEquals("123", testService.getMainPageName());
    }

    @Test
    void injectName() {
        ExtendedModelMap extendedModelMap = new ExtendedModelMap();
        testService.injectName(extendedModelMap);

        assertEquals("alex", extendedModelMap.get("name"));
    }
}