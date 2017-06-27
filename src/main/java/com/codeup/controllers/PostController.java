package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.models.User;
import com.codeup.repositories.UsersRepository;
import com.codeup.svcs.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class PostController {
    private final PostSvc postSvc;
    private  final UsersRepository usersRepository;

    @Value("${file-upload-path}")
    private String uploadPath;

    @Autowired
    public PostController (PostSvc postSvc, UsersRepository usersRepository){
        this.postSvc = postSvc;
        this.usersRepository = usersRepository;
    }


    @GetMapping("/posts.json")
    public @ResponseBody Iterable<Post> viewAllPosts() {
        return postSvc.findAll();
    }

    @GetMapping("/posts/ajax")
    public String viewAllPostsUsingAnAjaxCall(Model model) {
        model.addAttribute("page", postSvc.findAll());
        return "posts/ajax";
    }



    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String indexPage(Model model) {
        ArrayList<Post> posts = (ArrayList<Post>) postSvc.findAll();
        model.addAttribute("posts", posts);
        return "posts/index" ;
    }



    @GetMapping("/posts/{id}")
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
            @Valid Post post,
            Errors validation,
//            @RequestParam(name = "file") MultipartFile unloadedfile,
            Model model){
        if (validation.hasErrors()){
            model.addAttribute("errors", validation);
            model.addAttribute("post", post);
            return "posts/create";
        }
        else {
            User user1 = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            post.setUser(user1);
            postSvc.save(post);
            Long id = post.getId();
            return "redirect:/posts/" + id;
        }
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
    public String deletePost(@ModelAttribute Post post, Model model) {
        postSvc.deletePost(post.getId());
        model.addAttribute("msg", "Your post was deleted");
        return  "redirect:/posts/";
    }

}


