package com.codeup.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by melodytempleton on 6/29/17.
 */

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, columnDefinition = "Text")
    @NotBlank(message = "Comment must have an entry")
    @Size(min = 10, message = "A comment must be at least 10 characters")
    private String commentEntry;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn (name = "post_id")
    private Post post;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn (name = "user_id")
    private User user;

    public Comment(String commentEntry) {
        this.commentEntry = commentEntry;
    }

    public Comment(){}

    public String getCommentEntry() {
        return commentEntry;
    }

    public void setCommentEntry(String commentEntry) {
        this.commentEntry = commentEntry;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }
}
