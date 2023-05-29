package agg.persistence.service;

import agg.dao.Comanda;
import agg.interfaces.ComandaServiceInterface;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.ComandaManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ComandaService implements ComandaServiceInterface {
    private final ComandaManager comandaManager;
    private MySQLConnector mySQLConnector;

    public ComandaService(ComandaManager comandaManager, MySQLConnector mySQLConnector){
        this.comandaManager = comandaManager;
        this.mySQLConnector = mySQLConnector;
    }

    /**
     * Obtiene una comanda por su ID.
     * @param id el ID de la comanda que se desea obtener.
     * @return la comanda correspondiente al ID proporcionado.
     * @throws RuntimeException si ocurre un error al obtener la comanda.
     */

    public Comanda getById(int id){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return comandaManager.getById(con, id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Crea una nueva comanda.
     * @param idMesa el ID de la mesa asociada a la comanda.
     * @param idCamarero el ID del camarero que atiende la comanda.
     * @param emailContacto el correo electrónico de contacto para la comanda.
     * @return la comanda creada.
     * @throws RuntimeException si ocurre un error al crear la comanda.
     */

    public Comanda create(int idMesa, int idCamarero, String emailContacto){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            Comanda comanda = comandaManager.create(con, idMesa, idCamarero, emailContacto);
            return comanda;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Obtiene una lista de todas las comandas.
     * @return una lista de todas las comandas.
     * @throws RuntimeException si ocurre un error al obtener las comandas.
     */

    public List<Comanda> getAll(){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return comandaManager.getAll(con);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Obtiene una lista de comandas no pagadas.
     * @return una lista de comandas no pagadas.
     * @throws RuntimeException si ocurre un error al obtener las comandas no pagadas.
     */

    public List<Comanda> getNoPagadas(){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return comandaManager.getNoPagadas(con);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Obtiene una lista de comandas no pagadas por ID de camarero.
     * @param id el ID del camarero.
     * @return una lista de comandas no pagadas asociadas al camarero.
     * @throws RuntimeException si ocurre un error al obtener las comandas no pagadas por ID de camarero.
     */

    public List<Comanda> getNoPagadasYPorIdCamarero(int id){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return comandaManager.getNoPagadasYPorIdCamarero(con,  id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Marca una comanda como pagada.
     * @param id el ID de la comanda que se desea marcar como pagada.
     * @return la comanda marcada como pagada.
     * @throws RuntimeException si ocurre un error al marcar la comanda como pagada.
     */

    public Comanda pagar(int id){
        try (Connection con = mySQLConnector.getMySQLConnection()) {
            return comandaManager.pagar(con, id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
