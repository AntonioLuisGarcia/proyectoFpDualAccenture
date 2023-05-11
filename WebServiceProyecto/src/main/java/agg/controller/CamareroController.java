package agg.controller;

import agg.dao.Camarero;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/camareros")
public class CamareroController {
    @GET
    @Path("/get/{id}/name")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotificationWithParameters(@PathParam("user") int id, @QueryParam("password") String name) {
        if (name == null || name.trim().isEmpty()) {
            return Response.status(400).entity("Name not present in the request").build();
        } else {
            return Response.ok().entity(new Camarero(id, "nombre", "apellidos", "user","password")).build();
        }
    }
}
