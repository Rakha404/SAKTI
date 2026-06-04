/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import services.authservices;

/**
 *
 * @author galuh
 */
public class UserInjector {
    public static void main(String[] args) {
        authservices userService = new authservices();
        userService.registerUser("Xaviera", "uhn", "123"); 
    }
}
