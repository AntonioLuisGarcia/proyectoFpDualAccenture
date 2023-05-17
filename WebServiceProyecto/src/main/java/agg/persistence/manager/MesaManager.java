package agg.persistence.manager;

import agg.dao.Mesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MesaManager {

    public Mesa getMesaByNumber(Connection con, int number){

        try(PreparedStatement stm = con.prepareStatement("SELECT * FROM mesas WHERE NumeroMesa = " + number)){
            ResultSet result = stm.executeQuery();
            if(result.next()){
                return new Mesa(
                        result.getInt("IdMesa")
                        ,result.getInt("NumeroMesa")
                        ,result.getInt("PersonasMesa")
                        );
            }else{
                return null;
            }
        }catch (SQLException e){
            return null;
        }
    }

    public ArrayList<Mesa> getAll(Connection con){
        try(PreparedStatement stm = con.prepareStatement("SELECT * FROM mesas")){
            ResultSet result = stm.executeQuery();
            ArrayList<Mesa> mesas = new ArrayList<>();
            while(result.next()){
                mesas.add(new Mesa(
                        result.getInt("IdMesa"),
                        result.getInt("NumeroMesa"),
                        result.getInt("NumeroPersonas")));
            }
            return mesas;
        }catch (SQLException e){
            return null;
        }
    }
}
