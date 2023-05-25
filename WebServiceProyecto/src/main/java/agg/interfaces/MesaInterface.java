package agg.interfaces;

public interface MesaInterface <T>{

    /**
     * Devuelve la Mesa con el id correspondiente
     *
     * @param id
     * @return Mesa o Response que construya la Mesa
     */
    T getById(int id);
}
