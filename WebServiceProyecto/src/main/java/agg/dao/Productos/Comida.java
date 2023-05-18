package agg.dao.Productos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comida extends Producto {

    private boolean vegano;
    private int tiempoDePreparacion;
}
