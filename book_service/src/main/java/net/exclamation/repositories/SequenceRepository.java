package net.exclamation.repositories;

import net.exclamation.mongoDB_sequnces.DatabaseSequence;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceRepository extends MongoRepository <DatabaseSequence, String> {
}
