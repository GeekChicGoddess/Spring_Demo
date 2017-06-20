package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String indexPage() {
        return "Index Page" ;
    }


    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String individualpost(@PathVariable String id) {
        return id + " post" ;
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String createPostFormView() {
        return "Viewing the form to create a post" ;
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPostFormPost () {
        return "Adding a new Post" ;
    }




}
