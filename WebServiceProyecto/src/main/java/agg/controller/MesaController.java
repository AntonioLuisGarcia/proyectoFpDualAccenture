package agg.controller;

import agg.dao.Mesa;
import agg.persistence.manager.MesaManager;
import agg.persistence.service.MesaService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/Mesa")
public class MesaController {

    private MesaService mesaService;

    public MesaController(){
       this.mesaService = new MesaService(new MesaManager());
    }

    @GET
    @Path("/getMesa/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMesaById(@QueryParam("id") int id) {
        Mesa mesa = mesaService.getById(id);
        if (mesa != null) {
            return Response.ok().entity(mesa).build();
        } else {                  //////
            return Response.status(400).entity("Numero de mesa no valido").build();
        }
    }
}
