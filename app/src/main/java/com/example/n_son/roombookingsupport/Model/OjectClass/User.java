package com.example.n_son.roombookingsupport.Model.OjectClass;

/**
 * Created by N-SON on 26/10/2017.
 */

public class User {
    int UserId;
    String userName, Email, TypeUser, Gender;

    public User(int userId, String userName, String email, String typeUser, String gender) {
        UserId = userId;
        this.userName = userName;
        Email = email;
        TypeUser = typeUser;
        Gender = gender;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTypeUser() {
        return TypeUser;
    }

    public void setTypeUser(String typeUser) {
        TypeUser = typeUser;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
