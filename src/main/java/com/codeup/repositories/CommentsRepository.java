package com.codeup.repositories;

import com.codeup.models.Comment;
import com.codeup.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by melodytempleton on 6/29/17.
 */
public interface CommentsRepository extends CrudRepository<Comment, Long> {

    public List<Comment> findAllByPostId(Long id);

}
