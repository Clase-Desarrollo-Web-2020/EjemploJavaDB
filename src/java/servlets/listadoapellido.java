/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javadb.Conexion;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author geofr
 */
@WebServlet(name = "listadoapellido", urlPatterns = {"/listadoapellido"})
public class listadoapellido extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String parametro = request.getParameter("apellido");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Conexion connection = new Conexion();
        ResultSet resultSet = null;

        try {
            resultSet = connection.GetEstudiantesApellido(parametro);

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet listar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listado estudiantes con apellido: " + parametro + "</h1>");
            out.println("<br/><br/>");
            out.println("<table border=1>");
            //Recorremos el Resultset
            while (resultSet.next()) {
                int id, calificacion;
                String nombre, apellido;

                //Recogemos los datos llamando al nombre de la columna
                //que el Resultset nos devuelve
                id = resultSet.getInt("id");
                nombre = resultSet.getString("nombre");
                apellido = resultSet.getString("apellido");
                calificacion = resultSet.getInt("calificacion");

                out.println("<tr>");
                out.println("<td>");
                out.println(id);
                out.println("</td>");
                out.println("<td>");
                out.println(nombre);
                out.println("</td>");
                out.println("<td>");
                out.println(apellido);
                out.println("</td>");
                out.println("<td>");
                out.println(calificacion);
                out.println("</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<br/><br/>");
            out.println("<a href=\"formularioapellido.jsp\">Regresar al Inicio</a>");
            out.println("</body>");
            out.println("</html>");
            connection.Desconectar();
        } catch (SQLException sqlEx) {
            out.println("<html>" + sqlEx.getMessage() + "</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
