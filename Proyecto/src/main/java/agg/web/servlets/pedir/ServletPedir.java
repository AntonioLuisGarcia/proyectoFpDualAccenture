package agg.web.servlets.pedir;

import agg.client.ProductoClient;
import agg.persistence.dao.clases.ComandaProducto;
import agg.persistence.dao.clases.Productos.Producto;
import agg.service.ProductoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author Antonio Luis Garcia
 *
 * Este servlet pretende añadir a un Map los productos y sus cantidades de la lista pedida en el menu
 */

@WebServlet(name="ServletPedir", urlPatterns ={"/servlet-pedir"})
public class ServletPedir extends HttpServlet {

    @Override
    public void init()throws ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Comprobamos que la lista no este vacia sino que nos vuelva a enviar al menu
        if(req.getSession().getAttribute("listaComanda") != null){

            //Recogemos la lista
            List<ComandaProducto> comandaProductos = (List<ComandaProducto>) req.getSession().getAttribute("listaComanda");

            //La recorremos y guardamos un HashMap de Producto y las veces que se repite
            HashMap<Producto,Integer> lista = new HashMap<>();

            for(ComandaProducto cp : comandaProductos){

                //Recogemos el producto por su Id
                Producto p = new ProductoService(new ProductoClient()).getById(cp.getIdProducto());

                //Comprobamos que ya exista el valor para que no se sobreescriba
                if(lista.containsKey(p)){
                    //Si existe sumamos sus cantidades
                    lista.put(p,(lista.get(p) + cp.getCantidad()));
                }else{
                    //Lo añadimos si no existe en el Map
                    lista.put(p,cp.getCantidad());
                }
            }

            //Guardamos la lista en la sesion y cuando la guardemos en la BD se borrara de la sesion
            req.getSession().setAttribute("lista",lista);
            //Redireccion a pedir.jsp
            req.getRequestDispatcher("/pedirComanda/pedir.jsp").forward(req, resp);

        }else{
            //Nos envia devuelta al menu en caso de que no haya nada en la lista
            resp.sendRedirect("/Proyecto/menu/menu.jsp");
        }

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }
}
