package agg.persistence.dao.clases.Productos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bebida extends Producto{
    private boolean alcoholica;
    private int miliLitros;
}
