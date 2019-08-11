package com.genius.domain.purposes;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "purposes")
public class Purpose implements Serializable {
    @Id
    @Column(name = "purp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purposeId;
    @Column(name = "purp_description", nullable = false, length = 1024)
    private String description;
    @Column(name = "purp_date_start")
    private Date startDate;
    @Column(name = "purp_req_date")
    private Date requirementDate;

    public Long getPurposeId() {
        return purposeId;
    }

    public void setPurposeId(Long purposeId) {
        this.purposeId = purposeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getRequirementDate() {
        return requirementDate;
    }

    public void setRequirementDate(Date requirementDate) {
        this.requirementDate = requirementDate;
    }
}
