/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.utl.dsm.controller.ControllerLogin;

/**
 *
 * created by GabrielLopez2
 */

@Path("admin")
public class RestLogin {

    @Path("generarToken")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response generarToken(@QueryParam("usuario") String user,
            @QueryParam("contrasenia") String password) throws SQLException {

        ControllerLogin sql = new ControllerLogin();

        String out = "";
        if (user.length() > 0 && password.length() > 0) {
            String token = "";
            ControllerLogin cl = new ControllerLogin();

            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = dateTime.format(formatter);
            token = cl.generarToken(user, formattedDateTime);

            sql.validar(user, password, token);

            out = """
              {"token":"%s"}
              """;
            out = String.format(out, token);
        } else {
            out = """
              {"token":""}
              """;
        }

        return Response.ok(out).build();
    }
}
