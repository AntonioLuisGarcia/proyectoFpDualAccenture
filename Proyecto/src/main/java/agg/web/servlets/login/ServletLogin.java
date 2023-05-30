package agg.web.servlets.login;

import agg.client.*;
import agg.persistence.dao.clases.Camarero;
import agg.service.BebidaService;
import agg.service.CamareroService;
import agg.service.ComidaService;
import agg.service.PostreService;
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
 * Este servlet pretende validar los parametros recibidos con las credenciales de la aplicacion. En caso de coincidir
 * crea un objeto de Camarero y lo almacena en la sesion, y en caso contrario redirige el flujo a la web de login con
 * un mensaje de error para informar al usuario de lo que ha ocurrido.
 */

@WebServlet(
        // Definimos el nombre del servlet
        name="ServletLogin",
        // Definimos la ruta (URL) por la cual el servlet podra ser invocado
        urlPatterns ={"/servlet-login"})
public class ServletLogin extends HttpServlet {

    private CamareroService service;

    @Override
    public void init()throws ServletException {
        service = new CamareroService(new CamareroClient(ClientBuilder.newClient()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException,
            IOException {

        // Recuperamos parametros de la entrada
        String usuario = req.getParameter("usuario");
        String contrasenia = req.getParameter("contrasenia");

        //Verificamos que existe y devolvemos el objeto Camarero
        Camarero camarero = service.verificateUserByUserAndPassword(usuario,contrasenia);

        // Si existe es porque los credenciales son correctos
        if(camarero != null){

            // Se consulta a la BD las productos
            List food = new ComidaService(new ComidaClient(ClientBuilder.newClient())).listAll();
            List postres = new PostreService(new PostreClient(ClientBuilder.newClient())).listAll();
            List drinks = new BebidaService(new BebidaClient(ClientBuilder.newClient())).lisAll();

            //Se guarda a la sesion el Camarero
            req.getSession().setAttribute("userLogin", camarero);

            //Se guardan la lista de productos a la sesion
            req.getSession().setAttribute("foodList",food);
            req.getSession().setAttribute("postresList",postres);
            req.getSession().setAttribute("drinks",drinks);

            //No indicaremos tiempo maximo de sesion
            /*req.getSession().setMaxInactiveInterval(10);*/

            //Redirigimos a pagina menu.jsp utilizando el metodo "getRequestDispatcher" del objeto de respuesta
            req.getRequestDispatcher("/menu/menu.jsp").forward(req, resp);

        } else {
            //Se indica mensaje de error en los atributos de la solicitud
            String error = "Error al validar usuario y contraseña" ;
            req.setAttribute("error",error);

            //Indicamos al dispatcher que haga un forward de la solicitud. Tener en cuenta que esta solicitud es la
            //recibida en este servlet mas los parametros indicados en los atributos.
            resp.sendRedirect("/Proyecto/index.jsp");
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException  {
        doPost(req, res);
    }
}