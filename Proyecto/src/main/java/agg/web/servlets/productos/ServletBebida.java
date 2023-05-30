package agg.web.servlets.productos;

import agg.client.BebidaClient;
import agg.persistence.dao.clases.Productos.Bebida;
import agg.service.BebidaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.client.ClientBuilder;

import java.io.IOException;

@WebServlet(name="ServletAnadirBebida", urlPatterns ={"/servlet-bebida"})
public class ServletBebida extends HttpServlet {

    @Override
    public void init()throws ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Recuperamos parametros de la entrada
        int id = Integer.parseInt(req.getParameter("idProducto"));
        Bebida bebida = new BebidaService(new BebidaClient(ClientBuilder.newClient())).getById(id);
        req.setAttribute("bebida",bebida);
        req.getRequestDispatcher("/productos/anadirBebida.jsp").forward(req, resp);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }

}
