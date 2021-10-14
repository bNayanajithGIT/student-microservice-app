package com.student.studenttransactions.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.student.studenttransactions.util.Constants;

import java.util.Date;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDto {
    private Long id;

    private String msisdn;

    private String fName;

    private String lName;

    private String status;

    @JsonFormat(pattern = Constants.DATE_FORMAT_EVENT_LOG)
    private Date createdDate;

    @JsonFormat(pattern = Constants.DATE_FORMAT_EVENT_LOG)
    private Date modifiedDate;

    public StudentDto(Long id, String msisdn, String fName, String lName, String status, Date createdDate, Date modifiedDate) {
        this.id = id;
        this.msisdn = msisdn;
        this.fName = fName;
        this.lName = lName;
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

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getStatus() {
        return status;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
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
        if (!(o instanceof StudentDto)) return false;
        StudentDto that = (StudentDto) o;
        return getId().equals(that.getId()) && Objects.equals(getMsisdn(), that.getMsisdn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMsisdn());
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", msisdn='" + msisdn + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", status='" + status + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
