package agg.interfaces;

public interface ComandaServiceInterface <T>{


    /**
     * @param idMesa
     * @param idCamarero
     * @param emailContacto
     * @return
     */
    T create (int idMesa, int idCamarero, String emailContacto);

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
