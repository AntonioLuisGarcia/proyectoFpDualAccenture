package agg.persistence.dao.clases;

import agg.persistence.dao.clases.Productos.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComandaProducto {
    private int id;
    private Comanda comanda;
    private Producto producto;
    private int cantidad;
}
