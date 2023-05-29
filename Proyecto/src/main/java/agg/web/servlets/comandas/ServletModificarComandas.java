package agg.web.servlets.comandas;

import agg.client.ComandaClient;
import agg.client.ComandaProductoClient;
import agg.client.ProductoClient;
import agg.persistence.dao.clases.Camarero;
import agg.persistence.dao.clases.Comanda;
import agg.persistence.dao.clases.ComandaProducto;
import agg.persistence.dao.clases.Productos.Producto;
import agg.service.ComandaProductoService;
import agg.service.ComandaService;
import agg.service.ProductoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Antonio Luis Garcia
 *
 * Este servlet pretende listar las comandasProducto de una determinada Comanda por su Id
 */

@WebServlet(name="ServletModificarComandas", urlPatterns ={"/servlet-modificarComanda"})
public class ServletModificarComandas extends HttpServlet {

    @Override
    public void init()throws ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Comprobamos si nos llaman para añadir mas productos
        boolean anadirMasProductos;
        if(req.getSession().getAttribute("anadirMasProductos") != null){
            anadirMasProductos = true;
        }else{
            anadirMasProductos = false;
        }

        int id;
        //Si nos llaman desde añadirmas cogemos el id de la sesion y borramos los atributos
        if(anadirMasProductos){
            id = (int) req.getSession().getAttribute("idComanda");
            req.getSession().removeAttribute("anadirMasProductos");
            req.getSession().removeAttribute("idComanda");
        }else {
            //Sino lo cogemos como parametro
            //llamaremos a ServletModificar para que nos liste las ComandasProductos con el id de esa comanda
            id = Integer.parseInt(req.getParameter("idComanda"));
        }

        //Recogemos la lista de comandasProductos
        List<ComandaProducto> comandaProductos = new ComandaProductoService(new ComandaProductoClient()).getByIdComanda(id);

        //Creamos un HashMap para guardar los productos y sus cantidades
        HashMap<Producto, Integer> productos = new HashMap<>();
        //Creamos un servicio para usarlo en el bucle foreach
        ProductoService productoService = new ProductoService(new ProductoClient());

        for(ComandaProducto cp : comandaProductos){
            //No deberian de haber productos duplicados
            productos.put(productoService.getById(cp.getIdProducto()),cp.getCantidad());
        }
        //enviamos los atributos a cambiarComanda.jsp
        req.setAttribute("idComanda", id);
        req.setAttribute("lista",productos);
        req.getRequestDispatcher("/cambiarComandas/cambiarComanda.jsp").forward(req, resp);

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }

    @WebServlet(name="ServletCrearComanda", urlPatterns ={"/servlet-crearComanda"})
    public static class ServletCrearComanda extends HttpServlet {

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
}
