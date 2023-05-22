package agg.web.servlets.comandas;

import agg.client.ComandaProductoClient;
import agg.client.ProductoClient;
import agg.persistence.dao.clases.ComandaProducto;
import agg.persistence.dao.clases.Productos.Producto;
import agg.service.ComandaProductoService;
import agg.service.ProductoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name="ServletModificarComandas", urlPatterns ={"/servlet-modificarComanda"})
public class ServletModificarComandas extends HttpServlet {

    @Override
    public void init()throws ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //llamaremos a ServletModificar para que nos liste las ComandasProductos con el id de esa comanda
        int id = Integer.parseInt(req.getParameter("idComanda"));

        List<ComandaProducto> comandaProductos = new ComandaProductoService(new ComandaProductoClient()).getByIdComanda(id);

        HashMap<Producto, Integer> productos = new HashMap<>();
        ProductoService productoService = new ProductoService(new ProductoClient());

        for(ComandaProducto cp : comandaProductos){
            //No deberian de haber productos duplicados
            productos.put(productoService.getById(cp.getIdProducto()),cp.getCantidad());
        }

        req.setAttribute("lista",productos);
        req.getRequestDispatcher("/cambiarComandas/cambiarComanda.jsp").forward(req, resp);

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }

}
