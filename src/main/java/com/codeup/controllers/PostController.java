package com.codeup.controllers;

import com.codeup.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {

    @RequestMapping(path = "/posts", method = RequestMethod.GET)

    public String indexPage(Model model) {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post("test post again", "here is a dummy body"));
        posts.add(new Post("more test post", "more more here is a dummy body"));
        model.addAttribute("posts", posts);
        return "posts/index" ;
    }


    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)

    public String individualpost(@PathVariable String id, Model model) {
        Post post = new Post("test post", "this is my first blog post");
        model.addAttribute("post", post);
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
