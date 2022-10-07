package servlets;

import beans.Venta;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import controller.VentaController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
            String resultado = ventaController.create(venta);
            response.setContentType("text/plain");
            //Se saca el PrintWriter para escribir los datos que se van a retornar
            PrintWriter out = response.getWriter();
            //Se marca el estado de la peticion con codigo 200 OK para indicar que todo fue bien 
            response.setStatus(HttpServletResponse.SC_OK);
            //Se escribe la respuesta
            out.write(resultado);
            //Se le indica al writer que ya se termino de escribir y que puede enviar la respuesta
            out.flush();
        } catch (JsonSyntaxException | IOException | SQLException e) {
            
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
