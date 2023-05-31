package agg.persistence.manager;

import agg.dao.Productos.Bebida;
import agg.interfaces.ProductoManagerInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BebidaManager implements ProductoManagerInterface {

    @Override
    public List<Bebida> getAll(Connection con){

        try(PreparedStatement stm = con.prepareStatement("SELECT * FROM producto JOIN bebida ON(producto.IdProducto = bebida.IdBebida)")){
            ResultSet result = stm.executeQuery();
            List<Bebida> bebidas = new ArrayList<>();

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

    @Override
    public Bebida getById(Connection con, int id){

        try(PreparedStatement stm = con.prepareStatement("SELECT * FROM producto JOIN bebida ON(producto.IdProducto = bebida.IdBebida) WHERE IdProducto = " + id)){
            ResultSet result = stm.executeQuery();
            if(result.next()) {
                Bebida bebida = new Bebida(result.getInt("IdBebida")
                        , result.getDouble("PrecioProducto")
                        , result.getString("NombreProducto")
                        , result.getString("DescripcionProducto")
                        , result.getString("ImagenProducto")
                        , result.getBoolean("Alcohol")
                        , result.getInt("Mililitros"));

                return bebida;

            }else{
                return null;
            }
        }catch (SQLException e){
            return null;
        }
    }
}
