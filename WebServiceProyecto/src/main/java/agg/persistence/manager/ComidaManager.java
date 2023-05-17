package agg.persistence.manager;

import agg.dao.Productos.Comida;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ComidaManager {

    public ArrayList<Comida> getAllFood(Connection con){


        try(PreparedStatement stm = con.prepareStatement("SELECT * FROM producto JOIN comida ON(producto.IdProducto = comida.IdComida)")){
            ResultSet result = stm.executeQuery();
            ArrayList<Comida> comida = new ArrayList<>();

            while(result.next()){
                comida.add(new Comida(result.getInt("IdComida")
                        ,result.getDouble("PrecioProducto")
                        ,result.getString("NombreProducto")
                        ,result.getString("DescripcionProducto")
                        ,result.getString("ImagenProducto")
                        ,result.getBoolean("Vegano")
                        ,result.getInt("TiemporPreparacion")));
            }

            return comida;
        }catch (SQLException e){
            return null;
        }
    }

}