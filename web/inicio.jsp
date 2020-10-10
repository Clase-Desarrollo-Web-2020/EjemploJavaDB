<%-- 
    Document   : inicio
    Created on : 9 oct. 2020, 18:11:36
    Author     : geofr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ingreso de datos</h1>
        <form action="insertar" method="post">
            <table>
                <tr>
                    <td>Codigo:</td>
                    <td><input type="text" name="codigo"></td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre"></td>
                </tr>
                <tr>
                    <td>Apellido:</td>
                    <td><input type="text" name="apellido"></td>
                </tr>
                <tr>
                    <td>Nota:</td>
                    <td><input type="text" name="nota"></td>
                </tr>
            </table>
            <input type="submit" value="Insertar">
        </form>
    </body>
</html>
