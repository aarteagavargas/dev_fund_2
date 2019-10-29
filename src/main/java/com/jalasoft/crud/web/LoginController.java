/*
 * Copyright (c) 2019 Jalasoft.
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 *
 */
package com.jalasoft.crud.web;

import com.jalasoft.crud.exception.RecordNotFoundException;
import com.jalasoft.crud.model.User;
import com.jalasoft.crud.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implements LoginController class
 *
 * @author Alejandra Arteaga on 10/28/2019.
 * @version 1.0
 */
@RestController
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService service;

    @PostMapping("/login")
    public String validate(@RequestBody User user) throws RecordNotFoundException {
        User user1 = service.getUser(user.getUser());

        String key = "dev-fun2";
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, key.getBytes())
                .setSubject(user1.getUser())
                .claim("role", user1.getRole())
                .claim("email", user1.getEmail())
                .compact();
        Cache.getInstance().add(token);
        return token;
    }
}
