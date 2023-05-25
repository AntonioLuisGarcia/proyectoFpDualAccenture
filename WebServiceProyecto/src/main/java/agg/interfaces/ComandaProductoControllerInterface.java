package agg.interfaces;

import agg.dao.ComandaProducto;

public interface ComandaProductoControllerInterface<T>{

    T getAll(int id);

    T getById(int id);

    T create(ComandaProducto comandaProducto);

    T updateCantidadByIdAndIdComanda(int idComanda, int idProducto, int cantidad);

    T borrarPorId(int idComanda, int idProducto);
}
