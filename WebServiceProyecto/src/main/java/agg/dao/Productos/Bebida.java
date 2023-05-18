package agg.dao.Productos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bebida extends Producto{
    private boolean alcoholica;
    private int miliLitros;
}
