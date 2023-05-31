package agg.service;

import agg.client.CamareroClient;
import agg.persistence.dao.clases.Camarero;


public class CamareroService {

    private CamareroClient client;

    public CamareroService(CamareroClient client){
        this.client = client;
    }

    /**
     * Verifica que existe un camareo mediante su usuario y contraseña
     * Devuelve el camarero y en caso de que no exista devuelve null
     *
     * @param user
     * @param password
     * @return Camarero
     */
    public Camarero verificateUserByUserAndPassword(String user, String password){
        return client.verificateUserByUserAndPassword(user,password);
    }

    /**
     * Devuelve un Camarero mediante su Id
     *
     * @param id
     * @return Camarero
     */
    public Camarero getById(int id){
        return client.getById(id);
    }
}
