package agg.persistence.dao.clases.Productos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comida extends Producto {

    private boolean vegano;
    private int tiempoDePreparacion;


}
