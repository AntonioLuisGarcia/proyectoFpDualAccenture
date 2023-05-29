package agg.controller;

import agg.dao.Comanda;
import agg.interfaces.ComandaInterface;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.ComandaManager;
import agg.persistence.service.ComandaService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/comanda")
public class ComandaController implements ComandaInterface {

    private ComandaService comandaService;

    public ComandaController(){
        this.comandaService = new ComandaService(new ComandaManager(), new MySQLConnector());
    }

    /**
     * Crea una nueva comanda.
     * @param comanda la comanda a crear.
     * @return la respuesta HTTP con la comanda creada en formato JSON si los datos son válidos,
     */

    @POST
    @Path("/create/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response create(Comanda comanda) {
        if (comanda != null) {
            Comanda c = comandaService.create(comanda.getIdMesa(), comanda.getIdCamarero(), comanda.getEmailContacto());
            return Response.ok().status(Response.Status.OK).entity(c).build();
            //return Response.status(201).entity(c).build();

        } else {
            return Response.status(400).entity("Camarero o Mesa no validos").build();
        }
    }

    /**
     * Obtiene una comanda por su ID.
     * @param id el ID de la comanda que se desea obtener.
     * @return la respuesta HTTP con la comanda encontrada en formato JSON si el ID es válido,
     */

    @GET
    @Path("/getById")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getById(@QueryParam("id") int id) {
        if (id > 0) {
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

    /**
     * Obtiene todas las comandas.
     * @return la respuesta HTTP con la lista de comandas en formato JSON.
     */

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getAll() {
        List<Comanda> comandas = comandaService.getAll();
        return Response.ok().entity(comandas).build();
    }

    /**
     * Obtiene todas las comandas no pagadas.
     * @return la respuesta HTTP con la lista de comandas no pagadas en formato JSON.
     */

    @GET
    @Path("/getNoPagadas")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getNoPagadas() {
        List<Comanda> comandas = comandaService.getNoPagadas();
        return Response.ok().entity(comandas).build();
    }

    /**
     * Obtiene las comandas no pagadas por un camarero específico mediante su ID.
     * @param id el ID del camarero para filtrar las comandas.
     * @return la respuesta HTTP con la lista de comandas no pagadas del camarero en formato JSON.
     */

    @GET
    @Path("/getNoPagadasYPorIdCamarero/")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getNoPagadasYPorIdCamarero(@QueryParam("id") int id) {
        List<Comanda> comandas = comandaService.getNoPagadasYPorIdCamarero(id);
        return Response.ok().entity(comandas).build();
    }

    /**
     * Marca una comanda como pagada mediante su ID.
     * @param id el ID de la comanda que se desea marcar como pagada.
     * @return la respuesta HTTP con la comanda actualizada en formato JSON si se marca como pagada,
     */

    @PUT
    @Path("/pagar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response pagar(@PathParam("id") int id) {
        Comanda comanda = comandaService.pagar(id);

        if (comanda != null) {
            return Response.ok().entity(comanda).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("No se encontró la comanda").build();
        }
    }
}
