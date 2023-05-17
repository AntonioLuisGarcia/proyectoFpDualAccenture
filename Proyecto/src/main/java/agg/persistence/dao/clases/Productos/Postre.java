package agg.persistence.dao.clases.Productos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Postre extends Producto {

    private int kcal;
    private int personasParaCompartir;
}