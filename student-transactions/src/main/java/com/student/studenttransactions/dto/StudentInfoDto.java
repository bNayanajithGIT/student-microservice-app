package com.student.studenttransactions.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.student.studenttransactions.util.Constants;

import java.util.Date;
import java.util.Objects;

public interface StudentInfoDto {
    public Long getId();

    public String getMsisdn();

    public String getfName();

    public String getlName();

    public String getStatus();

    @JsonFormat(pattern = Constants.DATE_FORMAT_EVENT_LOG)
    public Date getCreatedDate();

    @JsonFormat(pattern = Constants.DATE_FORMAT_EVENT_LOG)
    public Date getModifiedDate();
}


