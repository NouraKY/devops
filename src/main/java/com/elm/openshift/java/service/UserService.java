package com.elm.openshift.java.service;

import com.elm.openshift.java.domain.User;
import com.elm.openshift.java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public void addUser(){
        userRepository.save(new User("norah"));
    }


}
