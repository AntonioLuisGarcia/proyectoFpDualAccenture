package agg.service;

import agg.client.PostreClient;
import agg.persistence.dao.clases.Productos.Postre;

import java.util.List;

public class PostreService {

    private PostreClient postreClient;

    public PostreService(PostreClient postreClient){
        this.postreClient = postreClient;
    }

    /**
     * Devuelve una lista con todos los postres de la BBDD.
     *
     * @return List<Postre>
     */
    public List<Postre> listAll(){
        return postreClient.listAll();
    }

    /**
     * Devuelve un objeto postre mediante su Id.
     *
     * @param id
     * @return Postre
     */
    public Postre getById(int id){
        return postreClient.getById(id);
    }
}
