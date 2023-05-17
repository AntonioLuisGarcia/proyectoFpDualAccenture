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

    @POST////////Preguntar si POST o GET
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createComanda(@QueryParam("idMesa") int idMesa, @QueryParam("idCamarero") int idCamarero) {
        if (idMesa < 0 && idCamarero < 0) {
            int idComanda = comandaService.createComanda(idMesa, idCamarero);
            return Response.ok().entity(idComanda).build();

        } else {
            return Response.status(400).entity("Camarero o Mesa no validos").build();
        }
    }

    @GET
    @Path("/getById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCamareroWithParameters(@QueryParam("id") int id) {
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
