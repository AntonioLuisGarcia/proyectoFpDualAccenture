package agg.controller;

import agg.dao.Productos.Producto;
import agg.interfaces.ProductoInterface;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.BebidaManager;
import agg.persistence.manager.ComidaManager;
import agg.persistence.manager.PostreManager;
import agg.persistence.manager.ProductoManager;
import agg.persistence.service.BebidaService;
import agg.persistence.service.ComidaService;
import agg.persistence.service.PostreService;
import agg.persistence.service.ProductoService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/productos")
public class ProductoController implements ProductoInterface {

    private ProductoService productoService;
    private ComidaService comidaService;
    private BebidaService bebidaService;
    private PostreService postreService;

    public ProductoController(){
        this.productoService = new ProductoService(new ProductoManager(), new MySQLConnector());
        this.comidaService = new ComidaService(new ComidaManager(), new MySQLConnector());
        this.bebidaService = new BebidaService(new BebidaManager(), new MySQLConnector());
        this.postreService = new PostreService(new PostreManager(), new MySQLConnector());
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getAll() {
        List<Producto> products = new ArrayList<>();
        products.addAll(comidaService.getAll());
        products.addAll(bebidaService.getAll());
        products.addAll(postreService.getAll());
        return Response.ok().entity(products).build();
    }

    @GET
    @Path("/getById")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getById(@QueryParam("id") int id){
        Producto producto = productoService.getById(id);
        return Response.ok().entity(producto).build();
    }
}
