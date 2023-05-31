package agg.persistence.dao.clases.Productos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que hereda de Producto y controla las Comidas.
 *
 * @author Antonio Luis Garcia
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comida extends Producto {

    private boolean vegano;
    private int tiempoDePreparacion;


}
