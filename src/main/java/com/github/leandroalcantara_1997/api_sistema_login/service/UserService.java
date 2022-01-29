package com.github.leandroalcantara_1997.api_sistema_login.service;

import com.github.leandroalcantara_1997.api_sistema_login.entity.User;
import com.github.leandroalcantara_1997.api_sistema_login.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User postUser(User user){
        user = userRepository.save(user);
        return user;
    }

    public User getUser(Long id){
        return userRepository.findById(id).get();
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
