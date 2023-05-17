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

    @POST////////Preguntar si POST o GET
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createComanda(@QueryParam("idProducto") int idProducto, @QueryParam("idComanda") int idComanda, @QueryParam("cantidad") int cantidad) {
        if (idComanda < 0 && idProducto < 0 && cantidad > -1) {
            int idComandaProducto = comandaProductoService.createComandaProducto(idProducto, idComanda, cantidad);
            return Response.ok().entity(idComandaProducto).build();
        } else {
            return Response.status(400).entity("Camarero o Mesa no validos").build();
        }
    }
}
