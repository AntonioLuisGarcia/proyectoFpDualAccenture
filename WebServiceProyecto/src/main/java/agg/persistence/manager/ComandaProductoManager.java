package agg.persistence.manager;

import agg.dao.ComandaProducto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComandaProductoManager {
    public List<ComandaProducto> getProductosByIdComanda(Connection con, int id){
        try(PreparedStatement stm = con.prepareStatement("SELECT * FROM comandaproducto WHERE IdComanda =" + id)){
            ResultSet result = stm.executeQuery();
            List<ComandaProducto> productos = new ArrayList<>();
            while(result.next()){
                productos.add(new ComandaProducto(
                        result.getInt("IdComandaProducto")
                        ,result.getInt("IdMesa")
                        ,result.getInt("IdProducto")
                        ,result.getInt("Cantidad")));
            }

            return productos;

        }catch (SQLException e){
            return null;
        }
    }

    public int createComandaProducto(Connection con, int idProducto,int idComanda, int cantidad){
        try (PreparedStatement stm = con.prepareStatement("INSERT INTO 'mydb'.'ComandaProducto'(`IdProducto`, `IdComanda`, `Cantidad`) VALUES (" + idProducto + "," + idComanda + "," + cantidad + ")")) {

            int affectedRows = stm.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKey = stm.getGeneratedKeys();///preguntar si hay que hacer try catch
                if(generatedKey.next()){
                    return generatedKey.getInt(1);
                }
                return affectedRows;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            return 0;
        }
    }

}
