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

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getAll() {
        List<Comanda> comandas = comandaService.getAll();
        return Response.ok().entity(comandas).build();
    }

    @GET
    @Path("/getNoPagadas")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getNoPagadas() {
        List<Comanda> comandas = comandaService.getNoPagadas();
        return Response.ok().entity(comandas).build();
    }

    @GET
    @Path("/getNoPagadasYPorIdCamarero/")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getNoPagadasYPorIdCamarero(@QueryParam("id") int id) {
        List<Comanda> comandas = comandaService.getNoPagadasYPorIdCamarero(id);
        return Response.ok().entity(comandas).build();
    }

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
