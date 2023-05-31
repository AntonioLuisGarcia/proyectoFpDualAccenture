package agg.service;

import agg.client.ComidaClient;
import agg.persistence.dao.clases.Productos.Comida;

import java.util.List;

public class ComidaService {

    private ComidaClient comidaClient;

    public ComidaService(ComidaClient comidaClient){
        this.comidaClient = comidaClient;
    }

    /**
     * Devuelve un objeto comida mediante su Id.
     *
     * @param id
     * @return Comida
     */
    public Comida getById(int id){
        return comidaClient.getProductById(id);
    }

    /**
     * Devuelve una lista con todos los registros de comida en la BBDD.
     *
     * @return List<Comida>
     */
    public List<Comida> listAll(){
        return comidaClient.listAll();
    }
}
