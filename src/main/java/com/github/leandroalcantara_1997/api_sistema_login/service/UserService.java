package com.github.leandroalcantara_1997.api_sistema_login.service;

import com.github.leandroalcantara_1997.api_sistema_login.entity.User;
import com.github.leandroalcantara_1997.api_sistema_login.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User postUser(User user){
        geraToken(user);
        user = userRepository.save(user);
        return user;
    }

    public User getUser(Long id){
        return userRepository.findById(id).get();
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User putUser(Long id, User newUser){
        User oldUser = userRepository.findById(id).get();
        oldUser.setFuncao(newUser.getFuncao());
        oldUser.setUser(newUser.getUser());
        oldUser.setSenha(newUser.getSenha());
        userRepository.save(oldUser);
        return oldUser;
    }

    public User getLogin(String user, String senha) throws Exception{
        User userData = userRepository.findByUser(user);
        compareToLogin(user, senha, userData);
        return userData;
    }

    private void geraToken(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setSenha(encoder.encode(user.getUser() + user.getSenha()));
    }

    private void compareToLogin(String user, String senha, User intoUser) throws Exception{
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean log = encoder.matches(user+senha, intoUser.getSenha());
        if (!log) {
            throw new Exception("senha inválida");
        }
    }
}
