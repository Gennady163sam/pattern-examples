package com.genius.domain.purposes;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "tasks")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String description;
    @Column
    private Date date;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "purp_id", referencedColumnName = "purp_id")
    private Purpose purpose;
}
