package se.albertssonmueller.webservice.entities;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "opportunities")
public class Opportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long companyId;
    private Long contactId;
    private Long statusId;
    private Long priorityId;
    private String comment;
    private LocalDate dateCreated = LocalDate.now();
    private String regSign;

    public Opportunity() {
    }

    public Opportunity(Long id, Long companyId, Long contactId,
                       Long statusId, Long priorityId, String comment, LocalDate dateCreated, String regSign) {
        this.id = id;
        this.companyId = companyId;
        this.contactId = contactId;
        this.statusId = statusId;
        this.priorityId = priorityId;
        this.comment = comment;
        this.dateCreated = dateCreated;
        this.regSign = regSign;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Long getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(Long priority) {
        this.priorityId = priority;
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
