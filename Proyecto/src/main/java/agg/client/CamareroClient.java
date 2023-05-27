package agg.client;

import agg.persistence.dao.clases.Camarero;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class CamareroClient {
    private final WebTarget webTarget;

    public CamareroClient() {
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8082/WebServiceProyecto/api/");
    }

    public Camarero verificateUserByUserAndPassword(String user, String password){
                                                    ////////////////////
        return webTarget.path("camareros/get/login")
                .queryParam("user",user)
                .queryParam("password", password)
                .request(MediaType.APPLICATION_JSON)
                .get(Camarero.class);
    }

    public Camarero getById(int id){
        return webTarget.path("camareros/getById")
                .queryParam("id",id)
                .request(MediaType.APPLICATION_JSON)
                .get(Camarero.class);
    }
}
