package agg.dao.Productos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bebida extends Producto{
    private boolean alcoholica;
    private int miliLitros;

    public Bebida(int id, double precio, String nombre, String descripcion, String imagen, boolean alcoholica, int miliLitros){
        super(id, precio, nombre, descripcion, imagen);
        this.alcoholica = alcoholica;
        this.miliLitros = miliLitros;
    }
}
