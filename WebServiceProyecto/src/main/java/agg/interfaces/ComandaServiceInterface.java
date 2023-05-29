package agg.interfaces;

public interface ComandaServiceInterface <T>{


    /**
     * Creamos una comanda con el id de la mesa, del Camarero y el email
     * los deas atributos se generan en la base de datos
     * (La fecha se genera en la BD)
     *
     * @param idMesa
     * @param idCamarero
     * @param emailContacto
     * @return Comanda
     */
    T create (int idMesa, int idCamarero, String emailContacto);

    /**
     * Devuelve una comaanda por su Id
     *
     * @param id
     * @return Comanda
     */
    T getById(int id);

    /**
     * Devuelve todas las comandas
     *
     * @return  List<Comanda>
     */
    T getAll();

    /**
     * Devuelve las comandas con el atributo pagada a false
     *
     * @return List<Comanda>
     */
    T getNoPagadas();

    /**
     * Devuelve las comandas no pagadas y con el id del camarero
     *
     * @param id
     * @return List<Comanda>
     */
    T getNoPagadasYPorIdCamarero(int id);

    /**
     * Cambia el estado de pagada a true
     *
     * @param id
     * @return Comanda
     */
    T pagar(int id);
}
