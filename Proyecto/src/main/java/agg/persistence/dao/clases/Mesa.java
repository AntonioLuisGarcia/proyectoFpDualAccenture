package agg.persistence.dao.clases;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta es la clase para crear Mesas.
 *
 * @author Antonio Luis Garcia
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mesa {
    private int id;
    private int numero;
    private int numeroPersonas;

}
