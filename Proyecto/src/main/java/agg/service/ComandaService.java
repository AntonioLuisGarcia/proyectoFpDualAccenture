package agg.service;

import agg.client.ComandaClient;
import agg.persistence.dao.clases.Comanda;

import java.util.List;

public class ComandaService {

    private ComandaClient comandaClient;

    public ComandaService(ComandaClient comandaClient){
       this.comandaClient = comandaClient;
    }

    /**
     * Devuelve un objeto Comanda mediante su Id.
     *
     * @param id
     * @return Comanda
     */
    public Comanda getById(int id){
        return comandaClient.getById(id);
    }

    /**
     * Crea un registro de comanda en la BD mediante una estancia de comanda.
     *
     * @param comanda
     * @return Comanda
     */
    public Comanda create(Comanda comanda){
        return comandaClient.create(comanda);
    }

    /**
     * Devuelve una lista con todas las comandas creadas.
     *
     * @return List<Comanda>
     */
    public List<Comanda> listAll(){
        return comandaClient.listAll();
    }

    /**
     * Devuelve una lista con todas las comandas que tengan el atributo pagada a false.
     *
     * @return List<Comanda>
     */
    public List<Comanda> getNoPagadas(){
        return comandaClient.getNoPagadas();
    }

    /**
     * Devuelve una lista con todas las comandas que tengan el atributo pagada a false y que sean por un camarero en específico.
     *
     * @param id
     * @return List<Comanda>
     */
    public List<Comanda> getNoPagadasYPorIdCamarero(int id){
        return comandaClient.getNoPagadasYPorIdCamarero(id);
    }

    /**
     * Cambia el estado de pagada a true de una comanda por su Id.
     *
     * @param id
     * @return Comanda
     */
    public Comanda pagarComanda(int id){
        return comandaClient.pagarComanda(id);
    }
}
