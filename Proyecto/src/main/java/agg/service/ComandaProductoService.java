package agg.service;

import agg.client.ComandaProductoClient;
import agg.persistence.dao.clases.ComandaProducto;

import java.util.List;

public class ComandaProductoService {
    private ComandaProductoClient comandaProductoClient;

    public ComandaProductoService(ComandaProductoClient comandaProductoClient){
        this.comandaProductoClient = comandaProductoClient;
    }

    /**
     * Crea una ComandaProducto en la BD mediante un objeto de ComandaProducto
     *
     * @param comandaProducto
     * @return ComandaProducto
     */
    public ComandaProducto create(ComandaProducto comandaProducto){
        return comandaProductoClient.create(comandaProducto);
    }

    /**
     * Devuelve una lista de comandasProducto que pertenezcan a una Comanda
     *
     * @param id
     * @return List<ComandaProducto>
     */
    public List<ComandaProducto> getByIdComanda(int id){
        return comandaProductoClient.getByIdComanda(id);
    }

    /**
     * Cambia la cantidad del producto mediante el id del producto y de la comanda
     *
     * @param idComanda
     * @param idProducto
     * @param cantidad
     * @return ComandaProducto
     */
    public ComandaProducto updateCantidadByIdAndIdComanda(int idComanda, int idProducto, int cantidad){
        return comandaProductoClient.updateCantidadByIdAndIdComanda(idComanda, idProducto, cantidad);
    }

    /**
     * Borra la ComandaProducto mediante el id del producto y de la comanda
     *
     * @param idComanda
     * @param idProducto
     * @return boolean
     */
    public boolean borrarPorId(int idComanda, int idProducto){
        return comandaProductoClient.borrarPorId(idComanda, idProducto);
    }
}
