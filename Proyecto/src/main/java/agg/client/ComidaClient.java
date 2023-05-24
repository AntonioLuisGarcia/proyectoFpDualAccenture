package agg.client;

import agg.persistence.dao.clases.Productos.Comida;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

public class ComidaClient {

    private final WebTarget webTarget;

    public ComidaClient() {
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8082/WebServiceProyecto/api/");
    }

    public List<Comida> listAll(){
        return webTarget.path("comida/getAll/")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Comida>>(){});
    }

    public Comida getProductById(int id){
        return webTarget.path("comida/getOne").
                queryParam("id", id)
                .request(MediaType.APPLICATION_JSON)
                .get(Comida.class);
    }
}
