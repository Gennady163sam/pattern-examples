package com.genius.domain.security;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
}
