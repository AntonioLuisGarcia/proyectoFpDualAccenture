package agg.controller;

import agg.dao.Camarero;

import agg.interfaces.CamareroInterface;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.CamareroManager;
import agg.persistence.service.CamareroService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/camareros")
public class CamareroController implements CamareroInterface {

    private CamareroService camareroService;


    public CamareroController() {
        this.camareroService = new CamareroService(new CamareroManager(), new MySQLConnector());
    }

    /**
     * Obtiene un camarero por su nombre de usuario y contraseña.
     * @param user el nombre de usuario del camarero.
     * @param password la contraseña del camarero.
     * @return la respuesta HTTP con el camarero encontrado en formato JSON si las credenciales son válidas,
     */

    @GET
    @Path("/get/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getCamareroByUserAndPassword(@QueryParam("user") String user, @QueryParam("password") String password) {
        if (user != null && password != null) {
            Camarero camarero = camareroService.getCamareroByUserAndPassword(user, password);
            return Response.ok().entity(camarero).build();

        } else {
            return Response.status(400).entity("Usuario o contraseña no validos").build();
        }
    }

    /**
     * Obtiene un camarero por su ID.
     * @param id el ID del camarero que se desea obtener.
     * @return la respuesta HTTP con el camarero encontrado en formato JSON si el ID es válido,
     */

    @GET
    @Path("/getById")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getById(@QueryParam("id") int id) {
        if (id > 0) {
            Camarero camarero = camareroService.getById(id);
            if (camarero != null) {
                return Response.ok().entity(camarero).build();
            } else {
                return Response.status(404).entity("Comanda no encontrada").build();
            }
        } else {
            return Response.status(400).entity("Id no valido").build();
        }
    }
}
