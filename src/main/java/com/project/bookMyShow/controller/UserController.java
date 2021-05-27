package com.project.bookMyShow.controller;

import java.util.HashMap;

import com.project.bookMyShow.model.User;
import com.project.bookMyShow.repository.UserRepository;
import com.project.bookMyShow.request.Request;
import com.project.bookMyShow.request.Response;
import com.project.bookMyShow.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Object> userSignUp(@RequestBody Request req) {
        HashMap<String, Object> res = userService.userSignUp(req);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> userDetails() {
        HashMap<String, Object> mp = new HashMap<>();
        mp.put("msg", "Authenticated");
        return new ResponseEntity<>(mp, HttpStatus.OK);
    }

}
