package agg.persistence.manager;


import agg.dao.Camarero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CamareroManager {

    public Camarero getCamareroByUserAndPassword(Connection con, String user, String password){

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

}
