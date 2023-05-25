package agg.interfaces;

import agg.dao.Comanda;

public interface ComandaInterface <T>{

    /**
     * @param comanda
     * @return
     */
    T create (Comanda comanda);

    /**
     * @param id
     * @return
     */
    T getById(int id);

    /**
     * @return
     */
    T getAll();

    /**
     * @return
     */
    T getNoPagadas();

    /**
     * @param id
     * @return
     */
    T getNoPagadasYPorIdCamarero(int id);

    /**
     * @param id
     * @return
     */
    T pagar(int id);
}
