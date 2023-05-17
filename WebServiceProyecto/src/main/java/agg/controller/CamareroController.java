package agg.controller;

import agg.dao.Camarero;

import agg.persistence.manager.CamareroManager;
import agg.persistence.service.CamareroService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/camareros")
public class CamareroController {

    private CamareroService camareroService;

    public CamareroController() {
        this.camareroService = new CamareroService(new CamareroManager());
    }

    @GET
    @Path("/get/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCamareroWithParameters(@QueryParam("user") String user, @QueryParam("password") String password) {
        if (user != null && password != null) {
            Camarero camarero = camareroService.verificateUserByUserAndPassword(user, password);

            if (camarero != null) {
                return Response.ok().entity(camarero).build();
            } else {
                return Response.status(404).entity("Camarero no encontrado").build();
            }
        } else {
            return Response.status(400).entity("Usuario o contraseña no validos").build();
        }
    }
}
