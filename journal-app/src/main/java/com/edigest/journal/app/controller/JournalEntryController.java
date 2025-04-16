package com.edigest.journal.app.controller;

import com.edigest.journal.app.entity.JournalEntry;
import com.edigest.journal.app.entity.userEntry;
import com.edigest.journal.app.service.journalEntryService;
import com.edigest.journal.app.service.userService;
import org.apache.catalina.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
 // For Storing Data in MOngoDb
@RestController
@RequestMapping("/journal") // add the mapping all over the class
public class JournalEntryController {

    @Autowired
    private journalEntryService  journalService;

    @Autowired
    private userService userService;

    @GetMapping("{userName}") // localhost:8080/journal GET
    public ResponseEntity<?> getAllUserJournalEntriesOfUsers(@PathVariable String userName)
    {
        userEntry user = userService.findByUserName(userName);
        List<JournalEntry> all = user.getJournalEntries();
        if(all != null && !all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);
    }
     else{
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("{userName}")  // localhost:8080/journal POST
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry,@PathVariable String userName) {
        try{
            journalService.saveEntry(myEntry,userName);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("id/{myId}") // here we are request the id  // localhost:8080/journal/id/{myId} GET
    public ResponseEntity<JournalEntry> getById(@PathVariable ObjectId myId) { // we are using pathvaribale so that it takes up the argument from the getMapping and transfer it as a argument to map.get;

         Optional<JournalEntry> journal = journalService.findbyId(myId);
         if(journal.isPresent()){
             return new ResponseEntity<>(journal.get(),HttpStatus.OK);
         }
         else{
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
    }

    @DeleteMapping("/id/{userName}/{myId}") // localhost:8080/journal/id/{myId} DELETE
    public ResponseEntity<?> deleteEntry(@PathVariable ObjectId myId,@PathVariable String userName) {
        journalService.deleteEntry(myId,userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/id/{userName}/{id}") // localhost:8080/journal/id/{id} PUT
    public ResponseEntity<?> updateEntry(
            @PathVariable ObjectId id ,
            @RequestBody JournalEntry newEntry,
           @PathVariable String userName) {
            JournalEntry old = journalService.findbyId(id).orElse(null);
        if(old  != null){
            old.setTitle(newEntry != null ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry != null && newEntry.getContent() != null ? newEntry.getContent() : old.getContent());
            journalService.saveEntry(old);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }



}
