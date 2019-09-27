package com.buzilov.studying.practice.courses.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.OPTIONS}, allowedHeaders = {"Access-Control-Allow-Origin"})
public class UserController {

    @RequestMapping("/user")
    public Principal user(Principal user, HttpServletResponse response) {
        return user;
    }

}
