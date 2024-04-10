/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.utl.dsm.bd.ConexionMysql;
import org.utl.dsm.model.Registro;

public class ControllerRegistro {

    public List<Registro> getAll() {
        List<Registro> registros = new ArrayList<>();
        String query = "SELECT * FROM registro";

        try {
            ConexionMysql connMysql = new ConexionMysql();
            Connection conn = connMysql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("pk_idRegistro");
                float temperature = rs.getFloat("temperature");
                float humidity = rs.getFloat("humidity");
                int brightness = rs.getInt("brightness");
                String door = rs.getString("door");
                String garage = rs.getString("garage");
                boolean led0 = rs.getBoolean("led0");
                boolean led1 = rs.getBoolean("led1");
                boolean led2 = rs.getBoolean("led2");
                String timestamp = rs.getString("timestamp");

                Registro registro = new Registro(id, temperature, humidity, brightness, door, garage, led0, led1, led2, timestamp);
                registros.add(registro);
            }

            rs.close();
            pstm.close();
            connMysql.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return registros;
    }

}
