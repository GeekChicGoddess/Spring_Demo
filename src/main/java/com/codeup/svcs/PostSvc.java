package com.codeup.svcs;

import com.codeup.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melodytempleton on 6/20/17.
 */

    @Service("PostSvc")
    public class PostSvc {
        private List<Post> posts;

        public PostSvc() {
            posts = new ArrayList<>();
            createPosts();
        }

        public List<Post> findAll() {
            return posts;
        }

        public Post save(Post post) {
            posts.add(post);
            return post;
        }

        public Post findOne(int index) {
            return posts.get(index-1);
        }

        private void createPosts() {
            Post entryOne = new Post("First Entry", "Good Stuff to say here");
            save(entryOne);

              Post entryTwo = new Post("Second Entry", "More Good Stuff to say here");
            save(entryTwo);

              Post entryThree = new Post("Third Entry", "Still More Good Stuff to say here");
            save(entryThree);

              Post entryFour = new Post("Fourth Entry", "OMG Lots of Good Stuff to say here");
            save(entryFour);

              Post entryFive = new Post("Fifth Entry", "It's amazing how much Good Stuff I have to say here");
            save(entryFive);

              Post entrySix = new Post("Sixth Entry", "Good Stuff. The Best Stuff.  Very bigly stuff");
            save(entrySix
            );

        }
    }


