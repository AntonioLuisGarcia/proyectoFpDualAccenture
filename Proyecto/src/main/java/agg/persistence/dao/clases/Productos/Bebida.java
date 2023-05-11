package agg.persistence.dao.clases.Productos;


import lombok.Data;

@Data
public class Bebida extends Producto{
    private boolean alcoholica;
    private int miliLitros;

    public Bebida(int id, double precio, String nombre, String descripcion, String imagen, boolean alcoholica, int miliLitros){
        super(id, precio, nombre, descripcion, imagen);
        this.alcoholica = alcoholica;
        this.miliLitros = miliLitros;
    }

    public static void main(String[] args) {
        Bebida b = new Bebida(1, 2.90,"Fanta","Bebida con sabor limon y gas","b1.png", false,330);
    }
}
