package com.github.leandroalcantara_1997.api_sistema_login.controller;

import com.github.leandroalcantara_1997.api_sistema_login.entity.User;
import com.github.leandroalcantara_1997.api_sistema_login.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    
    @PostMapping(value = "/post")
    public ResponseEntity<User> postUser(@RequestBody User user){
        user = userService.postUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping(value="/get/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        return ResponseEntity.ok().body(user);
    }
    
    @DeleteMapping(value = "/delete/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cadastro deletado com sucesso");
    }

    @PutMapping(value="put/{id}")
    public ResponseEntity<User> putUser(@PathVariable Long id, @RequestBody User user) {       
        user = userService.putUser(id, user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
    }

    @GetMapping(value="/get/login")
    public ResponseEntity<User> login(@RequestParam String user, @RequestParam String senha) throws Exception {
        User userData = userService.getLogin(user, senha);
        return ResponseEntity.status(HttpStatus.FOUND).body(userData);
    }
    
   
}
