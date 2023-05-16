package agg.client;

import agg.persistence.dao.clases.Camarero;
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
        this.webTarget = client.target("http://localhost:8080/WebServiceProyecto/api/");
    }

    public ArrayList<Producto> listAll(){
        return webTarget.path("camareros/getAll/")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<ArrayList<Producto>>() {});
    }

    public static void main(String[] args) {
        ProductoClient productoClient = new ProductoClient();
        ArrayList<Producto> productos = productoClient.listAll();

        for(Producto p : productos){

        }
    }
}
