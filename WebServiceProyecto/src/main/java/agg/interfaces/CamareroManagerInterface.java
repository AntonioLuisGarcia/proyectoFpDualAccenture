package agg.interfaces;

import agg.dao.Camarero;

import java.sql.Connection;

public interface CamareroManagerInterface {
    /**
     * @param con
     * @param user
     * @param password
     * @return
     */
    public Camarero getCamareroByUserAndPassword(Connection con,  String user, String password);

    /**
     * @param con
     * @param id
     * @return
     */
    public Camarero getById(Connection con, int id);
}
