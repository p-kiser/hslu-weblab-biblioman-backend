package com.pkiser.weblab.biblioman.model;


import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

/**
 * This is only the Mongo DB representation.
 *
 * @author pkiser
 */
@Document(collection = "books")
public final class BookNode extends Book {

    @Override
    @Id
    public UUID getId() {
        return super.getId();
    }

    @Override
    @Id
    public Book setId(UUID id) {
        super.setId(id);
        return this;
    }

    @Override
    @Version
    public Long getVersion() {
        return super.getVersion();
    }

    @Override
    @CreatedDate
    public Date getCreatedDate() {
        return super.getCreatedDate();
    }

    @Override
    @CreatedBy
    public String getCreatedBy() {
        return super.getCreatedBy();
    }

    @Override
    @LastModifiedDate
    public Date getLastModifiedDate() {
        return super.getLastModifiedDate();
    }

    @Override
    @LastModifiedBy
    public String getLastModifiedBy() {
        return super.getLastModifiedBy();
    }
}
