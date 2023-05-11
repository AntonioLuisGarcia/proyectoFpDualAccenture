package agg.dao.Productos;


import lombok.Data;

@Data
public class Postre extends Producto {

    private int kcal;
    private int personasParaCompartir;

    public Postre(int id, double precio, String nombre, String descripcion, String imagen, int kcal, int personasParaCompartir){
        super(id, precio, nombre, descripcion, imagen);
        this.kcal = kcal;
        this.personasParaCompartir = personasParaCompartir;
    }
}