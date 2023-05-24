package agg.client;

import agg.persistence.dao.clases.Mesa;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class MesaClient {

    private final WebTarget webTarget;

    public MesaClient(){
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8082/WebServiceProyecto/api/");
    }

    public Mesa getById(int id){
        return webTarget.path("Mesa/getMesa").
                queryParam("id", id)
                .request(MediaType.APPLICATION_JSON)
                .get(Mesa.class);
    }
}
