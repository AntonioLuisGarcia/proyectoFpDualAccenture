package agg.interfaces;

import agg.dao.Comanda;

import java.sql.Connection;

public interface ComandaManagerInterface <T>{


    /**
     * @param con
     * @param idMesa
     * @param idCamarero
     * @param emailContacto
     * @return
     */
    T create (Connection con, int idMesa, int idCamarero, String emailContacto);


    /**
     * @param con
     * @param id
     * @return
     */
    T getById(Connection con, int id);

    /**
     * @param con
     * @return
     */
    T getAll(Connection con);


    /**
     * @param con
     * @return
     */
    T getNoPagadas(Connection con);


    /**
     * @param con
     * @param id
     * @return
     */
    T getNoPagadasYPorIdCamarero(Connection con, int id);


    /**
     * @param con
     * @param id
     * @return
     */
    T pagar(Connection con, int id);
}
