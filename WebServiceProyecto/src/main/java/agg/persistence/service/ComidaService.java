package agg.persistence.service;

import agg.dao.Productos.Comida;
import agg.interfaces.ProductoInterface;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.ComidaManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ComidaService implements ProductoInterface {

    private ComidaManager manager;
    private MySQLConnector mySQLConnector;

    public ComidaService(ComidaManager manager, MySQLConnector mySQLConnector){
        this.manager = manager;
        this.mySQLConnector = mySQLConnector;
    }

    /**
     * Recupera una lista de todas las comidas.
     * @return una lista de todas las comidas.
     * @throws RuntimeException si ocurre un error al obtener las comidas.
     */

    @Override
    public List<Comida> getAll(){

        try (Connection con = mySQLConnector.getMySQLConnection()) {

            return manager.getAll(con);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retorna una comida según su ID.
     * @param id el ID de la comida que se quiere obtener.
     * @return la comida correspondiente al ID proporcionado.
     * @throws RuntimeException si se produce un error al obtener la comida.
     */

    @Override
    public Comida getById(int id){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return manager.getById(con, id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
