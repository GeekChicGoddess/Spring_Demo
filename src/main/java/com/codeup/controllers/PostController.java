package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.svcs.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


//    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @GetMapping ("/posts/{id}")
    public String individualpost(@PathVariable long id, Model model) {
        model.addAttribute("post", postSvc.findOne(id));
        return "posts/show";
    }


    @GetMapping ("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }


    @PostMapping("/posts/create")
    public String create(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body,
            Model model
    ) {
        Post post = new Post(title, body);
        postSvc.save(post);
        Long id = post.getId();
        return "redirect:/posts/" + id + "/edit";
    }

    @GetMapping ("/posts/{id}/edit")
    public String showEditPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postSvc.findOne(id));
        return "posts/edit";
    }



    @PostMapping("/posts/{id}/edit")
    public String editPost(
                           @PathVariable long id,
                           @RequestParam(name = "title") String title,
                           @RequestParam(name = "body") String body) {
        Post post = postSvc.findOne(id);
        post.setTitle(title);
        post.setBody(body);
        return  "redirect:/posts/" +id;
    }


}


