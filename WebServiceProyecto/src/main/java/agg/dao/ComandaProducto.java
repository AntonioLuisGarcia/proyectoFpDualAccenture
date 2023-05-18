package agg.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComandaProducto {
    private int id;
    private int idComanda;
    private int IdProducto;
    private int cantidad;
}
