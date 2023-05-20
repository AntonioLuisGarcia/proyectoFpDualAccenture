package agg.client;

import agg.persistence.dao.clases.ComandaProducto;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

public class ComandaProductoClient {

    private final WebTarget webTarget;

    public ComandaProductoClient() {
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8080/WebServiceProyecto/api/");
    }

    public ComandaProducto create(ComandaProducto comandaProducto){
        return webTarget.path("comandaProducto/create")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(comandaProducto, MediaType.APPLICATION_JSON),ComandaProducto.class);
    }

    public List<ComandaProducto> getByIdComanda(int id){
        return  webTarget.path("comandaProducto/getAll").
                queryParam("id", id)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<ComandaProducto>>(){});
    }

}
