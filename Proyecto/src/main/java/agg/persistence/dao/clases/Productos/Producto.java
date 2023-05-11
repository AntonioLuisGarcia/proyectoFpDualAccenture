package agg.persistence.dao.clases.Productos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Producto {
    private int id;
    private double precio;
    private String nombre;
    private String descripcion;
    private String imagen;

    public Producto() {
    }

    public static void main(String[] args) {

        Producto p = new Producto(1, 2.90, "Ensalada", "e", "b1.png");
    }

}
