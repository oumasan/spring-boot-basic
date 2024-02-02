package com.example.springbootbase.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ユーザー情報モデル
 */
public class UserModel {

    private Integer id = null;
    @NotNull
    @Size(min= 1, max = 50, message = "firstNameは1～50桁を入力してください")
    private String firstName = "";
    @NotNull
    @Size(min= 1, max = 50, message = "lastNameは1～50桁を入力してください")
    private String lastName = "";
    @NotNull
    @Size(min= 1, max = 100, message = "addressは1～100桁を入力してください")
    private String address = "";
    private LocalDateTime createDate = null;

    private LocalDateTime updateDate = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

}
