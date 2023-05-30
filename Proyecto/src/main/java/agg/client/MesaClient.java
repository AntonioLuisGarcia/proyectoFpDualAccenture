package agg.client;

import agg.persistence.dao.clases.Mesa;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class MesaClient {

    private final WebTarget webTarget;

    public MesaClient(Client client){
        this.webTarget = client.target("http://localhost:8082/WebServiceProyecto/api/");
    }

    /**
     * Devuelve una Mesa mediante el Id introducido
     *
     * @param id
     * @return Mesa
     */
    public Mesa getById(int id){
        return webTarget.path("Mesa/getMesa").
                queryParam("id", id)
                .request(MediaType.APPLICATION_JSON)
                .get(Mesa.class);
    }
}
