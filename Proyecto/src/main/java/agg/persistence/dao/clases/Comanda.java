package agg.persistence.dao.clases;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comanda {
    private int id;
    private Mesa mesa;
    private Camarero camarero;
    private Date llegada;

    private ArrayList<ComandaProducto> productos;

    public double totalCuentaMesa(){
        double total = 0;

        for (ComandaProducto p : productos) {
            total += p.getCantidad() * p.getProducto().getPrecio();
        }

        return total;
    }

}
