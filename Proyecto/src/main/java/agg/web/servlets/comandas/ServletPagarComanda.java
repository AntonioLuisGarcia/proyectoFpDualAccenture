package agg.web.servlets.comandas;

import agg.client.ComandaClient;
import agg.email.sender.Sender;
import agg.persistence.dao.clases.Comanda;
import agg.service.ComandaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Antonio Luis Garcia
 *
 * Este servlet pretende cambiar ek estado de una comanda a pagada para que no salga en la gestion del camarero
 * A no ser que seamos el admin.
 */

@WebServlet(name="ServletPagarComanda", urlPatterns ={"/servlet-pagarComanda"})
public class ServletPagarComanda extends HttpServlet {
    @Override
    public void init()throws ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //Cogemos el id de la comanda
        int id = Integer.parseInt(req.getParameter("idComanda"));

        //Cambiamos el estado de la comanda a pagada
        Comanda comanda = new ComandaService(new ComandaClient()).pagarComanda(id);

        //Enviamos un email con los datos de la comanda
        Sender sender = new Sender();
        //Verificamos que se ha enviado(la variable es principalmente para el debug que sea mas sencillo)
        boolean enviado = sender.send("antoniogarciaaccenture@gmail.com", comanda.getEmailContacto() + "", "Factura","<p>" + comanda.toString() + "</p>");

        //Guardamos la comanda para mosntrar su id cuando se complete la comanda en finalizarComanda.jsp
        req.setAttribute("comanda",comanda);
        req.getRequestDispatcher("/finalizarComanda/finalizarComanda.jsp").forward(req, resp);

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }
}
