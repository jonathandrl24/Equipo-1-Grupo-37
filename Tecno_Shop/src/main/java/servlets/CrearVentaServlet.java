package servlets;

import beans.Venta;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.VentaController;
import java.io.BufferedReader;
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

@WebServlet(name = "CrearVentaServlet", urlPatterns = {"/CrearVentaServlet"})
public class CrearVentaServlet extends HttpServlet {

    private final VentaController ventaController = new VentaController();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
            Gson gson = new GsonBuilder().create();
            Venta venta = gson.fromJson(sb.toString(), Venta.class);
            ventaController.create(venta);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
