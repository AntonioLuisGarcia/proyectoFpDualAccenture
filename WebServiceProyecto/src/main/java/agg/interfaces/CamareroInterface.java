package agg.interfaces;

public interface CamareroInterface<T> {

    /**
     * Mediante el usuario y la contraseña verificamos si el usuario existe y lo devolvemos
     * Lo usaremos para el login y así guardar el camarero en la sesion
     *
     * @param user
     * @param password
     * @return camarero o una Response que luego creé un camarero
     */
    T getCamareroByUserAndPassword(String user, String password);

    /**
     * Mediante el Id del camarero podremos saber cual es y devolverlo
     * Para saber que camarero hizo las comandas, ya que solo tienen el id de este
     *
     * @param id
     * @return camarero o una Response que luego creé un camarero
     */
    T getById(int id);
}
