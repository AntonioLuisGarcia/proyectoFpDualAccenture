package agg.persistence.manager;

import agg.dao.Productos.Bebida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BebidaManager {

    public ArrayList<Bebida> getAllBebidas(Connection con){


        try(PreparedStatement stm = con.prepareStatement("SELECT * FROM producto JOIN bebida ON(producto.IdProducto = bebida.IdBebida)")){
            ResultSet result = stm.executeQuery();
            ArrayList<Bebida> bebidas = new ArrayList<>();

            while(result.next()){
                  bebidas.add(new Bebida(result.getInt("IdBebida")
                          ,result.getDouble("PrecioProducto")
                          ,result.getString("NombreProducto")
                          ,result.getString("DescripcionProducto")
                          ,result.getString("ImagenProducto")
                          ,result.getBoolean("Alcohol")
                          ,result.getInt("Mililitros")));
            }

            return bebidas;
        }catch (SQLException e){
            return null;
        }
    }
}