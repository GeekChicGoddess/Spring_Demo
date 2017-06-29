package com.codeup.controllers;

import com.codeup.models.Comment;
import com.codeup.models.Post;
import com.codeup.models.User;
import com.codeup.repositories.CommentsRepository;
import com.codeup.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by melodytempleton on 6/29/17.
 */
@Controller
public class CommentController {
    @Autowired
    private final CommentsRepository commentsRepository;

    @Autowired
    private final PostsRepository postsRepository;

    @Autowired
    public CommentController (CommentsRepository commentsRepository, PostsRepository postsRepository){
        this.commentsRepository = commentsRepository;
        this.postsRepository = postsRepository;
    }

    @PostMapping("/posts/comment")
    public String addcomment(@Valid Comment comment,
                             Errors validation,
                             @RequestParam(name = "postId") String postId,
                             Model model) {
        System.out.println("running post");
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            return "posts/" + postId;
        } else {
            System.out.println("running the else");
            User user1 = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            comment.setUser(user1);
            Long postIdLong = Long.valueOf(postId);
            Post post = postsRepository.findPostById(postIdLong);
            comment.setPost(post);
            commentsRepository.save(comment);
            Long id = comment.getId();

            return "redirect:/posts/" + postId;
        }

    }
}
