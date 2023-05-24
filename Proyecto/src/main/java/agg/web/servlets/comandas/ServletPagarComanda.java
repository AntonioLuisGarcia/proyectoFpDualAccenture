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

@WebServlet(name="ServletPagarComanda", urlPatterns ={"/servlet-pagarComanda"})
public class ServletPagarComanda extends HttpServlet {
    @Override
    public void init()throws ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("idComanda"));

        Comanda comanda = new ComandaService(new ComandaClient()).pagarComanda(id);

        Sender sender = new Sender();
        boolean enviado = sender.send("antoniogarciaaccenture@gmail.com", comanda.getEmailContacto() + "", "Factura","<p>" + comanda.toString() + "</p>");

        req.setAttribute("comanda",comanda);
        req.getRequestDispatcher("/finalizarComanda/finalizarComanda.jsp").forward(req, resp);

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }
}
