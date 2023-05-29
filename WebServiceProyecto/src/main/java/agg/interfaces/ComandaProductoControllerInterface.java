package agg.interfaces;

import agg.dao.ComandaProducto;

public interface ComandaProductoControllerInterface<T>{

    /**
     * Devuelve todas las comandasProducto mediante el Id de su comanda
     *
     * @param id
     * @return List<ComandaProducto>
     */
    T getAll(int id);

    /**
     * Devuelve una ComandaProducto por su Id
     *
     * @param id
     * @return ComandaProducto
     */
    T getById(int id);

    /**
     * Crea un registro en la BD de mediante una ComandaProducto
     *
     * @param comandaProducto
     * @return ComandaProducto
     */
    T create(ComandaProducto comandaProducto);

    /**
     * Cambia la cantidad de un producto mediante el id de la comanda y del producto
     *
     * @param idComanda
     * @param idProducto
     * @param cantidad
     * @return ComandaProducto
     */
    T updateCantidadByIdAndIdComanda(int idComanda, int idProducto, int cantidad);

    /**
     * Borra la comandaProducto mediante el id del producto y de la Comanda
     *
     * @param idComanda
     * @param idProducto
     * @return boolean
     */
    T borrarPorId(int idComanda, int idProducto);
}
