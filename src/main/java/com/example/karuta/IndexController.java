package com.example.karuta;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/*
 * BR2 2
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }
}