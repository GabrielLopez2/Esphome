package org.utl.dsm.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.utl.dsm.controller.ControllerRegistro;
import org.utl.dsm.model.Registro;
import java.util.List;

@Path("registro")
public class RestRegistro {

    @Path("getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        String out = "";

        try {
            ControllerRegistro controller = new ControllerRegistro();
            List<Registro> registros = controller.getAll();
            Gson gson = new Gson();
            out = gson.toJson(registros);
        } catch (Exception ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }

        return Response.status(Response.Status.OK).entity(out).build();
    }
}
