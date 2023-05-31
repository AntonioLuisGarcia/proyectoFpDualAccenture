package agg.persistence.dao.clases.Productos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta es la clase padre de todos los productos.
 * De aqui heredaran los demas y tendran sus caracteristicas.
 *
 * @author Antonio Luis Garcia
 */

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
