package agg.persistence.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CamareroManager {

    public boolean verificateUserByUserAndPassword(Connection con, String user, String password){

        try(PreparedStatement stm = con.prepareStatement("SELECT * FROM camarero WHERE UsuarioCamarero = '" + user + "' AND ContraseniaCamarero = '" + password + "'")){
            ResultSet result = stm.executeQuery();
            if(result.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            return false;
        }
    }
}
