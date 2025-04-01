package com.edigest.journal.app.controller;

import com.edigest.journal.app.entity.JournalEntry;
import com.edigest.journal.app.entity.userEntry;
import com.edigest.journal.app.service.journalEntryService;
import com.edigest.journal.app.service.userService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

// For Storing Data in MOngoDb
@RestController
@RequestMapping("/users") // add the mapping all over the class
public class UserController {
    @Autowired
    private userService service;

    @GetMapping()
    public ResponseEntity<List<userEntry>> findAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.FOUND);
    }

    @PostMapping()
    public ResponseEntity<userEntry> createUser(@RequestBody userEntry userEntry) {
        try {
            service.saveEntry(userEntry);
            return new ResponseEntity<>(userEntry, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//
    @PutMapping("/update/{userName}")
    public ResponseEntity<userEntry> updateEntry(@RequestBody userEntry userEntry, @PathVariable String userName) {
       userEntry userDb =  service.findByUserName(userName) ;
       if(userDb != null){
           userDb.setPassword(userEntry.getPassword());
           userDb.setUserName(userEntry.getUserName());
           service.saveEntry(userDb);
       }
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @DeleteMapping("/id/{id}")
//    public ResponseEntity<userEntry> deleteEntry(@RequestBody userEntry userEntry) {
//
//    }




}
