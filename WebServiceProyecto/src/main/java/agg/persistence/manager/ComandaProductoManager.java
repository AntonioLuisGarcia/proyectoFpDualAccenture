package agg.persistence.manager;

import agg.dao.ComandaProducto;
import agg.persistence.service.ComandaProductoService;
import agg.persistence.service.ComandaService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComandaProductoManager {
    public List<ComandaProducto> getProductosByIdComanda(Connection con, int id){
        try(PreparedStatement stm = con.prepareStatement("SELECT * FROM comandaProducto WHERE IdComanda =" + id)){
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

    public ComandaProducto createComandaProducto(Connection con, int idProducto, int idComanda, int cantidad){
        try (PreparedStatement stm = con.prepareStatement("INSERT INTO `mydb`.`ComandaProducto` (`IdProducto`, `IdComanda`, `Cantidad`) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {

            stm.setInt(1, idProducto);
            stm.setInt(2, idComanda);
            stm.setInt(3, cantidad);

            int affectedRows = stm.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKey = stm.getGeneratedKeys();///preguntar si hay que hacer try catch
                if(generatedKey.next()){
                    return new ComandaProductoService(new ComandaProductoManager()).getById(generatedKey.getInt(1)) ;
                }
                return new ComandaProductoService(new ComandaProductoManager()).getById(generatedKey.getInt(1));
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public ComandaProducto getById(Connection con, int id) {
        try (PreparedStatement stm = con.prepareStatement("SELECT * FROM comandaProducto WHERE IdComandaProducto = " + id)) {
            ResultSet result = stm.executeQuery();
            if (result.next()) {
                return new ComandaProducto(
                        result.getInt("IdComandaProducto")
                        , result.getInt("IdComanda")
                        , result.getInt("IdProducto")
                        , result.getInt("Cantidad"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public ComandaProducto updateCantidadByIdAndIdComanda(Connection con, int idComanda, int id, int cantidad){
        try (PreparedStatement stm = con.prepareStatement( "UPDATE ComandaProducto SET Cantidad = ? WHERE IdComandaProducto = ? AND IdComanda = ?")) {
            stm.setInt(1, cantidad);
            stm.setInt(2, id);
            stm.setInt(3, idComanda);

            int affectedRows = stm.executeUpdate();
            if (affectedRows > 0) {
                return new ComandaProductoService(new ComandaProductoManager()).getById(id);
            } else {
                return null;
            }

        }catch (SQLException e) {
            return null;
        }
    }

}
