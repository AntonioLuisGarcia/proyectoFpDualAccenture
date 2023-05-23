package agg.web.servlets.comandas;

import agg.client.ComandaProductoClient;
import agg.persistence.dao.clases.ComandaProducto;
import agg.service.ComandaProductoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="ServletCambiarCantidadProductoEnComanda", urlPatterns ={"/servlet-cambiarCantidadProductoEnComanda"})
public class ServletCambiarCantidadProductoEnComanda extends HttpServlet {
    @Override
    public void init()throws ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Recogemos valores del jsp
        int idProducto = Integer.parseInt(req.getParameter("idProducto"));
        int cantidad = Integer.parseInt(req.getParameter("cantidad"));
        int idComanda = Integer.parseInt(req.getParameter("idComanda"));

        ComandaProducto comandaProducto = new ComandaProductoService(new ComandaProductoClient()).updateCantidadByIdAndIdComanda(idComanda, idProducto, cantidad);
        req.setAttribute("idComanda", idComanda);
        req.getRequestDispatcher("/servlet-modificarComanda").forward(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }
}
