package com.edigest.journal.app.controller;

import com.edigest.journal.app.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/jou") // add the mapping all over the class
public class JournalEntryController {
    private Map<Long, JournalEntry> journeyEntries = new HashMap<>();

    @GetMapping() // localhost:8080/journal GET
    public ArrayList<JournalEntry> getAll() {
        return new ArrayList<>(journeyEntries.values());
    }

    @PostMapping  // localhost:8080/journal POST
    public boolean createEntry(@RequestBody JournalEntry myId) {
//        journeyEntries.put(myId.getId(), myId);
        return true;
    }

    @GetMapping("id/{myId}") // here we are request the id  // localhost:8080/journal/id/{myId} GET
    public JournalEntry getById(@PathVariable long myId) { // we are using pathvaribale so that it takes up the argument from the getMapping and transfer it as a argument to map.get;
        return journeyEntries.get(myId);
    }

    @DeleteMapping("/id/{myId}") // localhost:8080/journal/id/{myId} DELETE
    public boolean deleteEntry(@PathVariable long myId) {
        journeyEntries.remove(myId);
        return true;
    }

    @PutMapping("/id/{id}") // localhost:8080/journal/id/{id} PUT
    public JournalEntry updateEntry(@PathVariable long id , @RequestBody JournalEntry myId) {
        return journeyEntries.put(id, myId);

    }



}
