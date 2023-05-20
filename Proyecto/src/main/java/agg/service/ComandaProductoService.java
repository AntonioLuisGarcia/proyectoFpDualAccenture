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

    public static void main(String[] args) {
       ComandaProducto comandaProducto = new ComandaProductoService(new ComandaProductoClient()).create(new ComandaProducto(1,11,1,1));
        System.out.println(comandaProducto);
    }
}
