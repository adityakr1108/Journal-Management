package com.edigest.journal.app.service;

import com.edigest.journal.app.entity.userEntry;
import com.edigest.journal.app.repositery.userRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class userService
{
    @Autowired
    private userRepository repository;
    public void saveEntry(userEntry userEntry){
        repository.save(userEntry);
    }
    public List<userEntry> getAll(){
        return repository.findAll();
    }
    public Optional<userEntry> findbyId(ObjectId id){
        return repository.findById(id);
    }
    public void deleteEntry(ObjectId id){
        repository.deleteById(id);
    }
    public userEntry findByUserName(String username){
        return repository.findByUserName(username);
    }

}
