package com.rest.davetlimsiniz.entity.user;

import com.rest.davetlimsiniz.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Getter
@Setter
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class User extends AbstractEntity {

    private String email;
    private String password;
    private Boolean isAdmin = Boolean.FALSE;


}
