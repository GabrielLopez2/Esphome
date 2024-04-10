/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.controller;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import org.utl.dsm.bd.ConexionMysql;
import org.utl.dsm.model.Usuario;

/**
 *
 * created by GabrielLopez2
 */
public class ControllerLogin {
    
    public String generarToken(String usuario, String contrasenia) {
        Usuario u = new Usuario();

        u.setUserName(usuario);
        u.setPassword(contrasenia);

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

        String cadenaToken = usuario + ":" + contrasenia + ":" + timeStamp;
        byte[] bytesToHex = cadenaToken.getBytes(java.nio.charset.StandardCharsets.UTF_8);

        return bytesToHex(bytesToHex);

    }
    
    public String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
    
    public void validar(String user, String pass, String token) throws SQLException {
        String callProcedure = "{CALL validar(?, ?, ?)}";
        try {
            ConexionMysql connMysql = new ConexionMysql();
            java.sql.Connection conn = connMysql.open();
            CallableStatement statement = conn.prepareCall(callProcedure);
            statement.setString(1, user);
            statement.setString(2, pass);
            statement.setString(3, token);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            // Código de limpieza si es necesario
        }
    }
    
}
