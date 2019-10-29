package com.jalasoft.crud.service;

import com.jalasoft.crud.exception.RecordNotFoundException;
import com.jalasoft.crud.model.Book;
import com.jalasoft.crud.model.User;
import com.jalasoft.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public User getUser(String username) throws RecordNotFoundException
    {

        Optional<User> user = repository.findUserByUserName(username);

        if(user.isPresent()) {
            return user.get();
        } else {
            throw new RecordNotFoundException("There is not a user with that name");
        }
    }
}
