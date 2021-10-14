package com.book.booktransactions.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.book.booktransactions.util.Constants;

import java.util.Date;
import java.util.Objects;

public interface BookInfoDto {
    public Long getId();

    public String getIsbn();

    public String getName();

    public String getAuthor();

    public String getStatus();

    @JsonFormat(pattern = Constants.DATE_FORMAT_EVENT_LOG)
    public Date getCreatedDate();

    @JsonFormat(pattern = Constants.DATE_FORMAT_EVENT_LOG)
    public Date getModifiedDate();
}


