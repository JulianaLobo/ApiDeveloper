package com.iftm.ApiDeveloper.repositories;

import com.iftm.ApiDeveloper.models.Developer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends MongoRepository<Developer, ObjectId> {
}
