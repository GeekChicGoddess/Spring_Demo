package com.codeup.repositories;

import com.codeup.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by melodytempleton on 6/21/17.
 */
public interface PostsRepository extends CrudRepository<Post, Long>{

    public List<Post> findAllByUserId(Long id);

    public Post findPostById(Long id);

}
