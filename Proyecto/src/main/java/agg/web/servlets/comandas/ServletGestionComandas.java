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

import java.io.IOException;
import java.util.List;

@WebServlet(name="ServletGestionComandas", urlPatterns ={"/servlet-gestionComandas"})
public class ServletGestionComandas extends HttpServlet {

    @Override
    public void init()throws ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Creamos un servicio para poder recoger todas las comandas
        ComandaService comandaService = new ComandaService(new ComandaClient());

        Camarero camarero = (Camarero) req.getSession().getAttribute("userLogin");

        //Guardamos todas las comandas en una Lista
        List<Comanda> comandas = comandaService.getNoPagadasYPorIdCamarero(camarero.getId());///// sino funciona quitamos este metodo y ponemos el de antes

        //Guardamos la lista para mostrarla en gestionComandas.jsp
        req.setAttribute("comandas",comandas);

        //Redirigimos a gestionComandas.jsp
        req.getRequestDispatcher("/gestionComandas/gestionComandas.jsp").forward(req, resp);

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }
}
