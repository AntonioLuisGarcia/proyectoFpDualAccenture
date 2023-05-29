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

    /**
     * Obtiene todos los productos de una comanda según su ID.
     * @param id el ID de la comanda.
     * @return la respuesta HTTP con la lista de productos de la comanda en formato JSON si el ID es válido
     */

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

    /**
     * Obtiene un producto de una comanda por su ID.
     * @param id el ID del producto de la comanda que se desea obtener.
     * @return la respuesta HTTP con el producto de la comanda encontrado en formato JSON si el ID es válido
     */

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

    /**
     * Crea un nuevo producto para una comanda.
     * @param comandaProducto el producto de la comanda a crear.
     * @return la respuesta HTTP con el producto de la comanda creado en formato JSON si los datos son válidos
     */

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

    /**
     * Actualiza la cantidad de un producto en una comanda según su ID y el ID de la comanda.
     * @param idComanda el ID de la comanda.
     * @param idProducto el ID del producto.
     * @param cantidad la nueva cantidad del producto.
     * @return la respuesta HTTP con el producto de la comanda actualizado en formato JSON si los datos son válidos
     */

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

    /**
     * Borra un producto de una comanda según su ID y el ID de la comanda.
     * @param idComanda el ID de la comanda.
     * @param idProducto el ID del producto.
     * @return una respuesta HTTP indicando si se eliminó o no el producto de la comanda.
     */

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
