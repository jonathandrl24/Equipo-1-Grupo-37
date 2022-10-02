/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import beans.Productos;
import beans.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.ProductoController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ConsultarProductoServlet", urlPatterns = {"/ConsultarProductoServlet"})
public class ConsultarProductoServlet extends HttpServlet {

    private ProductoController productoController = new ProductoController();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String usuarioJson = null;
        Gson gson = new GsonBuilder().create();
        //El servelet puede recibir cualquiera de los dos parametros, dependiendo del parametro recibido buscara por este, tener en cuenta que son excluyentes
        String idStr = request.getParameter("id");
        String cat = request.getParameter("categoria");
        if (idStr != null) {//Si llega id entra a esta condicion y busca un producto con el id
            int numeroId = Integer.parseInt(idStr);
            Productos producto = productoController.consultarPorId(numeroId);
                usuarioJson = gson.toJson(producto);
        } else if(cat != null) {//Si llega categoria, entra a esta condicion y saca todos los productos de la categoria
            List<Productos> productos = productoController.consultarPorCategoria(cat);
            usuarioJson = gson.toJson(productos);
        }  else {//Si no llega ningun parametro consulta todos los productos
            List<Productos> productos = productoController.consultarActivos();
            usuarioJson = gson.toJson(productos);
        }      
        //Se establece e conten-type para que el protocolo sepa que informacion va a llevar
        response.setContentType("application/json");
        //Se saca el PrintWriter para escribir los datos que se van a restornar
        try ( PrintWriter out = response.getWriter()) {
            //Se marca el estado de la peticion con codigo 200 OK para indicar que todo fue bien 
            response.setStatus(HttpServletResponse.SC_OK);
            //Se escribe la respuesta
            out.write(usuarioJson);
            //Se le indica al writer que ya se termino de escribir y que puede enviar la respuesta
            out.flush();
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
