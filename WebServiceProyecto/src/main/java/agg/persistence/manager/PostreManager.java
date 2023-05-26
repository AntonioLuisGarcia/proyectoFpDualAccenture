package agg.persistence.manager;

import agg.dao.Productos.Postre;
import agg.interfaces.ProductoManagerInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostreManager implements ProductoManagerInterface {

    @Override
    public List<Postre> getAll(Connection con){

        try(PreparedStatement stm = con.prepareStatement("SELECT * FROM producto JOIN postre ON(producto.IdProducto = postre.IdPostre)")){
            ResultSet result = stm.executeQuery();
            List<Postre> postres = new ArrayList<>();

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

    @Override
    public Postre getById(Connection con, int id){

        try(PreparedStatement stm = con.prepareStatement("SELECT * FROM producto JOIN postre ON(producto.IdProducto = postre.IdPostre) WHERE IdProducto = " + id)){
            ResultSet result = stm.executeQuery();
            if(result.next()) {

                return new Postre(result.getInt("IdPostre")
                        , result.getDouble("PrecioProducto")
                        , result.getString("NombreProducto")
                        , result.getString("DescripcionProducto")
                        , result.getString("ImagenProducto")
                        , result.getInt("Kcal")
                        , result.getInt("PersonasParaCompartir"));

            }else{
                return null;
            }
        }catch (SQLException e){
            return null;
        }
    }

}
