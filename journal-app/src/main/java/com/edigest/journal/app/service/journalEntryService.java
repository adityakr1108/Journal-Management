package com.edigest.journal.app.service;

import com.edigest.journal.app.entity.JournalEntry;
import com.edigest.journal.app.repositery.journalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class journalEntryService {

    @Autowired
    private journalEntryRepository repository;

    public void saveEntry(JournalEntry journalEntry){
        repository.save(journalEntry);
    }
    public List<JournalEntry> getAll(){
        return repository.findAll();
    }
public Optional<JournalEntry> findbyId(ObjectId id){
        return repository.findById(id);
}
    public void deleteEntry(ObjectId id){
        repository.deleteById(id);
    }


}
