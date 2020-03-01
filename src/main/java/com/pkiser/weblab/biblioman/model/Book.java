package com.pkiser.weblab.biblioman.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.*;
import java.util.HashMap;
import java.util.Map;

/**
 * The Book object contains basic information about books.
 *
 * @author pkiser
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book extends Basic<Book> {
    @NotNull
    @NotEmpty
    private String title;
    @NotNull
    private String[] authors;

    private String publisher;
    private short edition;
    @Min(-3000)
    @Max(3000)
    private int year;
    @Min(1)
    private String series;
    private String type;
    @Pattern(regexp = "[0-9]*[-| ][0-9]*[-| ][0-9]*[-| ][0-9]*[-| ][0-9]*")
    private String isbn;
    private String description;
    @DecimalMin(value="0.0")
    @DecimalMax(value="5.0")
    private float rating;









    private Map<String, String> extras;

    /**
     * Return the title of the book entry.
     *
     * @return The title text of the book entry.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of the book entry.
     *
     * @param title Set the title text of the book entry text.
     * @return The reference to this object.
     * @throws IllegalArgumentException If the argument is null.
     */
    public Book setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("The title must be set.");
        }
        this.title = title;
        return this;
    }

    /**
     * Return the authors of the book entry.
     *
     * @return The auditing entry author.
     */
    public String[] getAuthors() {
        return authors;
    }

    /**
     * Set the authors of the book entry.
     *
     * @param authors The author of the auditing entry.
     * @return The reference to this object.
     * @throws IllegalArgumentException If the argument is null.
     */
    public Book setAuthors(String[] authors) {
        if (authors == null) {
            throw new IllegalArgumentException("The author(s) must be set.");
        }
        this.authors = authors;
        return this;
    }

    /**
     * Return the extras.
     *
     * @return The extras or an empty map.
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public short getEdition() {
        return edition;
    }

    public void setEdition(short edition) {
        this.edition = edition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
