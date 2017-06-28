package com.codeup.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by melodytempleton on 6/20/17.
 */

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Post must have a title")
    @Size(min = 3, message = "A title must be at least 3 characters")
    private String title;

    @Column(nullable = false, columnDefinition = "Text")
    @NotBlank(message = "Post must have a body")
    @Size(min = 10, message = "A body must be at least 10 characters")
    private String body;

//    @OneToMany ( cascade = CascadeType.ALL, mappedBy = "post")
//    private  List<PostImage> images;



    @Column(nullable = true)
    private String imageUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Post (){}

    public Post (String title, String body){
        this.body = body;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @ManyToOne
    @JsonManagedReference
    @JoinColumn (name = "user_id")
    private User user;

}
