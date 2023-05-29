package agg.persistence.service;

import agg.dao.Productos.Postre;
import agg.interfaces.ProductoInterface;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.PostreManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PostreService implements ProductoInterface {

    private PostreManager manager;
    private MySQLConnector mySQLConnector;

    public PostreService(PostreManager manager, MySQLConnector mySQLConnector){
        this.manager = manager;
        this.mySQLConnector = mySQLConnector;
    }

    /**
     * Obtiene todos los postres.
     * @return una lista de todos los postres.
     * @throws RuntimeException si ocurre un error al obtener los postres.
     */

    @Override
    public List<Postre> getAll(){

        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return manager.getAll(con);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retorna un postre según su ID.
     * @param id el ID del postre que se quiere obtener.
     * @return el postre correspondiente al ID proporcionado.
     * @throws RuntimeException si se produce un error al obtener el postre.
     */

    @Override
    public Postre getById(int id){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return manager.getById(con, id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
