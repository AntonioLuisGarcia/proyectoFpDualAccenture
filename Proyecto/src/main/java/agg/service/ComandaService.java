package agg.service;

import agg.client.ComandaClient;
import agg.persistence.dao.clases.Comanda;

import java.util.List;

public class ComandaService {

    private ComandaClient comandaClient;

    public ComandaService(ComandaClient comandaClient){
       this.comandaClient = comandaClient;
    }

    public Comanda getById(int id){
        return comandaClient.getById(id);
    }

    public Comanda create(Comanda comanda){
        return comandaClient.create(comanda);
    }

    public List<Comanda> listAll(){
        return comandaClient.listAll();
    }
    public List<Comanda> getNoPagadas(){
        return comandaClient.getNoPagadas();
    }

    public List<Comanda> getNoPagadasYPorIdCamarero(int id){
        return comandaClient.getNoPagadasYPorIdCamarero(id);
    }

    public Comanda pagarComanda(int id){
        return comandaClient.pagarComanda(id);
    }
}
