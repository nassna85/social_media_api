package com.socialmedia.utils;

import com.socialmedia.model.User;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestUtil {

    public static User createValidUser() {
        User user = new User();
        user.setUsername("test-user");
        user.setDisplayName("test-display");
        user.setPassword("P4ssword");
        user.setImage("profile-image.png");
        return user;
    }

    public static User createValidUser(String username) {
        User user = createValidUser();
        user.setUsername(username);
        return user;
    }

    public static String generateNumberOfChars(int max) {
        return IntStream.rangeClosed(1, max).mapToObj(x -> "a").collect(Collectors.joining());
    }
}
