package com.pkiser.weblab.biblioman.repository;


import com.pkiser.weblab.biblioman.model.Book;
import com.pkiser.weblab.biblioman.model.BookNode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Rest repository for the auditing to store the {@link BookRepository}.
 *
 * @author pkiser
 */

@RepositoryRestResource(collectionResourceRel = "book", path = "book")
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
public interface BookRepository extends MongoRepository<BookNode, String> {
    
}
