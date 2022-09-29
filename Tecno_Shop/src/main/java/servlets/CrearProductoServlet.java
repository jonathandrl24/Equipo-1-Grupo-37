package servlets;

import beans.Productos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.ProductoController;
import java.io.BufferedReader;
import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CrearProductoServlet", urlPatterns = {"/CrearProductoServlet"})
public class CrearProductoServlet extends HttpServlet {

    private final ProductoController productoController = new ProductoController();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
            Gson gson = new GsonBuilder().create();
            Productos producto = gson.fromJson(sb.toString(), Productos.class);
            productoController.create(producto);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CrearProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
