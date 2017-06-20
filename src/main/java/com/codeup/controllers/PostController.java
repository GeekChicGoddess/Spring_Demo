package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.svcs.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {
    private final PostSvc postSvc;

    @Autowired
    public PostController (PostSvc postSvc){
        this.postSvc = postSvc;
    }

    @RequestMapping(path = "/posts", method = RequestMethod.GET)

    public String indexPage(Model model) {
        ArrayList<Post> posts = (ArrayList<Post>) postSvc.findAll();
        model.addAttribute("posts", posts);
        return "posts/index" ;
    }


    @RequestMapping(path = "/posts/{index}", method = RequestMethod.GET)

    public String individualpost(@PathVariable int index, Model model) {
        model.addAttribute("post", postSvc.findOne(index));
        return "posts/show";
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
