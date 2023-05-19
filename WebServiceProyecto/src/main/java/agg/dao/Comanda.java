package agg.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comanda {
    private int id;
    private int idMesa;
    private int idCamarero;
    private LocalDateTime llegada;
    private String emailContacto;
    private List<ComandaProducto> productos;
}
