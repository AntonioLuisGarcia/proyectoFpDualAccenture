package agg.persistence.dao.clases;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta clase sirve para contar la cantidad de un producto que haya en una comanda.
 * En ella guardamos los Ids del producto y de la comanda para saber a cual corresponde.
 *
 * @author Antonio Luis Garcia
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComandaProducto {
    private int id;
    private int idComanda;
    private int idProducto;
    private int cantidad;
}
