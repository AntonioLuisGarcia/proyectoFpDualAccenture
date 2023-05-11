package agg.client;

import agg.persistence.dao.clases.Camarero;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

import javax.management.Notification;

public class CamareroClient {
    private final WebTarget webTarget;

    public CamareroClient() {
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8080/WebServiceProyecto/api/");
    }

    public Camarero isCorrectUser(String user, String password){

        return webTarget.path("camareross/get/"+"user"+"/password")
                .queryParam("user",user)
                .queryParam("password", password)
                .request(MediaType.APPLICATION_JSON)
                .get(Camarero.class);
    }

    public Notification getNotification(String id) {

        return webTarget.path("notifications/get/"+id)
                .request(MediaType.APPLICATION_JSON)
                .get(Notification.class);
    }

    public String ping() {

        return webTarget.path("notifications/ping")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }

    public Notification getNotification(String id, String name) {

        return webTarget.path("notifications/get/"+id+"/name")
                .queryParam("name", name)
                .request(MediaType.APPLICATION_JSON)
                .get(Notification.class);
    }

    public Notification putNotification(String id, String name) {

        return webTarget.path("notifications/get/"+id+"/"+name)
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity("",MediaType.APPLICATION_JSON), Notification.class);
    }

    public Notification postNotification(Notification notification) {

        return webTarget.path("notifications/post")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(notification,MediaType.APPLICATION_JSON), Notification.class);
    }
}
