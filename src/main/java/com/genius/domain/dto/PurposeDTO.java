package com.genius.domain.dto;

import com.genius.domain.transfer.Create;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

@Data
public class PurposeDTO {
    @Null(groups = Create.class)
    private Long purposeId;
    @NotNull(groups = Create.class)
    private String description;
    @Null(groups = Create.class)
    private Date startDate;
    @NotNull(groups = Create.class)
    private Date requirementDate;
}
