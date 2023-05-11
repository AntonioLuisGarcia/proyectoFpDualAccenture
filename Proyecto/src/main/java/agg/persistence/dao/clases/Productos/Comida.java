package agg.persistence.dao.clases.Productos;

import lombok.Data;

@Data
public class Comida extends Producto {

    private boolean vegano;
    private int tiempoDePreparacion;

    public Comida(int id, double precio, String nombre, String descripcion, String imagen, boolean vegano, int tiempoDePreparacion){
        super(id, precio, nombre, descripcion, imagen);
        this.vegano = vegano;
        this.tiempoDePreparacion = tiempoDePreparacion;
    }
}
