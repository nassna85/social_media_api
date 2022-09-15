package com.socialmedia.controller;

import com.socialmedia.error.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @PostMapping
    public void handleLogin() {

    }

}
