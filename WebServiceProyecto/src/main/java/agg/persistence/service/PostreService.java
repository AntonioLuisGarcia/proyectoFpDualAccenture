package agg.persistence.service;

import agg.dao.Productos.Postre;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.PostreManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostreService {

    private PostreManager manager;

    public PostreService(PostreManager manager){
        this.manager = manager;
    }

    public List<Postre> getAllDesserts(){

        try (Connection con = new MySQLConnector().getMySQLConnection()) {

            return manager.getAllPostres(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
