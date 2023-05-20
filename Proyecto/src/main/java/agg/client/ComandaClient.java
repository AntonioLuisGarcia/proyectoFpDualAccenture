package agg.client;

import agg.persistence.dao.clases.Comanda;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

public class ComandaClient {

    private final WebTarget webTarget;

    public ComandaClient() {
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8080/WebServiceProyecto/api/");
    }

    public List<Comanda> listAll(){
        return webTarget.path("comanda/getAll/")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Comanda>>(){});
    }

    public Comanda getById(int id){
        return webTarget.path("comanda/getById").
                queryParam("id", id)
                .request(MediaType.APPLICATION_JSON)
                .get(Comanda.class);
    }

    public Comanda createComanda(Comanda comanda){
        return webTarget.path("comanda/create").
                request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(comanda, MediaType.APPLICATION_JSON),Comanda.class);
    }

}
