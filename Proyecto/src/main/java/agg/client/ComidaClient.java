package agg.client;

import agg.persistence.dao.clases.Productos.Comida;
import agg.persistence.dao.clases.Productos.Producto;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

public class ComidaClient {

    private final WebTarget webTarget;

    public ComidaClient() {
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8080/WebServiceProyecto/api/");
    }

    public List<Comida> listAll(){
        return webTarget.path("comida/getAll/")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Comida>>(){});
    }

    public static void main(String[] args) {
        ComidaClient comidaClient = new ComidaClient();
        List<Comida> food = comidaClient.listAll();

        for(Comida c : food){
            System.out.println(c);
        }
    }
}
