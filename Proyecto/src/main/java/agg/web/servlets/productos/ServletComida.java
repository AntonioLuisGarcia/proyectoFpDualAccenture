package agg.web.servlets.productos;

import agg.client.ComidaClient;
import agg.persistence.dao.clases.Productos.Comida;
import agg.service.ComidaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="ServletComida", urlPatterns ={"/servlet-comida"})
public class ServletComida extends HttpServlet {

    @Override
    public void init()throws ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Recuperamos parametros de la entrada
        int id = Integer.parseInt(req.getParameter("idProducto"));
        Comida comida = new ComidaService(new ComidaClient()).getById(id);
        req.setAttribute("comida",comida);
        req.getRequestDispatcher("/productos/anadirComida.jsp").forward(req, resp);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }
}
