package com.pkiser.weblab.biblioman.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * The auditing object has just a few attributes, but offers a generic way to track different auditing status. Be aware that you don't include some client data.
 *
 * @author pkiser
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book extends Basic<Book> {
    @NotNull
    @NotEmpty
    private String action;
    @NotNull
    private String status;
    private Map<String, String> extras;

    /**
     * Return the action of the auditing entry.
     *
     * @return The action text of the auditing entry.
     */
    public String getAction() {
        return action;
    }

    /**
     * Set the action of the auditing entry.
     *
     * @param action Set the action text of the auditing entry text.
     * @return The reference to this object.
     * @throws IllegalArgumentException If the argument is null.
     */
    public Book setAction(String action) {
        if (action == null || action.isEmpty()) {
            throw new IllegalArgumentException("The action must be set.");
        }
        this.action = action;
        return this;
    }



    /**
     * Return the extras.
     *
     * @return The extras of an empty map.
     */
    public Map<String, String> getExtras() {
        if (extras == null) {
            extras = new HashMap<>();
        }
        return extras;
    }

    /**
     * Put the value for the extra.
     *
     * @param key The key of the extra.
     * @param value The value of the extra.
     * @return The reference to this object.
     */
    @JsonIgnore
    public Book put(String key, String value) {
        getExtras().put(key, value);
        return this;
    }



    /**
     * Override the whole extra map.
     *
     * @param extras The whole extra map.
     * @return The reference to this object.
     */
    public Book setExtras(Map<String, String> extras) {
        this.extras = extras;
        return this;
    }

    /**
     * Return the status of the auditing entry.
     *
     * @return The auditing entry status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the status of the auditing entry.
     *
     * @param status The status of the auditing entry.
     * @return The reference to this object.
     * @throws IllegalArgumentException If the argument is null.
     */
    public Book setStatus(String status) {
        if (status == null) {
            throw new IllegalArgumentException("The status must be set.");
        }
        this.status = status;
        return this;
    }
}
