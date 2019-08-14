package com.genius.domain.security;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
                joinColumns = { @JoinColumn(name = "user_user_id")},
                inverseJoinColumns = { @JoinColumn(name = "role_role_id")})
    private List<Role> roles;
}
