package agg.persistence.manager;

import agg.dao.Camarero;
import agg.dao.ComandaProducto;
import agg.dao.Mesa;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Setter
@Getter
public class ComandaManager {

    private Mesa mesa;
    private Camarero camarero;
    private HashMap<ComandaProducto,Integer> productos;

    public ComandaManager(Mesa mesa, Camarero camarero){
        this.mesa = mesa;
        this.camarero = camarero;
    }


}
