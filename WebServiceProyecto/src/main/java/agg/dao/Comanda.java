package agg.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
@Data
@AllArgsConstructor
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
