package agg.persistence.manager;

import agg.dao.Productos.Postre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class PostreManager {

    public ArrayList<Postre> getAllPostres(Connection con){


        try(PreparedStatement stm = con.prepareStatement("SELECT * FROM producto JOIN comida ON(producto.IdProducto = comida.IdComida)")){
            ResultSet result = stm.executeQuery();
            ArrayList<Postre> postres = new ArrayList<>();

            while(result.next()){
                postres.add(new Postre(result.getInt("IdPostre")
                        ,result.getDouble("PrecioProducto")
                        ,result.getString("NombreProducto")
                        ,result.getString("DescripcionProducto")
                        ,result.getString("ImagenProducto")
                        ,result.getInt("Kcal")
                        ,result.getInt("PersonasParaCompartir")));
            }

            return postres;
        }catch (SQLException e){
            return null;
        }
    }

}
