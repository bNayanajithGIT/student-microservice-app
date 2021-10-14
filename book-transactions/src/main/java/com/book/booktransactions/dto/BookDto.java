package com.book.booktransactions.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.book.booktransactions.util.Constants;

import java.util.Date;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDto {
    private Long id;

    private String isbn;

    private String name;

    private String author;

    private String status;

    @JsonFormat(pattern = Constants.DATE_FORMAT_EVENT_LOG)
    private Date createdDate;

    @JsonFormat(pattern = Constants.DATE_FORMAT_EVENT_LOG)
    private Date modifiedDate;

    public BookDto(Long id, String isbn, String name, String author, String status, Date createdDate, Date modifiedDate) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.status = status;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookDto)) return false;
        BookDto that = (BookDto) o;
        return getId().equals(that.getId()) && Objects.equals(getIsbn(), that.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIsbn());
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", msisdn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", status='" + status + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
