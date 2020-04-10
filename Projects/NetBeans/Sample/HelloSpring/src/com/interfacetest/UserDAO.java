/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interfacetest;

/**
 *
 * @author Administrator
 */
public interface UserDAO {

    // subclass is contracted to implement this action method
    void createUser();

    void updateUser();

    void deleteUser();

    // this is an additional created method
    // make changes to the existing interface without breaking it's existing subclasses
    // it's up to the subclass to implement this default method
    default void bar() {
//        System.out.println("BAR AT UserDAO");
    }

}
