package agg.interfaces;

import java.sql.Connection;

public interface ProductoManagerInterface <T>{

    /**
     * @param con
     * @return
     */
    T getAll(Connection con);

    /**
     * @param con
     * @param id
     * @return
     */
    T getById(Connection con, int id);
}
