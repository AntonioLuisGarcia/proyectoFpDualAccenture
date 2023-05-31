package agg.persistence.dao.clases;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Esta clase controla los pedidos que hace un camarero en una mesa.
 * En ella se guardan los Ids del camarero y de la mesa para identificarala.
 * Ademas, tiene la fecha de llegada, email para contacto, la lista de productos con sus cantidades
 * y se determina si esta pagada o no.
 *
 * @author Antonio Luis Garcia
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comanda {
    private int id;
    private int idMesa;
    private int idCamarero;
    private String llegada;
    private String emailContacto;
    private List<ComandaProducto> productos;
    private boolean pagada;
}
