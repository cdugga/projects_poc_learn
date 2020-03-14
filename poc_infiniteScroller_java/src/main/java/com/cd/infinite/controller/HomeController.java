package com.cd.infinite.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {

	@RequestMapping(value = "/")
    public String index() {
        return "forward:index.html";
    }

}