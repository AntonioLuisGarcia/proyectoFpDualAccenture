package agg.client;

import agg.persistence.dao.clases.ComandaProducto;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

public class ComandaProductoClient {

    private final WebTarget webTarget;

    public ComandaProductoClient(Client client) {
        this.webTarget = client.target("http://localhost:8082/WebServiceProyecto/api/");
    }

    /**
     * Crea una comandaProducto en la BD mediante una ComandaProducto
     *
     * @param comandaProducto
     * @return ComandaProducto
     */
    public ComandaProducto create(ComandaProducto comandaProducto){
        return webTarget.path("comandaProducto/create")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(comandaProducto, MediaType.APPLICATION_JSON),ComandaProducto.class);
    }

    /**
     * Devuelve todas las ComandasProductos con el mismo id de Comanda
     *
     * @param id
     * @return List<ComandaProducto>
     */
    public List<ComandaProducto> getByIdComanda(int id){
        return  webTarget.path("comandaProducto/getAll").
                queryParam("id", id)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<ComandaProducto>>(){});
    }

    /**
     * Actualiza la cantidad de un producto en una ComandaProducto
     *
     * @param idComanda
     * @param idProducto
     * @param cantidad
     * @return ComandaProducto
     */
    public ComandaProducto updateCantidadByIdAndIdComanda(int idComanda, int idProducto, int cantidad){
        return webTarget.path("comandaProducto/cambiarCantidad/" + idComanda + "/" + idProducto + "/" + cantidad).
                request(MediaType.APPLICATION_JSON)
                .put(Entity.entity("", MediaType.APPLICATION_JSON), ComandaProducto.class);
    }

    /**
     * Borra una comandaProducto mediante el Id
     *
     * @param idComanda
     * @param idProducto
     * @return boolean
     */
    public boolean borrarPorId(int idComanda, int idProducto){
        return webTarget.path("comandaProducto/borrar/" + idComanda + "/" + idProducto).
                request(MediaType.APPLICATION_JSON)
                .delete().getStatus() == Response.Status.OK.getStatusCode();
    }

}
