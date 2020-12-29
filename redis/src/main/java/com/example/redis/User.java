package com.example.redis;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @Column(name = "user_Id", nullable = false, unique = true)
    private String userInstagramId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "instagram_name", nullable = false)
    private String userInstagramName;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "folowers_amount", nullable = false)
    private int folowersAmount;

    @Column(name = "folowings_amount", nullable = false)
    private int folowingsAmount;

    /*@JsonIgnore
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<String> postsIds;


     */
    public User(String userId, String name, String surname, String userinstagramname, String password, int folowersamount, int folowingsamount){//, List<String> p) {
        this.userInstagramId = userId;
        this.name = name;
        this.surname = surname;
        this.userInstagramName = userinstagramname;
        this.userPassword = password;
        this.folowersAmount = folowersamount;
        this.folowingsAmount = folowingsamount;
        //this.postsIds =  p;
    }

    public User() {
    }


    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserInstagramName() {
        return userInstagramName;
    }

    public void setUserInstagramName(String userInstagramName) {
        this.userInstagramName = userInstagramName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getFolowersAmount() {
        return folowersAmount;
    }

    public void setFolowersAmount(int folowersAmount) {
        this.folowersAmount = folowersAmount;
    }

    public int getFolowingsAmount() {
        return folowingsAmount;
    }

    public void setFolowingsAmount(int folowingsAmount) {
        this.folowingsAmount = folowingsAmount;
    }
    /*
    public List<String> getPosts() {
        return postsIds;
    }

    public void setPosts(List<String> posts) {
        this.postsIds = posts;
    }

     */

    public String getUserid() {
        return userInstagramId;
    }

    public void setUserId(String userId) {
        this.userInstagramId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    //public void setUserid(String userid) {
    //   this.userid = userid;
    //}
}
