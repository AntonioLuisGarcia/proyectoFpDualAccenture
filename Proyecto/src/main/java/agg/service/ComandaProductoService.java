package agg.service;

import agg.client.ComandaProductoClient;
import agg.persistence.dao.clases.ComandaProducto;

public class ComandaProductoService {
    private ComandaProductoClient comandaProductoClient;

    public ComandaProductoService(ComandaProductoClient comandaProductoClient){
        this.comandaProductoClient = comandaProductoClient;
    }

    public ComandaProducto create(ComandaProducto comandaProducto){
        return comandaProductoClient.create(comandaProducto);
    }
}
