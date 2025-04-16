package com.edigest.journal.app.service;

import com.edigest.journal.app.entity.userEntry;
import com.edigest.journal.app.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class userService
{

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private userRepository repository;
    public void saveEntry(userEntry userEntry){
            userEntry.setPassword(passwordEncoder.encode(userEntry.getPassword()));
            userEntry.setRoles(Arrays.asList("USER"));
            repository.save(userEntry);
    }
    public List<userEntry> getAll(){
        return repository.findAll();
    }
//    public Optional<userEntry> findbyId(ObjectId id){
//        return repository.findById(id);
//    }
//    public void deleteEntry(ObjectId id){
//        repository.deleteById(id);
//    }
    public userEntry findByUserName(String username){
        return repository.findByUserName(username);
    }

}
