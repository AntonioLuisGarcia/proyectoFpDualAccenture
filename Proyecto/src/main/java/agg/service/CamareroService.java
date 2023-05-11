package agg.service;

import agg.client.CamareroClient;


public class CamareroService {

    private CamareroClient client;

    public CamareroService(CamareroClient client){

        this.client = client;
    }

    public boolean verificateUserByUserAndPassword(String user, String password){
        if(client.isCorrectUser(user,password) != null){
            return true;
        }
        return false;
    }

    public String getFullName(String user, String password){
        return client.getFullName(user, password);
    }
}
