package agg.client;

import agg.persistence.dao.clases.Productos.Postre;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

public class PostreClient {

    private final WebTarget webTarget;

    public PostreClient(Client client) {
        this.webTarget = client.target("http://localhost:8082/WebServiceProyecto/api/");
    }

    /**
     * Devuelve todos los postres de la BD
     *
     * @return List<Postre>
     */
    public List<Postre> listAll(){
        return webTarget.path("postres/getAll/")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Postre>>(){});
    }

    /**
     * Devuelve un Postre mediante su Id
     *
     * @param id
     * @return Postre
     */
    public Postre getById(int id){
        return webTarget.path("postres/getPostre").
                queryParam("id", id)
                .request(MediaType.APPLICATION_JSON)
                .get(Postre.class);
    }
}
