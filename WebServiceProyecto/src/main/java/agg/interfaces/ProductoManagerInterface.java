package agg.interfaces;

import java.sql.Connection;

public interface ProductoManagerInterface <T>{

    /**
     * Con este metodo listamos todos los productos que haya en la
     * base de datos y los devolvemos en una lista
     *
     * @param con
     * @return List<Producto>
     */
    T getAll(Connection con);

    /**
     * Buscamos al producto con el id dado y lo devolvemos
     *
     * @param con
     * @param id
     * @return List<Producto>
     */
    T getById(Connection con, int id);
}
