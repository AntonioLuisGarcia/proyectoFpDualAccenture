package agg.service;

import agg.client.ProductoClient;
import agg.persistence.dao.clases.Productos.Producto;

import java.util.List;

public class ProductoService {

    private ProductoClient productoClient;

    public ProductoService(ProductoClient productoClient){
        this.productoClient = productoClient;
    }

    /**
     * Devuelve una lista de todos los productos de la BBDD.
     *
     * @return List<Producto>
     */
    public List<Producto> listAll(){
        return productoClient.listAll();
    }

    /**
     * Devuelve un producto mediante su ID.
     *
     * @param id
     * @return Producto
     */
    public Producto getById(int id){
        return productoClient.getById(id);
    }
}