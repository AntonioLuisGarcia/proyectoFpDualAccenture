package agg.persistence.dao.clases;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta clase es para crear a los camareros.
 *
 * @author Antonio Luis Garcia
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Camarero {
    private int id;
    private String nombre;
    private String apellidos;
    private String usuario;
    private String contrasenia;
}
