package agg.persistence.manager;


import agg.dao.Camarero;
import agg.interfaces.CamareroManagerInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CamareroManager implements CamareroManagerInterface {

    public Camarero getCamareroByUserAndPassword(Connection con, String user, String password) {

        try(PreparedStatement stm = con.prepareStatement("SELECT * FROM camarero WHERE UsuarioCamarero = '" + user + "' AND ContraseniaCamarero = '" + password + "'")){
            ResultSet result = stm.executeQuery();
            if(result.next()){
                return new Camarero(
                         result.getInt("IdCamarero")
                        ,result.getString("NombreCamarero")
                        ,result.getString("ApellidoCamarero")
                        ,result.getString("UsuarioCamarero")
                        ,result.getString("ContraseniaCamarero"));
            }else{
                return null;
            }
        }catch (SQLException e){
            return null;
        }
    }

    public Camarero getById(Connection con, int id){
        try(PreparedStatement stm = con.prepareStatement("SELECT * FROM camarero WHERE IdCamarero = " + id)){
            ResultSet result = stm.executeQuery();
            if(result.next()){
                return new Camarero(
                        result.getInt("IdCamarero")
                        ,result.getString("NombreCamarero")
                        ,result.getString("ApellidoCamarero")
                        ,result.getString("UsuarioCamarero")
                        ,result.getString("ContraseniaCamarero"));
            }else{
                return null;
            }
        }catch (SQLException e){
            return null;
        }
    }

}
