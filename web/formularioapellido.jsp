<%-- 
    Document   : formularioapellido
    Created on : 9 oct. 2020, 19:06:20
    Author     : geofr
--%>
<%@page import = "javadb.Conexion;"%>
<%@page import = "java.sql.ResultSet"%>
<%@page import = "java.sql.SQLException;"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Busqueda por apellido</h1>
        <form action="listadoapellido" method="post">
            <table>
                <tr>
                    <td>Apellido:</td>
                    <td>
                        <select id="apellido" name="apellido">
                            <%
                                Conexion connection = new Conexion();        
                                ResultSet resultSet = null;
                                String apellido;
                                try {            
                                    resultSet = connection.GetApellidos();
                                    while (resultSet.next()) {
                                        apellido = resultSet.getString("apellido");
                            %>                                                        
                                        <option value="<%= apellido %>"><%= apellido %></option>
                            <%
                                    }
                                    connection.Desconectar();
                                } catch (SQLException sqlEx) {
                            %>        
                                <option value="">--Sin Datos--</option>
                            <%
                               }                                
                            %>
                        </select>                        
                    </td>
                </tr>                
            </table>
            <input type="submit" value="Listar por Apellido">
        </form>
    </body>
</html>
