package agg.controller;

import agg.dao.Productos.Bebida;
import agg.interfaces.ProductoInterface;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.BebidaManager;
import agg.persistence.service.BebidaService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("bebidas/")
public class BebidaController implements ProductoInterface {

    private BebidaService bebidaService;

    public BebidaController(){
        this.bebidaService = new BebidaService(new BebidaManager(), new MySQLConnector());
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getAll() {
        List<Bebida> bebidas = new ArrayList<>();
        bebidas.addAll(bebidaService.getAll());
        return Response.ok().entity(bebidas).build();
    }

    @GET
    @Path("/getOne")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getById(@QueryParam("id") int id) {
        Bebida bebida = bebidaService.getById(id);
        return Response.ok().entity(bebida).build();
    }
}
