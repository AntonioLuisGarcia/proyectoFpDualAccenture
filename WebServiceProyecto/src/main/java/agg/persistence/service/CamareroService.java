package agg.persistence.service;

import agg.dao.Camarero;
import agg.interfaces.CamareroInterface;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.CamareroManager;

import java.sql.Connection;
import java.sql.SQLException;

public class CamareroService implements CamareroInterface {

    private CamareroManager manager;
    private MySQLConnector mySQLConnector;

    public CamareroService(CamareroManager manager, MySQLConnector mySQLConnector){
        this.manager = manager;
        this.mySQLConnector = mySQLConnector;
    }

    /**
     * Obtiene un camarero por su nombre de usuario y contraseña.
     * @param user el nombre de usuario del camarero.
     * @param password la contraseña del camarero.
     * @return el camarero correspondiente al nombre de usuario y contraseña proporcionados.
     * @throws RuntimeException si ocurre un error al obtener el camarero.
     */

    @Override
    public Camarero getCamareroByUserAndPassword(String user, String password){

        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return manager.getCamareroByUserAndPassword(con, user, password);
        } catch (SQLException | ClassNotFoundException e) {

            throw new RuntimeException(e);
        }
    }

    /**
     * Recupera un camarero por su ID.
     * @param id el ID del camarero que se desea obtener.
     * @return el camarero encontrado según el ID especificado.
     * @throws RuntimeException si ocurre un error al obtener el camarero.
     */

    @Override
    public Camarero getById(int id){
        try (Connection con = mySQLConnector.getMySQLConnection()) {

            return manager.getById(con, id);
        } catch (SQLException | ClassNotFoundException e) {

            throw new RuntimeException(e);
        }
    }
}