package agg.service;

import agg.client.ProductoClient;
import agg.persistence.dao.clases.Productos.Producto;

import java.util.List;

public class ProductoService {

    private ProductoClient productoClient;

    public ProductoService(ProductoClient productoClient){
        this.productoClient = productoClient;
    }

    public List<Producto> lisAll(){
        return productoClient.listAll();
    }

    public Producto getById(int id){
        return productoClient.getById(id);
    }
}