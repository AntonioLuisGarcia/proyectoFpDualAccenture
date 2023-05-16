package agg.service;

import agg.client.CamareroClient;
import agg.persistence.dao.clases.Camarero;


public class CamareroService {

    private CamareroClient client;

    public CamareroService(CamareroClient client){

        this.client = client;
    }

    public Camarero verificateUserByUserAndPassword(String user, String password){
        return client.isCorrectUser(user,password);
    }

    public String getFullName(String user, String password){
        return client.getFullName(user, password);
    }
}
