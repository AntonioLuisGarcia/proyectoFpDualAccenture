package agg.web.servlets.comandas;

import agg.client.ComandaClient;
import agg.persistence.dao.clases.Camarero;
import agg.persistence.dao.clases.Comanda;
import agg.service.ComandaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.client.ClientBuilder;

import java.io.IOException;
import java.util.List;

/**
 * @author Antonio Luis Garcia
 *
 * Este servlet pretende recoger las comandas del camarero que este en la sesion
 * y que no esten pagadas.
 * Si es el admin salen todas las comandas.
 */

@WebServlet(name="ServletGestionComandas", urlPatterns ={"/servlet-gestionComandas"})
public class ServletGestionComandas extends HttpServlet {

    @Override
    public void init()throws ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Creamos un servicio para poder recoger todas las comandas
        ComandaService comandaService = new ComandaService(new ComandaClient(ClientBuilder.newClient()));

        //Recuperamos al camarero de la sesion
        Camarero camarero = (Camarero) req.getSession().getAttribute("userLogin");

        //Verificamos que seamos o no el admin para mostrar todas las comandas
        if(camarero.getUsuario().equals("Admin") && camarero.getContrasenia().equals("1234")){
            //Guardamos todas las comandas en una Lista
            List<Comanda> comandas = comandaService.listAll();

            //Guardamos la lista para mostrarla en gestionComandas.jsp
            req.setAttribute("comandas",comandas);

            //Redirigimos a gestionComandas.jsp
            req.getRequestDispatcher("/gestionComandas/gestionComandas.jsp").forward(req, resp);
        }else {

            //Guardamos todas las comandas en una Lista
            List<Comanda> comandas = comandaService.getNoPagadasYPorIdCamarero(camarero.getId());

            //Guardamos la lista para mostrarla en gestionComandas.jsp
            req.setAttribute("comandas", comandas);

            //Redirigimos a gestionComandas.jsp
            req.getRequestDispatcher("/gestionComandas/gestionComandas.jsp").forward(req, resp);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }
}
