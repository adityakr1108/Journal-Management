package com.edigest.journal.app.service;

import com.edigest.journal.app.entity.JournalEntry;
import com.edigest.journal.app.entity.userEntry;
import com.edigest.journal.app.repositery.journalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class journalEntryService {

    @Autowired
    private journalEntryRepository repository;

    @Autowired
    private userService userService;

    public void saveEntry(JournalEntry journalEntry, String userName){
        userEntry user = userService.findByUserName(userName);
        journalEntry.setDate(LocalDateTime.now());
       JournalEntry save =  repository.save(journalEntry);
       user.getJournalEntries().add(save);
       userService.saveEntry(user);
    }
    public List<JournalEntry> getAll(){
        return repository.findAll();
    }
public Optional<JournalEntry> findbyId(ObjectId id){
        return repository.findById(id);
}
    public void deleteEntry(ObjectId id, String userName){
        userEntry user =userService.findByUserName(userName);
        user.getJournalEntries().remove(repository.findById(id));
        repository.deleteById(id);
    }


}
