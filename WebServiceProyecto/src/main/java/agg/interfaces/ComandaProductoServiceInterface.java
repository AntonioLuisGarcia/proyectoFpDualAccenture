package agg.interfaces;

import agg.dao.ComandaProducto;

public interface ComandaProductoServiceInterface <T>{

    T getProductosById(int id);

    T getById(int id);

    T create(int idProducto, int idComanda, int cantidad);

    T updateCantidadByIdAndIdComanda(int idComanda, int idProducto, int cantidad);

    boolean borrarPorId(int idComanda, int idProducto);
}
