package com.hoanganht1k27.springsecuritybasic.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "cart")
@Data
public class Cart {
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

    @OneToMany(mappedBy = "cart")
    private List<Item> items;
}
