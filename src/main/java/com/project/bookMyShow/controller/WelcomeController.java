package com.project.bookMyShow.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

import com.project.bookMyShow.request.AuthRequest;
import com.project.bookMyShow.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("")
    public String welcome() {
        return "Welcome !!";
    }

    @PostMapping("/user/login")
    public ResponseEntity<Object> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (Exception ex) {
            return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
        }
        String token = jwtUtil.generateToken(authRequest.getUsername());
        HashMap<String, Object> mp = new HashMap<>();
        mp.put("jwt", token);
        return new ResponseEntity<>(mp, HttpStatus.OK);

    }
}
