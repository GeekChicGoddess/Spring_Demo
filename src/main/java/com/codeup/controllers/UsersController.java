package com.codeup.controllers;

import com.codeup.models.User;
import com.codeup.models.UserRole;
import com.codeup.repositories.RolesRepository;
import com.codeup.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UsersController {


    @Autowired
    UsersRepository usersDao;

    @Autowired
    RolesRepository rolesDao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/users/register")
    public String saveUser(@ModelAttribute User user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersDao.save(user);

        UserRole userRole = new UserRole(user.getId(), "USER");
        rolesDao.save(userRole);
        //Create a default user role for the new user

        return "login";

    }



}