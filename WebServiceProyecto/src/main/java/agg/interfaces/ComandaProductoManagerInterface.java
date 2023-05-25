package agg.interfaces;

import java.sql.Connection;

public interface ComandaProductoManagerInterface <T>{

    T getProductosById(Connection con, int id);

    T getById(Connection con, int id);

    T create(Connection con, int idProducto, int idComanda, int cantidad);

    T updateCantidadByIdAndIdComanda(Connection con, int idComanda, int idProducto, int cantidad);

    boolean borrarPorId(Connection con, int idComanda, int idProducto);
}
