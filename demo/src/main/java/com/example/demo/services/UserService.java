package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(String fName, String mName, String lName) {
        User user = new User();
        user.setFName(fName);
        user.setMName(mName);
        user.setLName(lName);
        String password = generatePass(fName, mName, lName);
        user.setPassword(password);

        return userRepository.save(user);
}

    private String generatePass(String fName, String mName, String lName) {
        String firstPart = fName.substring(0, 2) + mName.substring(0, 2) + lName.substring(0, 2);
        int randomNum = 100 + (int) (Math.random() * 900) ;
        return firstPart + randomNum;
     }


    public List<User> getAllUsers() { 
        return userRepository.findAll();
     }

}
