package agg.web.servlets.crearComanda;

import agg.client.ComandaClient;
import agg.client.ComandaProductoClient;
import agg.persistence.dao.clases.Camarero;
import agg.persistence.dao.clases.Comanda;
import agg.persistence.dao.clases.ComandaProducto;
import agg.persistence.dao.clases.Productos.Producto;
import agg.service.ComandaProductoService;
import agg.service.ComandaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="ServletCrearComanda", urlPatterns ={"/servlet-crearComanda"})
public class ServletCrearComanda extends HttpServlet {

    @Override
    public void init()throws ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Recuperamos parametros de pedir.jsp
        // podemos pasarlo desde el jsp de pedir.jsp en lugar de en la sesion
        HashMap<Producto, Integer> lista  = (HashMap<Producto, Integer>) req.getSession().getAttribute("lista");
        String email = req.getParameter("email");
        int mesa = Integer.parseInt(req.getParameter("mesa"));
        Camarero camarero = (Camarero) req.getSession().getAttribute("userLogin");

        //Cuando creemos la comanda nos tiene que aparecer en finalizarCompra.jsp el id de la Comanda

        Comanda comanda = new ComandaService(new ComandaClient()).create(new Comanda(1,mesa,camarero.getId(), "2023-05-31",email,new ArrayList<ComandaProducto>(),false));

        ComandaProductoService comandaProductoService = new ComandaProductoService(new ComandaProductoClient());

        for(Map.Entry<Producto, Integer> p : lista.entrySet()){
            comandaProductoService.create(new ComandaProducto(1,comanda.getId(),p.getKey().getId(),p.getValue()));
        }

        // La guardamos
        req.setAttribute("comanda",comanda);
        req.getSession().removeAttribute("listaComanda");

        req.getRequestDispatcher("/finalizarComanda/finalizarComanda.jsp").forward(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }
}
