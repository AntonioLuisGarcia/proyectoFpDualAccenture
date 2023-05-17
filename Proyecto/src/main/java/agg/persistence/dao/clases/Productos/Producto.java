package agg.persistence.dao.clases.Productos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private int id;
    private double precio;
    private String nombre;
    private String descripcion;
    private String imagen;
}
