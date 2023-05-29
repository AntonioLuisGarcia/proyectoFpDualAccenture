package agg.persistence.service;

import agg.dao.Productos.Bebida;
import agg.interfaces.ProductoInterface;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.BebidaManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BebidaService implements ProductoInterface {

    private BebidaManager manager;
    private MySQLConnector mySQLConnector;

    public BebidaService( BebidaManager manager, MySQLConnector mySQLConnector){
        this.manager = manager;
        this.mySQLConnector = mySQLConnector;
    }

    /**
     * Obtiene todas las bebidas.
     * @return una lista de todas las bebidas.
     * @throws RuntimeException si ocurre un error al obtener las bebidas.
     */

    @Override
    public List<Bebida> getAll(){

        try (Connection con = mySQLConnector.getMySQLConnection()) {

            return manager.getAll(con);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retorna una bebida según su ID.
     * @param id el ID de la bebida que se quiere obtener.
     * @return la bebida correspondiente al ID proporcionado.
     * @throws RuntimeException si se produce un error al obtener la bebida.
     */

    @Override
    public Bebida getById(int id){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return manager.getById(con, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
