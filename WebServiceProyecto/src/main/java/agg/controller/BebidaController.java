package agg.controller;

import agg.dao.Productos.Bebida;
import agg.persistence.manager.BebidaManager;
import agg.persistence.service.BebidaService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("bebidas/")
public class BebidaController {

    private BebidaService bebidaService;

    public BebidaController(){
        this.bebidaService = new BebidaService(new BebidaManager());
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {
        List<Bebida> bebidas = new ArrayList<>();
        bebidas.addAll(bebidaService.getAllDrinks());
        return Response.ok().entity(bebidas).build();
    }
}
