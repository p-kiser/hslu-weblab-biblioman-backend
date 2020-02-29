package com.pkiser.weblab.biblioman.repository;


import com.pkiser.weblab.biblioman.model.BookNode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

/**
 * Rest repository for the auditing to store the {@link BookRepository}.
 *
 * @author pkiser
 */
@RepositoryRestResource(collectionResourceRel = "book", path = "book")
@Transactional
public interface BookRepository extends MongoRepository<BookNode, String> {

}
