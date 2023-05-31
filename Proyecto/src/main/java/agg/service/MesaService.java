package agg.service;

import agg.client.MesaClient;
import agg.persistence.dao.clases.Mesa;

public class MesaService {

    private MesaClient mesaClient;

    public MesaService(MesaClient mesaClient){
        this.mesaClient = mesaClient;
    }

    /**
     * Devuelve un objeto Mesa mediante su Id.
     *
     * @param id
     * @return Mesa
     */
    public Mesa getById(int id){
        return mesaClient.getById(id);
    }
}
