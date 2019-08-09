package com.genius.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class PurposeDTO {
    private Long purposeId;
    @NotNull
    private String description;
    private Date startDate;
    private Date requirementDate;
}
