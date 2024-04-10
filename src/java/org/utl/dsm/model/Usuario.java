/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.model;

/**
 *
 * created by GabrielLopez2
 */
public class Usuario {
    private int idUsuario;
    private String userName;
    private String password;
    private String token;
    private String lastConnect; // tipo date 

    public Usuario() {
    }

    public Usuario(int idUsuario, String userName, String password, String token, String lastConnect) {
        this.idUsuario = idUsuario;
        this.userName = userName;
        this.password = password;
        this.token = token;
        this.lastConnect = lastConnect;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLastConnect() {
        return lastConnect;
    }

    public void setLastConnect(String lastConnect) {
        this.lastConnect = lastConnect;
    }
    
    
}
