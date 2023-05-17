package com.osmanaltunay.questApp.services;

import com.osmanaltunay.questApp.entities.User;
import com.osmanaltunay.questApp.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public User createUser(User newUser){
        return userRepository.save(newUser);
    }

    public User getUserById(Long userId){
        return userRepository.findById(userId).orElse(null);
    }
    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }
    public User updateUser(Long userId, User newUser){
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUsername(newUser.getUsername());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        }else
            return null;
    }
}
