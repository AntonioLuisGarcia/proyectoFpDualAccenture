package agg.web.servlets.productos;

import agg.client.PostreClient;
import agg.persistence.dao.clases.Productos.Postre;
import agg.service.PostreService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="ServletAnadirPostre", urlPatterns ={"/servlet-postre"})
public class ServletPostre extends HttpServlet {

    @Override
    public void init()throws ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Recuperamos parametros de la entrada
        int id = Integer.parseInt(req.getParameter("idProducto"));
        Postre postre = new PostreService(new PostreClient()).getById(id);
        req.setAttribute("postre",postre);
        req.getRequestDispatcher("/productos/anadirPostre.jsp").forward(req, resp);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }
}
