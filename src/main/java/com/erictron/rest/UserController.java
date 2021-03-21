package com.erictron.rest;

import com.erictron.repository.UserRepository;
import com.erictron.JPA.User;
import org.springframework.web.bind.annotation.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    // standard constructors

    private UserRepository userRepository;

    @GetMapping("/users")
    public void getUsers() {
        try {
            URL url = new URL("https://api.twitch.tv/helix/users?login=erryontv");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Authorization", "Bearer tslcuxh7e00cehsmkmhrhz4iqfeoym");
            con.setRequestProperty("Client-Id", "a6ez3w8l67mc5ily4u8kc4sn7nmbqe");
            con.setRequestMethod("GET");
            int testInt = con.getResponseCode();
        } catch (Exception e) {

        }
    }

    @PostMapping("/users")
    void addUser(@RequestBody User user) {

    }
}
