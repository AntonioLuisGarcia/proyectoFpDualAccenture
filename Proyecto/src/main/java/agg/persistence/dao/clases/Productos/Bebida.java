package agg.persistence.dao.clases.Productos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase heredara de Producto que controla las Bebidas.
 *
 * @author Antonio Luis Garcia
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bebida extends Producto{
    private boolean alcoholica;
    private int miliLitros;
}
