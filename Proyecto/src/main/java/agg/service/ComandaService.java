package agg.service;

import agg.client.ComandaClient;
import agg.persistence.dao.clases.Comanda;
import agg.persistence.dao.clases.ComandaProducto;

import java.util.ArrayList;

public class ComandaService {

    private ComandaClient comandaClient;

    public ComandaService(ComandaClient comandaClient){
       this.comandaClient = comandaClient;
    }

    public Comanda getById(int id){
        return comandaClient.getById(id);
    }

    public Comanda create(Comanda comanda){
        return comandaClient.createComanda(comanda);
    }
}
