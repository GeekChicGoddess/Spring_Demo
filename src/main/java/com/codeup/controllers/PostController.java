package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.models.User;
import com.codeup.repositories.PostsRepository;
import com.codeup.repositories.UsersRepository;
import com.codeup.svcs.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Controller
public class PostController {
    private final PostSvc postSvc;
    private  final UsersRepository usersRepository;

    @Autowired
    public PostController (PostSvc postSvc, UsersRepository usersRepository){
        this.postSvc = postSvc;
        this.usersRepository = usersRepository;
    }


    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String indexPage(Model model) {
        ArrayList<Post> posts = (ArrayList<Post>) postSvc.findAll();
        model.addAttribute("posts", posts);
        return "posts/index" ;
    }



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
            @RequestParam(name = "body") String body) {
        Post post = new Post(title, body);
        User user1 = new User("user1", "passw0rd", "user@mail.com");
        user1.setId(1);
        post.setUser(user1);
        postSvc.save(post);
        Long id = post.getId();
        return "redirect:/posts/" + id;
    }

    @GetMapping ("/posts/{id}/edit")
    public String showEditPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postSvc.findOne(id));
        return "posts/edit";
    }



    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post) {
        postSvc.save(post);
        return  "redirect:/posts/" +post.getId();
    }

    @GetMapping ("/posts/{id}/delete")
    public String showDeletePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postSvc.findOne(id));
        return "posts/delete";
    }



    @PostMapping("/posts/delete")
//    @Transactional
    public String deletePost(@ModelAttribute Post post, Model model) {
        postSvc.deletePost(post.getId());
        model.addAttribute("msg", "Your post was deleted");
        return  "redirect:/posts/";
    }


}


