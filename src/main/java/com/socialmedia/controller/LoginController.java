package com.socialmedia.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.socialmedia.annotation.CurrentUser;
import com.socialmedia.config.Views;
import com.socialmedia.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @PostMapping
    @JsonView(Views.BaseUser.class)
    public User handleLogin(@CurrentUser User loggedInUser) {
        return loggedInUser;
    }

}
