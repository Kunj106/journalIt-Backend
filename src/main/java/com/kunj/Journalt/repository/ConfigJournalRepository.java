package com.kunj.Journalt.repository;

import com.kunj.Journalt.entity.ConfigJournalAppEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalRepository extends MongoRepository<ConfigJournalAppEntry, ObjectId>
{

}
