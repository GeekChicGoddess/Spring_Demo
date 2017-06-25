package com.codeup.repositories;

import com.codeup.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by melodytempleton on 6/22/17.
 */
public interface UsersRepository extends CrudRepository<User, Long> {

    public User findByUsername(String username);
}
