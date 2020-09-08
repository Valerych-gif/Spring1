package com.valerych.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "username")
    private String username;

    @JoinColumn(name = "password")
    private String password;

    @JoinColumn(name = "name")
    private String name;

    @JoinColumn(name = "phone_number")
    private String phoneNumber;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;
}
