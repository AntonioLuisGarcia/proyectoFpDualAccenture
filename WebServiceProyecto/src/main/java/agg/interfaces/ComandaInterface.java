package agg.interfaces;

import agg.dao.Comanda;

public interface ComandaInterface <T>{

    /**
     * Creamos una comanda en la base de datos mediante un objeto comanda
     *
     * @param comanda
     * @return Comanda
     */
    T create (Comanda comanda);

    /**
     * Recuperamos una Comanda mediante su Id
     *
     * @param id
     * @return Comanda
     */
    T getById(int id);

    /**
     * Devolvemos todas las comandas
     *
     * @return List<Comanda>
     */
    T getAll();

    /**
     * Devuelve una lista de todas las comandas con el atributo pagada a false
     *
     * @return List<Comanda>
     */
    T getNoPagadas();

    /**
     * Devuelve una Lista de Comandas que no esten pagadas y que tengan el id de un camarero
     *
     * @param id
     * @return List<Comanda>
     */
    T getNoPagadasYPorIdCamarero(int id);

    /**
     * Cambiamos el atributo pagada a true
     *
     * @param id
     * @return Comanda
     */
    T pagar(int id);
}
