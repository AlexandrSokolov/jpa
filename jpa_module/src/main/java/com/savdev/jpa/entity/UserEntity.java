package com.savdev.jpa.entity;

import com.savdev.api.UserMutable;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name=UserEntity.TABLE_NAME)
public class UserEntity implements UserMutable {

    public static final String TABLE_NAME = "users";
    public static final String FIND_BY_NAME = "findByName";

    @TableGenerator(name="User_Gen",
            table="ID_GEN",
            pkColumnName="GEN_NAME",
            valueColumnName="GEN_VAL",
            pkColumnValue="User_Gen",
            initialValue=100,
            allocationSize=100)
    @Id @GeneratedValue(generator="User_Gen")
    long id;

    @Column(name="user_name")
    String name;

    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
