package agg.client;

import agg.persistence.dao.clases.Productos.Bebida;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

public class BebidaClient {

    private final WebTarget webTarget;

    public BebidaClient() {
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8080/WebServiceProyecto/api/");
    }

    public List<Bebida> listAll(){
        return webTarget.path("bebidas/getAll/")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Bebida>>(){});
    }

    public Bebida getById(int id){
        return webTarget.path("bebidas/getOne").
                queryParam("id",id)
                .request(MediaType.APPLICATION_JSON)
                .get(Bebida.class);
    }
}
