package agg.client;

import agg.persistence.dao.clases.Camarero;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class CamareroClient {
    private final WebTarget webTarget;

    public CamareroClient(Client client) {
        this.webTarget = client.target("http://localhost:8082/WebServiceProyecto/api/");
    }

    /**
     * Devuelve un objeto Camarero si esta en la base de datos su usuario y contraseña
     *
     * @param user
     * @param password
     * @return Camarero
     */
    public Camarero verificateUserByUserAndPassword(String user, String password){
                                                    ////////////////////
        return webTarget.path("camareros/get/login")
                .queryParam("user",user)
                .queryParam("password", password)
                .request(MediaType.APPLICATION_JSON)
                .get(Camarero.class);
    }

    /**
     * Devuelve un Camarero mediante su Id
     *
     * @param id
     * @return Camarero
     */
    public Camarero getById(int id){
        return webTarget.path("camareros/getById")
                .queryParam("id",id)
                .request(MediaType.APPLICATION_JSON)
                .get(Camarero.class);
    }
}
