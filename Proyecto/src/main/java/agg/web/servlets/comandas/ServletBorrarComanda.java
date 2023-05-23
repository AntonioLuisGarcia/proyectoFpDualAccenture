package agg.web.servlets.comandas;

import agg.client.ComandaProductoClient;
import agg.service.ComandaProductoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="ServletBorrarComanda", urlPatterns ={"/servlet-borrarComanda"})
public class ServletBorrarComanda  extends HttpServlet {
    @Override
    public void init()throws ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Recogemos valores del jsp
        int idProducto = Integer.parseInt(req.getParameter("idProducto"));
        int idComanda = Integer.parseInt(req.getParameter("idComanda"));

        boolean borrado = new ComandaProductoService(new ComandaProductoClient()).borrarPorId(idComanda, idProducto);

        req.getSession().setAttribute("anadirMasProductos", true);
        req.getSession().setAttribute("idComanda", idComanda);

        if(borrado){
            req.getRequestDispatcher("/servlet-modificarComanda").forward(req, resp);
        }else{
            req.getRequestDispatcher("/servlet-modificarComanda").forward(req, resp);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }
}
