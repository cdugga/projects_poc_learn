package com.cd.crypto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PriceController {

    @RequestMapping(value = "/")
    public String index() {
        return "forward:index.html";
    }

}
