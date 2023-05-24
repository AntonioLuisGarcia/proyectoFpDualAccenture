package agg.client;

import agg.persistence.dao.clases.Productos.Producto;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

public class ProductoClient {
    private final WebTarget webTarget;

    public ProductoClient() {
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8082/WebServiceProyecto/api/");
    }

    public ArrayList<Producto> listAll(){
        return webTarget.path("productos/getAll/")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<ArrayList<Producto>>(){});
    }

    public Producto getById(int id){
        return webTarget.path("productos/getById").
                queryParam("id", id)
                .request(MediaType.APPLICATION_JSON)
                .get(Producto.class);
    }
}
