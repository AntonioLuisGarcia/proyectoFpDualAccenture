package agg.persistence.manager;

import agg.dao.ComandaProducto;
import agg.interfaces.ComandaProductoManagerInterface;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.service.ComandaProductoService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComandaProductoManager implements ComandaProductoManagerInterface {

    @Override
    public List<ComandaProducto> getProductosById(Connection con, int id){
        try(PreparedStatement stm = con.prepareStatement("SELECT * FROM comandaProducto WHERE IdComanda =" + id)){
            ResultSet result = stm.executeQuery();
            List<ComandaProducto> productos = new ArrayList<>();
            while(result.next()){
                productos.add(new ComandaProducto(
                        result.getInt("IdComandaProducto")
                        ,result.getInt("IdComanda")
                        ,result.getInt("IdProducto")
                        ,result.getInt("Cantidad")));
            }

            return productos;

        }catch (SQLException e){
            return null;
        }
    }

    @Override
    public ComandaProducto create(Connection con, int idProducto, int idComanda, int cantidad){
        try (PreparedStatement stm = con.prepareStatement("INSERT INTO `mydb`.`ComandaProducto` (`IdProducto`, `IdComanda`, `Cantidad`) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {

            stm.setInt(1, idProducto);
            stm.setInt(2, idComanda);
            stm.setInt(3, cantidad);

            int affectedRows = stm.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKey = stm.getGeneratedKeys();///preguntar si hay que hacer try catch
                if(generatedKey.next()){
                    return new ComandaProductoService(new ComandaProductoManager(), new MySQLConnector()).getById(generatedKey.getInt(1)) ;
                }
                return new ComandaProductoService(new ComandaProductoManager(), new MySQLConnector()).getById(generatedKey.getInt(1));
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
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

    @Override
    public ComandaProducto updateCantidadByIdAndIdComanda(Connection con, int idComanda, int idProducto, int cantidad) {
        try (PreparedStatement selectStm = con.prepareStatement("SELECT IdComandaProducto FROM ComandaProducto WHERE IdProducto = ? AND IdComanda = ?");
             PreparedStatement updateStm = con.prepareStatement("UPDATE ComandaProducto SET Cantidad = ? WHERE IdComandaProducto = ?")) {

            // Obtener el ID antes de la actualización
            selectStm.setInt(1, idProducto);
            selectStm.setInt(2, idComanda);
            try (ResultSet selectResult = selectStm.executeQuery()) {
                if (selectResult.next()) {
                    int id = selectResult.getInt("IdComandaProducto");

                    // Actualizar el campo
                    updateStm.setInt(1, cantidad);
                    updateStm.setInt(2, id);
                    int affectedRows = updateStm.executeUpdate();
                    if (affectedRows > 0) {
                        return new ComandaProductoService(new ComandaProductoManager(), new MySQLConnector()).getById(id);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean borrarPorId(Connection con, int idComanda, int idProducto) {
        try (PreparedStatement stm = con.prepareStatement("DELETE FROM ComandaProducto WHERE IdComanda = ? AND IdProducto = ?")) {
            stm.setInt(1, idComanda);
            stm.setInt(2, idProducto);
            int affectedRows = stm.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
