package agg.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ComandaProducto {
    private int id;
    private int idComanda;
    private int IdProducto;
    private int cantidad;
}
