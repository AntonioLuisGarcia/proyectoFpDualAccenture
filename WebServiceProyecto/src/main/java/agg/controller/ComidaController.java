package agg.controller;

import agg.dao.Productos.Comida;
import agg.interfaces.ProductoInterface;
import agg.persistence.conector.MySQLConnector;
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
public class ComidaController implements ProductoInterface {
    private ComidaService comidaService;

    public ComidaController(){
        this.comidaService = new ComidaService(new ComidaManager(), new MySQLConnector());
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getAll() {
        List<Comida> food = comidaService.getAll();
        return Response.ok().entity(food).build();
    }

    @GET
    @Path("/getOne")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getById(@QueryParam("id") int id) {
        Comida food = comidaService.getById(id);
        return Response.ok().entity(food).build();
    }
}
