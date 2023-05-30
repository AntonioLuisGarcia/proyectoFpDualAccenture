package agg.web.servlets.crearComanda;

import agg.client.ComandaClient;
import agg.client.ComandaProductoClient;
import agg.client.MesaClient;
import agg.persistence.dao.clases.Camarero;
import agg.persistence.dao.clases.Comanda;
import agg.persistence.dao.clases.ComandaProducto;
import agg.persistence.dao.clases.Productos.Producto;
import agg.service.ComandaProductoService;
import agg.service.ComandaService;
import agg.service.MesaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.client.ClientBuilder;

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
        int mesa = Integer.parseInt(req.getParameter("mesa"));
        if(new MesaService(new MesaClient(ClientBuilder.newClient())).getById(mesa) == null){
            String error = "Mesa incorrecta";
            req.setAttribute("error", error);
            req.getRequestDispatcher("/servlet-pedir").forward(req, resp);
        }

        HashMap<Producto, Integer> lista  = (HashMap<Producto, Integer>) req.getSession().getAttribute("lista");
        String email = req.getParameter("email");

        Camarero camarero = (Camarero) req.getSession().getAttribute("userLogin");

        //Cuando creemos la comanda nos tiene que aparecer en finalizarCompra.jsp el id de la Comanda

        Comanda comanda = new ComandaService(new ComandaClient(ClientBuilder.newClient())).create(new Comanda(1,mesa,camarero.getId(), "2023-05-31",email,new ArrayList<ComandaProducto>(),false));

        ComandaProductoService comandaProductoService = new ComandaProductoService(new ComandaProductoClient(ClientBuilder.newClient()));

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
