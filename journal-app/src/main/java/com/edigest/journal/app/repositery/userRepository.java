package com.edigest.journal.app.repositery;

import com.edigest.journal.app.entity.userEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface userRepository extends MongoRepository<userEntry, ObjectId> {
    userEntry findByUserName(String username);
}
