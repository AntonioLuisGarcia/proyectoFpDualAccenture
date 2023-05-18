package agg.dao.Productos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Postre extends Producto {

    private int kcal;
    private int personasParaCompartir;
}