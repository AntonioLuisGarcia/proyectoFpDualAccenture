package agg.controller;

import agg.dao.ComandaProducto;
import agg.persistence.service.ComandaProductoService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/comandaProducto")
public class ComandaProductoController {
    private ComandaProductoService comandaProductoService;

    public ComandaProductoController(ComandaProductoService comandaProductoService){
        this.comandaProductoService = comandaProductoService;
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
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createComanda(ComandaProducto comandaProducto) {
        if (comandaProducto != null) {
            int idComandaProducto = comandaProductoService.createComandaProducto(comandaProducto.getIdComanda(), comandaProducto.getIdProducto(), comandaProducto.getCantidad());
            return Response.status(201).entity(comandaProducto).build();
        } else {
            return Response.status(400).entity("Camarero o Mesa no validos").build();
        }
    }
}
