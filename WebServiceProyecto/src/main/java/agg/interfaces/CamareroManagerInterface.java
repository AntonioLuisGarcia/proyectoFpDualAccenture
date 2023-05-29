package agg.interfaces;

import agg.dao.Camarero;

import java.sql.Connection;

public interface CamareroManagerInterface {

    /**
     * Recuperamos un Usuario mediante su usuario y contraseña, ademas damos una coneccion
     * para enlazar la base de datos
     *
     * @param con
     * @param user
     * @param password
     * @return Camarero
     */
    Camarero getCamareroByUserAndPassword(Connection con,  String user, String password);

    /**
     * Recuperamos un camarero mediante su Id
     *
     * @param con
     * @param id
     * @return Camarero
     */
    Camarero getById(Connection con, int id);
}
