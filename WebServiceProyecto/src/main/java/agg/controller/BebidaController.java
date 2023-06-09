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

import java.util.List;

@Path("bebidas/")
public class BebidaController implements ProductoInterface {

    private BebidaService bebidaService;

    public BebidaController(){
        this.bebidaService = new BebidaService(new BebidaManager(), new MySQLConnector());
    }

    /**
     * Retorna todas las bebidas almacenadas.
     * @return una respuesta HTTP con la lista de bebidas en formato JSON.
     */
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getAll() {
        List<Bebida> bebidas = bebidaService.getAll();
        return Response.ok().entity(bebidas).build();
    }

    /**
     * Retorna una bebida según su ID.
     * @param id el ID de la bebida que se quiere obtener.
     * @return una respuesta HTTP con la bebida encontrada en formato JSON.
     */
    @GET
    @Path("/getOne")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getById(@QueryParam("id") int id) {
        Bebida bebida = bebidaService.getById(id);
        return Response.ok().entity(bebida).build();
    }
}
