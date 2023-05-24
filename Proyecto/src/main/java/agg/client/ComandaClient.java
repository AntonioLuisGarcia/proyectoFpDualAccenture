package agg.client;

import agg.persistence.dao.clases.Comanda;
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
        this.webTarget = client.target("http://localhost:8082/WebServiceProyecto/api/");
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


    public List<Comanda> getNoPagadas(){
        return webTarget.path("comanda/getNoPagadas/")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Comanda>>(){});
    }

    public List<Comanda> getNoPagadasYPorIdCamarero(int id){
        return webTarget.path("comanda/getNoPagadasYPorIdCamarero/").
                queryParam("id", id)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Comanda>>(){});
    }

    public Comanda createComanda(Comanda comanda){
        return webTarget.path("comanda/create").
                request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(comanda, MediaType.APPLICATION_JSON),Comanda.class);
    }

    public Comanda pagarComanda(int id){
        return webTarget.path("comanda/pagar/" + id).
                request(MediaType.APPLICATION_JSON)
                .put(Entity.entity("", MediaType.APPLICATION_JSON),Comanda.class);
    }

}
