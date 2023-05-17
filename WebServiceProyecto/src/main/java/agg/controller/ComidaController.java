package agg.controller;

import agg.dao.Productos.Comida;
import agg.persistence.manager.ComidaManager;
import agg.persistence.service.ComidaService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/comida")
public class ComidaController {
    private ComidaService comidaService;

    public ComidaController(){
        this.comidaService = new ComidaService(new ComidaManager());
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {
        List<Comida> food = new ArrayList<>();
        food.addAll(comidaService.getAllFood());
        return Response.ok().entity(food).build();
    }

    @GET
    @Path("/getOne")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductById(@QueryParam("id") int id) {
        Comida food = comidaService.getOneById(id);
        return Response.ok().entity(food).build();
    }
}
