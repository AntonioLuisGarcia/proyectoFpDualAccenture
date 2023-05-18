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

    public PostreClient() {
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8080/WebServiceProyecto/api/");
    }

    public List<Postre> listAll(){
        return webTarget.path("postres/getAll/")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Postre>>(){});
    }

    public Postre getById(int id){
        return webTarget.path("postres/getPostre").
                queryParam("id", id)
                .request(MediaType.APPLICATION_JSON)
                .get(Postre.class);
    }
}
