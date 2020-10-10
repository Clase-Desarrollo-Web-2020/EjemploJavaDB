/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadb;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author geofr
 */
public class Conexion {
    Connection connection;
    Statement sentencia;
        
    private Connection Conectar() throws SQLException {
        Driver driver = new org.apache.derby.jdbc.ClientDriver();
        String URLDerby = "jdbc:derby://localhost:1527/ESTUDIANTES";
        String user = "geo";
        String password = "123";
        
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection(
                URLDerby, user, password);
        return connection;
    }
    
    public void Desconectar() throws SQLException{
        sentencia.close();
        connection.close();        
    }
    
    public ResultSet GetEstudiantes() throws SQLException {
        ResultSet resultSet;
        
        try {
            //Obtenemos la conexion a Derby
            connection = Conectar();
            String consulta = "SELECT * FROM ESTUDIANTES";
            //Preparamos la consulta
            sentencia = connection.createStatement();
            //Ejecutamos la consulta
            resultSet = sentencia.executeQuery(consulta);
            
            return resultSet;
            
        } catch (SQLException sqlEx) {
            return null;
        }        
    }
    
    public ResultSet GetApellidos() throws SQLException {
        ResultSet resultSet;
        
        try {
            //Obtenemos la conexion a Derby
            connection = Conectar();
            String consulta = "SELECT DISTINCT APELLIDO FROM ESTUDIANTES ORDER BY APELLIDO";
            //Preparamos la consulta
            sentencia = connection.createStatement();
            //Ejecutamos la consulta
            resultSet = sentencia.executeQuery(consulta);
            
            return resultSet;
            
        } catch (SQLException sqlEx) {
            return null;
        }        
    }
    
    public ResultSet GetEstudiantesApellido(String apellido) throws SQLException {
        ResultSet resultSet;
        
        try {
            //Obtenemos la conexion a Derby
            connection = Conectar();
            String consulta = "SELECT * FROM ESTUDIANTES WHERE APELLIDO = '" + apellido + "'";
            //Preparamos la consulta
            sentencia = connection.createStatement();
            //Ejecutamos la consulta
            resultSet = sentencia.executeQuery(consulta);
            
            return resultSet;
            
        } catch (SQLException sqlEx) {
            return null;
        }        
    }
    
    public String InsertarEstudiante (
            int codigo, String nombre, String apellido,
            int nota) throws SQLException {
        try {
            //Obtenemos la conexion a Derby
            connection = Conectar();
            //Preparamos la consulta
            String consulta = "INSERT INTO ESTUDIANTES (ID, NOMBRE, APELLIDO, CALIFICACION) " +
                    "VALUES (" + codigo + ",'" + nombre + "','" + apellido + "'," + nota + ")";
            sentencia = connection.createStatement();
            //Ejecutamos y devolvemos resultado
            sentencia.execute(consulta);
            return "OK";
        } catch (SQLException sqlEx) {
            return sqlEx.getMessage();    
        }          
    }
}
