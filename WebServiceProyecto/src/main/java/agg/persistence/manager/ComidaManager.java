package agg.persistence.manager;

import agg.dao.Productos.Comida;
import agg.interfaces.ProductoManagerInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ComidaManager implements ProductoManagerInterface {

    @Override
    public ArrayList<Comida> getAll(Connection con){


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

    @Override
    public Comida getById(Connection con, int id){

        try(PreparedStatement stm = con.prepareStatement("SELECT * FROM producto JOIN comida ON(producto.IdProducto = comida.IdComida) WHERE IdProducto = " + id)){
            ResultSet result = stm.executeQuery();
            if(result.next()) {
                Comida comida = new Comida(result.getInt("IdComida")
                        , result.getDouble("PrecioProducto")
                        , result.getString("NombreProducto")
                        , result.getString("DescripcionProducto")
                        , result.getString("ImagenProducto")
                        , result.getBoolean("Vegano")
                        , result.getInt("TiemporPreparacion"));

                    return comida;

            }else{
                return null;
            }
        }catch (SQLException e){
            return null;
        }
    }

}
