package com.elm.openshift.java.rest;


import com.elm.openshift.java.dto.HelloDTO;
import com.elm.openshift.java.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class StartResource {
    @Autowired
    private final UserService userService;

    public StartResource(UserService userService) {
        this.userService = userService;
    }

    private final Logger log = LoggerFactory.getLogger(StartResource.class);

    @GetMapping("/start")
    public HelloDTO start(HttpServletRequest request) {
        log.debug("REST request to hit the service");
        userService.addUser();
        return new HelloDTO("Hello First Deployment");
    }

}
