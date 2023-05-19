package agg.controller;

import agg.dao.Comanda;
import agg.persistence.manager.ComandaManager;
import agg.persistence.service.ComandaService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/comanda")
public class ComandaController {

    private ComandaService comandaService;

    public ComandaController(){
        this.comandaService = new ComandaService(new ComandaManager());
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createComanda(Comanda comanda) {
        if (comanda != null) {
            int idComanda = comandaService.createComanda(comanda.getIdMesa(), comanda.getIdCamarero(), comanda.getEmailContacto());
            return Response.status(201).entity(comanda).build();

        } else {
            return Response.status(400).entity("Camarero o Mesa no validos").build();
        }
    }

    @GET
    @Path("/getById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getComandaById(@QueryParam("id") int id) {
        if (id < 0) {
            Comanda comanda = comandaService.getById(id);
            if (comanda != null) {
                return Response.ok().entity(comanda).build();
            } else {
                return Response.status(404).entity("Comanda no encontrada").build();
            }
        } else {
            return Response.status(400).entity("Id no valido").build();
        }
    }
}
