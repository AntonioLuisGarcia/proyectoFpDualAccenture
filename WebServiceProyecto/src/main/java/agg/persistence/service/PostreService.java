package agg.persistence.service;

import agg.dao.Productos.Postre;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.PostreManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostreService {

    private MySQLConnector connector;
    private PostreManager manager;

    public PostreService(MySQLConnector connector, PostreManager manager){
        this.connector = connector;
        this.manager = manager;
    }

    public ArrayList<Postre> getAllFood(){
        Connection con = null;

        try{
            con = connector.getMySQLConnection();

            return manager.getAllPostres(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
