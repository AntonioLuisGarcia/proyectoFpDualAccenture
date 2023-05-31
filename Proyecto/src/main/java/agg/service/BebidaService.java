package agg.service;

import agg.client.BebidaClient;
import agg.persistence.dao.clases.Productos.Bebida;

import java.util.List;

public class BebidaService {

    private BebidaClient bebidaClient;

    public BebidaService(BebidaClient bebidaClient){
        this.bebidaClient = bebidaClient;
    }

    /**
     * Devuelve una lista de todas las bebidas en BD
     *
     * @return List<Bebida>
     */
    public List<Bebida> lisAll(){
        return bebidaClient.listAll();
    }

    /**
     * Devuelve un objeto Bebida mediante su Id
     *
     * @param id
     * @return Bebida
     */
    public Bebida getById(int id){
        return bebidaClient.getById(id);
    }

}
