package agg.web.servlets.comandas;

import agg.client.ComandaProductoClient;
import agg.persistence.dao.clases.ComandaProducto;
import agg.service.ComandaProductoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.client.ClientBuilder;

import java.io.IOException;

/**
 * @author Antonio Luis Garcia
 *
 * Este servlet pretende aumentar la cantidad de un producto en una comanda existente
 */

@WebServlet(name="ServletAumentarCantidadProductos", urlPatterns ={"/servlet-aumentarCantidad"})
public class ServletAumentarCantidadProductos  extends HttpServlet {
    @Override
    public void init()throws ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Recogemos valores del jsp
        int idProducto = Integer.parseInt(req.getParameter("idProducto"));
        int idComanda = Integer.parseInt(req.getParameter("idComanda"));
        int cantidad = Integer.parseInt(req.getParameter("cantidad"));

        //Aumentamos la cantidad del producto mediante los parametros anteriores
        //Lo guardamos en una variable por si en un futuro lo usamos
        ComandaProducto comandaProducto = new ComandaProductoService(new ComandaProductoClient(ClientBuilder.newClient())).updateCantidadByIdAndIdComanda(idComanda, idProducto, cantidad);

        //Redireccionamos al servlet de modificar comanda para que vuelva a recoger la comanda y la muestre actualizada en el jsp
        req.getRequestDispatcher("/servlet-modificarComanda").forward(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }
}