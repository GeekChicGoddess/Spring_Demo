package com.codeup.svcs;

import com.codeup.models.Post;
import com.codeup.repositories.PostsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melodytempleton on 6/20/17.
 */

    @Service("postSvc")
    public class PostSvc {


    private final PostsRepository postsRepository;


    public PostSvc(PostsRepository postsRepository) {
            this.postsRepository = postsRepository;
        }



}


