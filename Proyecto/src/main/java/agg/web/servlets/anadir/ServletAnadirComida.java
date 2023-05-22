package agg.web.servlets.anadir;

import agg.persistence.dao.clases.ComandaProducto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="ServletAnadirComida", urlPatterns ={"/servlet-anadirComida"})
public class ServletAnadirComida extends HttpServlet {
    @Override
    public void init()throws ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Recuperamos parametros de la entrada

        int idProducto = Integer.parseInt(req.getParameter("idProducto"));
        int cantidad = Integer.parseInt(req.getParameter("cantidad"));
        boolean cambio;
        if(req.getParameter("cambio") != null){
            cambio = true;
        }else{
            cambio = false;
        }
        //Boolean cambio = Boolean.parseBoolean(req.getParameter("cambio"));

        // Creamos una ComandaProducto solo con los parametros que sabemos

        ComandaProducto comandaProducto = new ComandaProducto();
        comandaProducto.setIdProducto(idProducto);
        comandaProducto.setCantidad(cantidad);

        //Hacemos una lista para añadir todos los productos a ella y cuando acabemos la comanda se la enviamos

        List<ComandaProducto> comandaProductos;

        //Comprobamos que no exista antes
        if(req.getSession().getAttribute("listaComanda") != null){
            comandaProductos = (List<ComandaProducto>) req.getSession().getAttribute("listaComanda");
        }else{
            comandaProductos = new ArrayList<>();
        }

        if(cambio){

            for(ComandaProducto cp : comandaProductos){
                if(cp.getIdProducto() == idProducto){
                    cp.setCantidad(cantidad);
                }
            }

            req.getSession().setAttribute("listaComanda",comandaProductos);
            req.getRequestDispatcher("/servlet-pedir").forward(req, resp);

        }else{
            comandaProductos.add(comandaProducto);
        }

        // La guardamos en la sesion
        req.getSession().setAttribute("listaComanda",comandaProductos);
        req.getRequestDispatcher("/menu/menu.jsp").forward(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }
}
