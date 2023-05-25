package agg.interfaces;

import java.util.List;

public interface ProductoInterface<T> {

    /**
     * Con este metodo listamos todos los productos que haya en la base de datos y los devolvemos en una lista
     *
     * @return List<Producto>
     */
    T getAll();

    /**
     * Buscamos al producto con el id dado y lo devolvemos
     *
     * @param id
     * @return Producto
     */
    T getById(int id);
}
