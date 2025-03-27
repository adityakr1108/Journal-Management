package com.edigest.journal.app.controller;

import com.edigest.journal.app.entity.JournalEntry;
import com.edigest.journal.app.service.journalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal") // add the mapping all over the class
public class JournalEntryControllerV2 {

    @Autowired
    public journalEntryService  service;
    @GetMapping() // localhost:8080/journal GET
    public ResponseEntity<List<JournalEntry>> getAllData()
    {
        List<JournalEntry> all = service.getAll();
        if(all != null && !all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);
    }
     else{
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping  // localhost:8080/journal POST
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myId) {
        try {
            myId.setDate(LocalDateTime.now());
            service.saveEntry(myId);
            return new ResponseEntity<>(myId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{myId}") // here we are request the id  // localhost:8080/journal/id/{myId} GET
    public ResponseEntity<JournalEntry> getById(@PathVariable ObjectId myId) { // we are using pathvaribale so that it takes up the argument from the getMapping and transfer it as a argument to map.get;

         Optional<JournalEntry> journal = service.findbyId(myId);
         if(journal.isPresent()){
             return new ResponseEntity<>(journal.get(),HttpStatus.OK);
         }
         else{
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
    }

    @DeleteMapping("/id/{myId}") // localhost:8080/journal/id/{myId} DELETE
    public ResponseEntity<?> deleteEntry(@PathVariable ObjectId myId) {
        service.deleteEntry(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/id/{id}") // localhost:8080/journal/id/{id} PUT
    public ResponseEntity<?> updateEntry(@PathVariable ObjectId id , @RequestBody JournalEntry newEntry) {
        JournalEntry old = service.findbyId(id).orElse(null);
        if(old  != null){
            old.setTitle(newEntry != null && newEntry.getTitle() != null ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry != null && newEntry.getContent() != null ? newEntry.getContent() : old.getContent());
            service.saveEntry(old);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }



}
