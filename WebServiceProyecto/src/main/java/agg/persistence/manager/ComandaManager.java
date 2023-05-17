package agg.persistence.manager;

import agg.dao.Comanda;
import agg.persistence.service.CamareroService;
import agg.persistence.service.ComandaProductoService;
import agg.persistence.service.MesaService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ComandaManager {

    public Comanda getComandaById(Connection con, int id) {
        try (PreparedStatement stm = con.prepareStatement("SELECT * FROM comanda WHERE IdComanda = " + id)) {
            ResultSet result = stm.executeQuery();
            if (result.next()) {
                return new Comanda(
                        result.getInt("IdComanda")
                        , new MesaService(new MesaManager()).getById(result.getInt("IdMesa"))
                        , new CamareroService(new CamareroManager()).getById(result.getInt("IdCamarero"))
                        , result.getTimestamp("FechaLlegada").toLocalDateTime()
                        , new ComandaProductoService(new ComandaProductoManager()).getProductosById(result.getInt("IdComanda")));
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public int createComanda(Connection con, int idMesa, int idCamarero){
        try (PreparedStatement stm = con.prepareStatement("INSERT INTO 'mydb'.'comanda' ('IdCamarero', 'IdMesa', 'FechaLlegada') VALUES (" + idCamarero + "," + idMesa + ", NOW())")) {

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
