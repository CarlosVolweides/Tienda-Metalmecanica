/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexiones;
import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public final class ConexionTienda implements Closeable {

    private static ConexionTienda instance;

    private static final String USER = "root"; 
    private static final String PASSWORD = "w12My..";
    private static final String URL = "jdbc:mysql://localhost:3306/tienda";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    
    private Connection connection;

    private ConexionTienda() {
        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            JOptionPane.showMessageDialog(null, "Conexion con tienda iniciada");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexionTienda.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No funciona la tienda papu");
        }
    }

    public static ConexionTienda getInstance() {
        if (instance == null) {
            instance = new ConexionTienda();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public ResultSet executeQuery(final String query) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery(); 
    }
    
    public int executeUpdate(final String query,String n,String c, String i) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, n);
        preparedStatement.setString(2,c);
        preparedStatement.setString(3, i);
        return preparedStatement.executeUpdate();
    }

    @Override
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionTienda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}


