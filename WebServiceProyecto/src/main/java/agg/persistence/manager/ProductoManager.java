package agg.persistence.manager;

import agg.dao.Productos.Producto;
import agg.interfaces.ProductoManagerInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoManager implements ProductoManagerInterface {

    @Override
    public List<Producto> getAll(Connection con){

        try(PreparedStatement stm = con.prepareStatement("SELECT * FROM producto ")){
            ResultSet result = stm.executeQuery();
            List<Producto> productos = new ArrayList<>();

            while(result.next()){
                productos.add(new Producto(result.getInt("IdProducto")
                        ,result.getDouble("PrecioProducto")
                        ,result.getString("NombreProducto")
                        ,result.getString("DescripcionProducto")
                        ,result.getString("ImagenProducto")));
            }

            return productos;
        }catch (SQLException e){
            return null;
        }
    }

    @Override
    public Producto getById(Connection con, int id){
        try(PreparedStatement stm = con.prepareStatement("SELECT * FROM producto WHERE IdProducto = " + id)){
            ResultSet result = stm.executeQuery();

            if(result.next()){
                return new Producto(result.getInt("IdProducto")
                        ,result.getDouble("PrecioProducto")
                        ,result.getString("NombreProducto")
                        ,result.getString("DescripcionProducto")
                        ,result.getString("ImagenProducto"));
            }
            return null;
        }catch (SQLException e){
            return null;
        }
    }
}
