package com.edigest.journal.app.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Document (collection = "user_entry")
public class userEntry {
    @Id
    private ObjectId id;

    @Setter
    @Getter
    @Indexed(unique = true)
    private String userName;
    @NonNull
    private String email;
    @NonNull
    private String password;


    @DBRef
    private List<JournalEntry> journalEntries = new ArrayList<>();
}
