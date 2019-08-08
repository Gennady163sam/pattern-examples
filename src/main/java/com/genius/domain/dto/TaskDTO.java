package com.genius.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TaskDTO {
    private Long id;
    private String description;
    private Date date;
    private Long purposeId;
}
