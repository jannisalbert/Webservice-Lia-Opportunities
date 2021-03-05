package se.albertssonmueller.webservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpportunityDto {

    private long id;

    private long companyId;
    private long contactId;
    private long statusId;
    private long priorityId;
    private String comment;
    private LocalDate dateCreated = LocalDate.now();
    private String regSign;

    public OpportunityDto() {
    }

    public OpportunityDto(long id, long companyId, long contactId, long statusId,
                          long priorityId, String comment, LocalDate dateCreated, String regSign) {
        this.id = id;
        this.companyId = companyId;
        this.contactId = contactId;
        this.statusId = statusId;
        this.priorityId = priorityId;
        this.comment = comment;
        this.dateCreated = dateCreated;
        this.regSign = regSign;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    public long getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(long priorityId) {
        this.priorityId = priorityId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getRegSign() {
        return regSign;
    }

    public void setRegSign(String regSign) {
        this.regSign = regSign;
    }
}
