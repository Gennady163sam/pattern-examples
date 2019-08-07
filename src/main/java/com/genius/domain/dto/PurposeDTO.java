package com.genius.domain.dto;

import lombok.Data;
import java.util.Date;

@Data
public class PurposeDTO {
    private Long purposeId;
    private String description;
    private Date startDate;
    private Date requirementDate;
}
