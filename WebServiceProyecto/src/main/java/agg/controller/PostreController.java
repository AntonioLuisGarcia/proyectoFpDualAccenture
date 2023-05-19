package agg.controller;

import agg.dao.Productos.Postre;
import agg.persistence.manager.PostreManager;
import agg.persistence.service.PostreService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("postres/")
public class PostreController {

    private PostreService postreService;

    public PostreController(){
        this.postreService = new PostreService(new PostreManager());
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {
        List<Postre> postres = new ArrayList<>();
        postres.addAll(postreService.getAllDesserts());
        return Response.ok().entity(postres).build();
    }

    @GET
    @Path("/getPostre")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductById(@QueryParam("id") int id) {
        Postre postre = postreService.getOneById(id);
        return Response.ok().entity(postre).build();
    }

}
