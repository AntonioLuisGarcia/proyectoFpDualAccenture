package agg.interfaces;

import java.sql.Connection;

public interface MesaManagerInterface <T>{

    /**
     * Devuelve una Mesa por su Id
     *
     * @param con
     * @param id
     * @return Mesa
     */
    T getById(Connection con, int id);

    /**
     * Devuelve todas las mesas
     *
     * @param con
     * @return List<Mesa>
     */
    T getAll(Connection con);
}
