package com.hub.exchangerate.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "users")
public class UserEntity {

    @Id
    private Integer id;
    private String name;
    private String password;
}
