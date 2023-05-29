package agg.controller;

import agg.dao.Productos.Postre;
import agg.interfaces.ProductoInterface;
import agg.persistence.conector.MySQLConnector;
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
public class PostreController implements ProductoInterface {

    private PostreService postreService;

    public PostreController(){
        this.postreService = new PostreService(new PostreManager(), new MySQLConnector());
    }

    /**
     * Obtiene todos los postres.
     * @return la respuesta HTTP con la lista de todos los postres en formato JSON.
     */

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getAll() {
        List<Postre> postres = postreService.getAll();
        return Response.ok().entity(postres).build();
    }

    /**
     * Recupera un postre por su ID.
     * @param id el ID del postre que se desea obtener.
     * @return una respuesta HTTP con el postre correspondiente en formato JSON si el ID es válido
     */

    @GET
    @Path("/getPostre")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getById(@QueryParam("id") int id) {
        Postre postre = postreService.getById(id);
        return Response.ok().entity(postre).build();
    }
}
