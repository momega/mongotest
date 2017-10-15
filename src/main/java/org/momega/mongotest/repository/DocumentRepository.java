/**
 * 
 */
package org.momega.mongotest.repository;

import org.momega.mongotest.model.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author martin
 *
 */
@Repository
public interface DocumentRepository extends MongoRepository<Document, String> {

}
