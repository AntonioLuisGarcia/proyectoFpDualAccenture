package agg.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
