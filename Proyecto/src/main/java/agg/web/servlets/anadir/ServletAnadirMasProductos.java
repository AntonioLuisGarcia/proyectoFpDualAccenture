package agg.web.servlets.anadir;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Antonio Luis Garcia
 *
 * Este servlet pretende añadir mas productos a una comanda existente
 */

@WebServlet(name="ServletAnadirMasProductos", urlPatterns ={"/servlet-anadirMasProductos"})
public class ServletAnadirMasProductos extends HttpServlet {
    @Override
    public void init()throws ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Recogemos el id de la comanda para saber a que comanda añadimos el producto
        int idComanda = Integer.parseInt(req.getParameter("idComanda"));

        //Creamos una variable booleana para saber en menu.jsp que venimos desde aqui
        // y no estamos creando una comanda desde el principio
        boolean anadirMasProductos = true;

        //Guardamos en la sesion las dos variables y cuando terminemos de añadir el producto las borraremos
        req.getSession().setAttribute("idComanda", idComanda);
        req.getSession().setAttribute("anadirMasProductos", anadirMasProductos);

        //Redireccionamos al menu.jsp
        req.getRequestDispatcher("/menu/menu.jsp").forward(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }
}
