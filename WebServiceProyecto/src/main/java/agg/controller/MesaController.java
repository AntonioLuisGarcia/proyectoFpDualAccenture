package agg.controller;

import agg.dao.Mesa;
import agg.interfaces.MesaInterface;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.MesaManager;
import agg.persistence.service.MesaService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/Mesa")
public class MesaController implements MesaInterface {

    private MesaService mesaService;

    public MesaController(){
       this.mesaService = new MesaService(new MesaManager(), new MySQLConnector());
    }

    /**
     * Obtiene una mesa por su ID.
     * @param id el ID de la mesa que se desea obtener.
     * @return la respuesta HTTP con la mesa encontrada en formato JSON si el ID es válido
     */

    @GET
    @Path("/getMesa/")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getById(@QueryParam("id") int id) {
        Mesa mesa = mesaService.getById(id);
        return Response.ok().entity(mesa).build();
    }
}
