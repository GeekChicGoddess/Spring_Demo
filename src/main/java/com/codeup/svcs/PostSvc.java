package com.codeup.svcs;

import com.codeup.models.Post;
import com.codeup.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melodytempleton on 6/20/17.
 */

    @Service("postSvc")
    public class PostSvc {


    private  PostsRepository postsRepository;

    @Autowired
    public PostSvc(PostsRepository postSvc) {

        this.postsRepository = postSvc;
        }

    public Iterable<Post> findAll(){
        return postsRepository.findAll();
    }

    public  Post findOne(long id){
        return postsRepository.findOne(id);
    }

    public Post save (Post post){
        postsRepository.save(post);
        return post;
    }

    public void deletePost(long id){
        postsRepository.delete(id);
    }


}


