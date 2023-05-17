package agg.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class Comanda {
    private int id;
    private Mesa mesa;
    private Camarero camarero;
    private LocalDateTime llegada;
    private List<ComandaProducto> productos;
}
