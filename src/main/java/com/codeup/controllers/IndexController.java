package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by melodytempleton on 6/26/17.
 */
@Controller
public class IndexController {


    @GetMapping("/")
    public String index() {
        return "index";
    }

}
