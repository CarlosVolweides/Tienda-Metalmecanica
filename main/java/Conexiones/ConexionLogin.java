/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexiones;

/**
 *
 * @author User
 */
import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public final class ConexionLogin implements Closeable {

    private static ConexionLogin instance;

    private static final String USER = "root"; 
    private static final String PASSWORD = "w12My..";
    private static final String URL = "jdbc:mysql://localhost:3306/Metalusers";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    
    private Connection connection;

    private ConexionLogin() {
        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            JOptionPane.showMessageDialog(null, "Conexion iniciada: Bienvenido");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexionTienda.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No funciona papu");
        }
    }

    public static ConexionLogin getInstance() {
        if (instance == null) {
            instance = new ConexionLogin();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public ResultSet executeQuery(final String query,String u,String c) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, u);
        preparedStatement.setString(2, c);
        return preparedStatement.executeQuery();
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



