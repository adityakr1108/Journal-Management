package com.edigest.journal.app.service;

import com.edigest.journal.app.entity.JournalEntry;
import com.edigest.journal.app.entity.userEntry;
import com.edigest.journal.app.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class journalEntryService {

    @Autowired
    private JournalEntryRepository repository;

    @Autowired
    private userService userService;

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName){
        try{
            userEntry user = userService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry save =  repository.save(journalEntry);
            user.getJournalEntries().add(save);
//            user.setUserName(null);
            userService.saveEntry(user);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException("An error has been occured " , e);
        }

    }
    public void saveEntry(JournalEntry journalEntry){
        repository.save(journalEntry);
    }
    public List<JournalEntry> getAll(){
        return repository.findAll();
    }
public Optional<JournalEntry> findbyId(ObjectId id){
        return repository.findById(id);
}
    public void deleteEntry(ObjectId id, String userName){
        userEntry user =userService.findByUserName(userName);
        user.getJournalEntries().removeIf(x->x.getId().equals(id));
        userService.saveEntry(user);
        repository.deleteById(id);
    }


}
