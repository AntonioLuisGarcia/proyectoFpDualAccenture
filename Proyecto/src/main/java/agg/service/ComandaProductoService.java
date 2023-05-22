package agg.service;

import agg.client.ComandaProductoClient;
import agg.persistence.dao.clases.ComandaProducto;

import java.util.List;

public class ComandaProductoService {
    private ComandaProductoClient comandaProductoClient;

    public ComandaProductoService(ComandaProductoClient comandaProductoClient){
        this.comandaProductoClient = comandaProductoClient;
    }

    public ComandaProducto create(ComandaProducto comandaProducto){
        return comandaProductoClient.create(comandaProducto);
    }

    public List<ComandaProducto> getByIdComanda(int id){
        return comandaProductoClient.getByIdComanda(id);
    }

    public ComandaProducto updateCantidadByIdAndIdComanda(int idComanda, int id, int cantidad){
        return comandaProductoClient.updateCantidadByIdAndIdComanda(idComanda, id, cantidad);
    }
}
