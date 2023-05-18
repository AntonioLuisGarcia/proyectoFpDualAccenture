package agg.service;

import agg.client.BebidaClient;
import agg.persistence.dao.clases.Productos.Bebida;

import java.util.List;

public class BebidaService {

    private BebidaClient bebidaClient;

    public BebidaService(BebidaClient bebidaClient){
        this.bebidaClient = bebidaClient;
    }

    public List<Bebida> lisAll(){
        return bebidaClient.listAll();
    }

    public Bebida getById(int id){
        return bebidaClient.getById(id);
    }

}
