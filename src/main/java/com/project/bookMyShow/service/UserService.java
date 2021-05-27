package com.project.bookMyShow.service;

import java.util.HashMap;
import java.util.Optional;

import com.project.bookMyShow.model.User;
import com.project.bookMyShow.repository.UserRepository;
import com.project.bookMyShow.request.Request;
import com.project.bookMyShow.request.Response;
import com.project.bookMyShow.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRep;

    @Autowired
    private JwtUtil jwtUtil;

    public HashMap<String, Object> userSignUp(Request req) {
        String pass = BCrypt.hashpw(req.getPassword(), BCrypt.gensalt(10));
        User user = new User(req.getUsername(), pass, req.getEmail());
        userRep.save(user);
        String jwt = jwtUtil.generateToken(req.getUsername());
        HashMap<String, Object> mp = new HashMap<>();
        mp.put("jwt", jwt);
        return mp;
    }

}
