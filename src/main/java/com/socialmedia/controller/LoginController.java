package com.socialmedia.controller;

import com.socialmedia.annotation.CurrentUser;
import com.socialmedia.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @PostMapping
    public Map<String, Object> handleLogin(@CurrentUser User loggedInUser) {
        return Collections.singletonMap("id", loggedInUser.getId());
    }

}
