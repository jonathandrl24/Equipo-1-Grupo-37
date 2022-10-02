package servlets;

import beans.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.UsuarioController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "ConsultarUsuarioServlet", urlPatterns = {"/ConsultarUsuarioServlet"})
public class ConsultarUsuarioServlet extends HttpServlet {

    private final UsuarioController usuarioController = new UsuarioController();

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
        String numeroIdStr = request.getParameter("numeroIdentificacion");
        int numeroId = Integer.parseInt(numeroIdStr);
        Usuario usuario = usuarioController.consultar(numeroId);
        Gson gson = new GsonBuilder().create();
        String usuarioJson = gson.toJson(usuario);
        response.setContentType("application/json");
        try ( PrintWriter out = response.getWriter()) {
            response.setStatus(HttpServletResponse.SC_OK);
            out.write(usuarioJson);
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
            Logger.getLogger(ConsultarUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
