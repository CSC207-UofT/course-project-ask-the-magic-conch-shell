package com.bookSystem.entity.User;

import com.bookSystem.useCase.DBUserManager;

/**
 * Represents a User in the system 
 */
public abstract class User {

    public DBUserManager DBUserManager;
    /**
     * The username of a User
     */
    private String username;
    /**
     * User's password
     */
    private String Password;

    /**
     * A new User with username
     * @param username username
     */

    public User(String username) {this.username = username;
    }

    /**
     * To set up a User's password
     * @param password user's password
     */

    public void setPassword(String password){

        this.Password = password;
    }

    /**
     * Return a User's password
     * @return user's password
     */
    public String getPassword(){

        return this.Password;
    }

    /**
     * Return the a User's username
     * @return username
     */
    public String getUsername(){

        return this.username;
    }



}
