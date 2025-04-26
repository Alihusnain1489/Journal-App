package com.spring.journalapp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.journalapp.entity.JournalEntry;

public interface JournalEntryRepo extends MongoRepository <JournalEntry, ObjectId> {
   
   

}
