package agg.service;

import agg.client.ComidaClient;
import agg.persistence.dao.clases.Productos.Comida;

import java.util.List;

public class ComidaService {

    private ComidaClient comidaClient;

    public ComidaService(ComidaClient comidaClient){
        this.comidaClient = comidaClient;
    }

    public Comida getById(int id){
        return comidaClient.getProductById(id);
    }

    public List<Comida> listAll(){
        return comidaClient.listAll();
    }
}
