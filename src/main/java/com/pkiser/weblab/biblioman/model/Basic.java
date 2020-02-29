package com.pkiser.weblab.biblioman.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This abstract basic class contains all common attributes.
 *
 * @author pkiser
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Basic<T> {
    private String id;
    private Long version;
    private Date createdDate;
    private String createdBy;
    private Date lastModifiedDate;
    private String lastModifiedBy;
    @NotNull
    @NotEmpty
    private String tenant;
    @NotNull
    @NotEmpty
    @Size(min = 36, max = 36)
    private String transaction;
    private String encryptionKey;

    /**
     * Default constructor, set the id with a {@link UUID#randomUUID()} and set the same id for the transaction.
     */
    protected Basic() {
        id = UUID.randomUUID().toString();
        transaction = id;
    }

    /**
     * Return the unique identification from the node.
     *
     * @return The id from the node or <code>null</code> if not set.
     */
    public UUID getId() {
        if (id != null && !id.isEmpty()) {
            return UUID.fromString(id);
        }
        return null;
    }

    /**
     * Set the unique identification of the node.
     *
     * @param id Set a UUID as unique identification (not nullable).
     * @return The reference to this object.
     * @throws IllegalArgumentException If the argument is null.
     */
    public T setId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("The id must be set.");
        }
        this.id = id.toString();
        return (T) this;
    }

    /**
     * The optimistic lock version of the entry.
     *
     * @return The version of this object.
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Return the date, when the entry was created.
     *
     * @return The creation date.
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * Return the username, who has created the entry.
     *
     * @return The creator.
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Return the date, when the entry was updated last time.
     *
     * @return The creation date.
     */
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * Return the username, who has updated the entry.
     *
     * @return The updater.
     */
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * Return the tenant for which the records belongs to.
     *
     * @return The tenant to which the record belongs to.
     */
    public String getTenant() {
        return tenant;
    }

    /**
     * Set the tenant to which the record belongs to.
     *
     * @param tenant The tenant to which the records belongs to (not nullable).
     * @return The reference to this object.
     * @throws IllegalArgumentException If the argument is null.
     */
    public T setTenant(String tenant) {
        if (tenant == null || tenant.isEmpty()) {
            throw new IllegalArgumentException("The tenant must be set.");
        }
        this.tenant = tenant;
        return (T) this;
    }

    /**
     * Return the customer transaction id of the node. This is not the primary key of the node.
     *
     * @return The customer transaction of the node.
     */
    public UUID getTransaction() {
        if (transaction != null && !transaction.isEmpty()) {
            return UUID.fromString(transaction);
        }
        return null;
    }

    /**
     * Set the customer transaction id. The default value is set to the {@link #getId()}.
     *
     * @param transaction The logical customer reference id (not nullable).
     * @return The reference to this object.
     */
    public T setTransaction(UUID transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("The transaction must be set.");
        }
        this.transaction = transaction.toString();
        return (T) this;
    }

    /**
     * Return the encryption key.
     *
     * @return The encryption key.
     */
    public String getEncryptionKey() {
        return encryptionKey;
    }

    /**
     * Set the encryption key value.
     *
     * @param encryptionKey The value of the encryption key.
     * @return The reference to this object.
     */
    public T setEncryptionKey(String encryptionKey) {
        this.encryptionKey = encryptionKey;
        return (T) this;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Basic<?> basic = (Basic<?>) other;

        if (!id.equals(basic.id)) {
            return false;
        }
        return version.equals(basic.version);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + version.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Basic{"
                + "id='" + id + '\''
                + ", version=" + version
                + ", transaction='" + transaction + '\''
                + '}';
    }
}
