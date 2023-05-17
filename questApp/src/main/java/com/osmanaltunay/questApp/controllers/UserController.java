package com.osmanaltunay.questApp.controllers;

import com.osmanaltunay.questApp.entities.User;
import com.osmanaltunay.questApp.repos.UserRepository;
import com.osmanaltunay.questApp.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @PostMapping
    public User creatUser(@RequestBody() User newUser){
        return userService.createUser(newUser);
    }
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }
    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser){
        return userService.updateUser(userId,newUser);
    }
    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable Long userId){
        userService.deleteUser(userId);
    }


}
