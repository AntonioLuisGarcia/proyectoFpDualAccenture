package agg.client;

import agg.persistence.dao.clases.Productos.Bebida;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

public class BebidaClient {

    private final WebTarget webTarget;

    public BebidaClient(Client client) {
        this.webTarget = client.target("http://localhost:8082/WebServiceProyecto/api/");
    }

    /**
     * Devuelve todas las bebidas guardadas en la base de datos
     *
     * @return List<Bebida>
     */
    public List<Bebida> listAll(){
        return webTarget.path("bebidas/getAll/")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Bebida>>(){});
    }

    /**
     * Devuelve una instancia de Bebidapor su Id
     *
     * @param id
     * @return Bebida
     */
    public Bebida getById(int id){
        return webTarget.path("bebidas/getOne").
                queryParam("id",id)
                .request(MediaType.APPLICATION_JSON)
                .get(Bebida.class);
    }
}
