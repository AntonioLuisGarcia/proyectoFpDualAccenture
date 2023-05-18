package agg.controller;

import agg.dao.Productos.Producto;
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
public class ProductoController {

    private ProductoService productoService;
    private ComidaService comidaService;
    private BebidaService bebidaService;
    private PostreService postreService;

    public ProductoController(){
        this.productoService = new ProductoService(new ProductoManager());
        this.comidaService = new ComidaService(new ComidaManager());
        this.bebidaService = new BebidaService(new BebidaManager());
        this.postreService = new PostreService(new PostreManager());
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {
        List<Producto> products = new ArrayList<>();
        products.addAll(comidaService.getAllFood());
        products.addAll(bebidaService.getAllDrinks());
        products.addAll(postreService.getAllDesserts());
        return Response.ok().entity(products).build();
    }

    @GET
    @Path("/getById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response Producto(@QueryParam("id") int id){
        Producto producto = productoService.getById(id);
        return Response.ok().entity(producto).build();
    }
}
