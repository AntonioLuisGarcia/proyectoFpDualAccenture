package agg.dao.Productos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {
    private int id;
    private double precio;
    private String nombre;
    private String descripcion;
    private String imagen;
}
