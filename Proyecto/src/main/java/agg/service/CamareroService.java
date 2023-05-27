package agg.service;

import agg.client.CamareroClient;
import agg.persistence.dao.clases.Camarero;


public class CamareroService {

    private CamareroClient client;

    public CamareroService(CamareroClient client){
        this.client = client;
    }

    public Camarero verificateUserByUserAndPassword(String user, String password){
        return client.verificateUserByUserAndPassword(user,password);
    }

    public Camarero getById(int id){
        return client.getById(id);
    }
}
