package com.hoanganht1k27.springsecuritybasic.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String pwd;

    @Column
    private String role;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("customer")
    private List<Authority> authorities;
}
