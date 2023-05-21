package agg.persistence.manager;

import agg.dao.Comanda;
import agg.dao.ComandaProducto;
import agg.persistence.service.ComandaProductoService;
import agg.persistence.service.ComandaService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComandaManager {

    public Comanda getComandaById(Connection con, int id) {
        try (PreparedStatement stm = con.prepareStatement("SELECT * FROM comanda WHERE IdComanda = " + id)) {
            ResultSet result = stm.executeQuery();
            if (result.next()) {
                return new Comanda(
                        result.getInt("IdComanda")
                        , result.getInt("IdMesa")
                        , result.getInt("IdCamarero")
                        , result.getTimestamp("FechaLlegada").toString()
                        , result.getString("EmailContacto")
                        , new ComandaProductoService(new ComandaProductoManager()).getProductosById(result.getInt("IdComanda"))
                        , result.getBoolean("Pagada"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public Comanda createComanda(Connection con, int idMesa, int idCamarero, String emailContacto){
        try (PreparedStatement stm = con.prepareStatement("INSERT INTO `mydb`.`comanda` (`IdCamarero`, `IdMesa`, `FechaLlegada`, `EmailContacto`, `Pagada`) VALUES (?, ?, NOW(), ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            stm.setInt(1, idCamarero);
            stm.setInt(2, idMesa);
            stm.setString(3, emailContacto);
            stm.setBoolean(4, false);

        int affectedRows = stm.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKey = stm.getGeneratedKeys();
                if(generatedKey.next()){
                   return new ComandaService(new ComandaManager()).getById(generatedKey.getInt(1));
                }
                return new ComandaService(new ComandaManager()).getById(generatedKey.getInt(1));
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Comanda> listAll(Connection con){
        try(PreparedStatement stm = con.prepareStatement("SELECT * FROM comanda")){
            ResultSet result = stm.executeQuery();
            List<Comanda> comandas = new ArrayList<>();

            while(result.next()){
                comandas.add(new Comanda(result.getInt("IdComanda")
                        , result.getInt("IdCamarero")
                        , result.getInt("IdMesa")
                        , result.getString("FechaLlegada")
                        , result.getString("EmailContacto")
                        , new ComandaProductoService(new ComandaProductoManager()).getProductosById(result.getInt("IdComanda"))
                        , result.getBoolean("Pagada")));
            }

            return comandas;
        }catch (SQLException e){
            return null;
        }
    }

    public List<Comanda> getNoPagadas(Connection con){
        try(PreparedStatement stm = con.prepareStatement("SELECT * FROM `comanda` WHERE `Pagada` = 0")){//cuidado las comillas
            ResultSet result = stm.executeQuery();
            List<Comanda> comandas = new ArrayList<>();

            while(result.next()){
                comandas.add(new Comanda(result.getInt("IdComanda")
                        , result.getInt("IdCamarero")
                        , result.getInt("IdMesa")
                        , result.getString("FechaLlegada")
                        , result.getString("EmailContacto")
                        , new ComandaProductoService(new ComandaProductoManager()).getProductosById(result.getInt("IdComanda"))
                        , result.getBoolean("Pagada")));
            }

            return comandas;
        }catch (SQLException e){
            return null;
        }
    }

    public Comanda pagarComanda(Connection con, int id){
        try (PreparedStatement stm = con.prepareStatement("UPDATE `comanda` SET `Pagada` = ? WHERE `IdComanda` = ?")) {
            stm.setBoolean(1, true);
            stm.setInt(2, id);

            int affectedRows = stm.executeUpdate();
            if (affectedRows > 0) {
                return new ComandaService(new ComandaManager()).getById(id);
            } else {
                return null;
            }
        }catch (SQLException e){
            return null;
        }
    }

}
