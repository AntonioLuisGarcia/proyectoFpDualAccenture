package agg.interfaces;

import agg.dao.Comanda;

import java.sql.Connection;

public interface ComandaManagerInterface <T>{


    /**
     * Creamos una comanda con el id de la mesa, del Camarero y el email
     * los deas atributos se generan en la base de datos
     * (La fecha se genera en la BD)
     *
     * @param con
     * @param idMesa
     * @param idCamarero
     * @param emailContacto
     * @return Comanda
     */
    T create (Connection con, int idMesa, int idCamarero, String emailContacto);


    /**
     * Devuelve una comaanda por su Id
     *
     * @param con
     * @param id
     * @return Comanda
     */
    T getById(Connection con, int id);

    /**
     * Devuelve todas las comandas
     *
     * @param con
     * @return List<Comanda>
     */
    T getAll(Connection con);


    /**
     * Devuelve las comandas con el atributo pagada a false
     *
     * @param con
     * @return List<Comanda>
     */
    T getNoPagadas(Connection con);


    /**
     * Devuelve las comandas no pagadas y con el id del camarero
     *
     * @param con
     * @param id
     * @return List<Comanda>
     */
    T getNoPagadasYPorIdCamarero(Connection con, int id);


    /**
     * Cambia el estado de pagada a true
     *
     * @param con
     * @param id
     * @return Comanda
     */
    T pagar(Connection con, int id);
}
