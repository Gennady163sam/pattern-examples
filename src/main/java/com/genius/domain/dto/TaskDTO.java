package com.genius.domain.dto;

import com.genius.domain.transfer.Create;
import com.genius.domain.transfer.Update;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

@Data
public class TaskDTO {
    @Null(groups = Create.class)
    @NotNull(groups = Update.class)
    private Long id;
    @NotNull(groups = Create.class)
    private String description;
    @NotNull(groups = Create.class)
    private Date date;
    @NotNull(groups = Create.class)
    private Long purposeId;
}
