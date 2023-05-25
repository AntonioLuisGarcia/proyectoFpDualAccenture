package agg.controller;

import agg.dao.ComandaProducto;
import agg.interfaces.ComandaProductoControllerInterface;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.ComandaProductoManager;
import agg.persistence.service.ComandaProductoService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/comandaProducto")
public class ComandaProductoController implements ComandaProductoControllerInterface {
    private ComandaProductoService comandaProductoService;

    public ComandaProductoController(){
        this.comandaProductoService = new ComandaProductoService(new ComandaProductoManager(), new MySQLConnector());
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getAll(@QueryParam("id")int id){
        if(id > 0){
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

    @GET
    @Path("/getById")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getById(@QueryParam("id")int id){
        if(id > 0){
            ComandaProducto producto = comandaProductoService.getById(id);
            if(producto == null){
                return Response.status(404).entity("ComandaProducto sin campos").build();
            }else{
                return Response.ok().entity(producto).build();
            }
        }else{
            return Response.status(400).entity("Id incorrecto").build();
        }
    }

    @POST
    @Path("/create/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response create(ComandaProducto comandaProducto) {
        if (comandaProducto != null) {
            ComandaProducto cp = comandaProductoService.create(comandaProducto.getIdProducto(), comandaProducto.getIdComanda(), comandaProducto.getCantidad());
            return Response.ok().status(Response.Status.OK).entity(cp).build();
            //return Response.status(201).entity(cp).build();
        } else {
            return Response.status(400).entity("Camarero o Mesa no validos").build();
        }
    }

    @PUT
    @Path("/cambiarCantidad/{idComanda}/{idProducto}/{cantidad}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response updateCantidadByIdAndIdComanda(@PathParam("idComanda") int idComanda, @PathParam("idProducto") int idProducto, @PathParam("cantidad") int cantidad) {
        ComandaProducto comandaProducto = comandaProductoService.updateCantidadByIdAndIdComanda(idComanda, idProducto, cantidad);

        if (comandaProducto != null) {
            return Response.ok().entity(comandaProducto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("No se encontró la comanda").build();
        }
    }

    @DELETE
    @Path("/borrar/{idComanda}/{idProducto}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response borrarPorId(@PathParam("idComanda") int idComanda, @PathParam("idProducto") int idProducto){
        boolean eliminado = comandaProductoService.borrarPorId(idComanda, idProducto);
        if (eliminado) {
            // Si el registro fue eliminado exitosamente
            return Response.ok().entity(eliminado).build();
        } else {
            // Si no se pudo eliminar el registro
            return Response.status(Response.Status.NOT_FOUND).entity("No se encontró el registro").build();
        }
    }
}
