package agg.web.servlets.anadir;

import agg.persistence.dao.clases.ComandaProducto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="ServletAnadirComida", urlPatterns ={"/servlet-anadirComida"})
public class ServletAnadirComida extends HttpServlet {
    @Override
    public void init()throws ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Recuperamos parametros de la entrada

        int idProducto = Integer.parseInt(req.getParameter("idProducto"));
        int cantidad = Integer.parseInt(req.getParameter("cantidad"));

        // Creamos una ComandaProducto solo con los parametros que sabemos

        ComandaProducto comandaProducto = new ComandaProducto();
        comandaProducto.setIdProducto(idProducto);
        comandaProducto.setCantidad(cantidad);

        //Hacemos una lista para añadir todos los productos a ella y cuando acabemos la comanda se la enviamos

        List<ComandaProducto> comandaProductos = new ArrayList<>();
        comandaProductos.add(comandaProducto);

        // La guardamos en la sesion

        req.setAttribute("listaComanda",comandaProductos);
        req.getRequestDispatcher("/menu/menu.jsp").forward(req, resp);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }
}