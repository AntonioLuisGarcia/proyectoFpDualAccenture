package agg.controller;

import agg.dao.Comanda;
import agg.dao.ComandaProducto;
import agg.persistence.manager.ComandaProductoManager;
import agg.persistence.service.ComandaProductoService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/comandaProducto")
public class ComandaProductoController {
    private ComandaProductoService comandaProductoService;

    public ComandaProductoController(){
        this.comandaProductoService = new ComandaProductoService(new ComandaProductoManager());
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllComandaProducto(@QueryParam("id")int id){
        if(id < 0){
            List<ComandaProducto> productos = comandaProductoService.getProductosById(id);
            if(productos.isEmpty()){
                return Response.status(404).entity("ComandaProducto sin campos").build();
            }else{
                return Response.ok().entity(productos).build();
            }
        }else{
            return Response.status(400).entity("Id incorrecto").build();
        }
    }

    @POST
    @Path("/create/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createComanda(ComandaProducto comandaProducto) {
        if (comandaProducto != null) {
            ComandaProducto cp = comandaProductoService.createComandaProducto(comandaProducto.getIdProducto(), comandaProducto.getIdComanda(), comandaProducto.getCantidad());
            return Response.ok().status(Response.Status.OK).entity(cp).build();
            //return Response.status(201).entity(cp).build();
        } else {
            return Response.status(400).entity("Camarero o Mesa no validos").build();
        }
    }

    @PUT
    @Path("/cambiarCantidad/{idComanda}/{id}/{cantidad}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePago(@PathParam("idComanda") int idComanda, @PathParam("id") int id, @PathParam("cantidad") int cantidad) {
        ComandaProducto comandaProducto = comandaProductoService.updateCantidadByIdAndIdComanda(idComanda, id, cantidad);

        if (comandaProducto != null) {
            return Response.ok().entity(comandaProducto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("No se encontró la comanda").build();
        }
    }
}
