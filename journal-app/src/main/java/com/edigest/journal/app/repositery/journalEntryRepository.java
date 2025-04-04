package com.edigest.journal.app.repositery;

import com.edigest.journal.app.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;

public interface journalEntryRepository extends MongoRepository<JournalEntry, ObjectId>{
}
