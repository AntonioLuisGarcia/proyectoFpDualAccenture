package agg.interfaces;

import java.sql.Connection;

public interface ComandaProductoManagerInterface <T>{

    /**
     * Devuelve todas las comandasProducto mediante el Id de su comanda
     *
     * @param con
     * @param id
     * @return List<ComandaProducto>
     */
    T getProductosById(Connection con, int id);


    /**
     * Devuelve una ComandaProducto por su Id
     *
     * @param con
     * @param id
     * @return ComandaProducto
     */
    T getById(Connection con, int id);


    /**
     * Crea un registro en la BD de mediante una ComandaProducto
     *
     * @param con
     * @param idProducto
     * @param idComanda
     * @param cantidad
     * @return ComandaProducto
     */
    T create(Connection con, int idProducto, int idComanda, int cantidad);


    /**
     * Cambia la cantidad de un producto mediante el id de la comanda y del producto
     *
     * @param con
     * @param idComanda
     * @param idProducto
     * @param cantidad
     * @return ComandaProducto
     */
    T updateCantidadByIdAndIdComanda(Connection con, int idComanda, int idProducto, int cantidad);


    /**
     * Borra la comandaProducto mediante el id del producto y de la Comanda
     *
     * @param con
     * @param idComanda
     * @param idProducto
     * @return boolean
     */
    boolean borrarPorId(Connection con, int idComanda, int idProducto);
}
