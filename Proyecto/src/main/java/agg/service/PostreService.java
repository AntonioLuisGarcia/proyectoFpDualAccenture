package agg.service;

import agg.client.PostreClient;
import agg.persistence.dao.clases.Productos.Postre;

import java.util.List;

public class PostreService {

    private PostreClient postreClient;

    public PostreService(PostreClient postreClient){
        this.postreClient = postreClient;
    }

    public List<Postre> listAll(){
        return postreClient.listAll();
    }

    public Postre getById(int id){
        return postreClient.getById(id);
    }
}
