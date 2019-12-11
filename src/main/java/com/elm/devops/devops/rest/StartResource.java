package com.elm.devops.devops.rest;


import com.elm.devops.devops.dto.HelloDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class StartResource {
    private final Logger log = LoggerFactory.getLogger(StartResource.class);

    @GetMapping("/start")
    public HelloDTO start(HttpServletRequest request) {
        log.debug("REST request to hit the service");
        return new HelloDTO("Hello First Deployment");
    }

}
