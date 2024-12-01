/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import Conexiones.ConexionLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class CLogin {
    
    public String validarDatos(JTextField usuario,JPasswordField contraseña) throws SQLException{
        
        try{
            ConexionLogin conexion = ConexionLogin.getInstance();

            String consulta = "SELECT user_rol FROM users WHERE users.user_usuario = (?) AND users.user_contraseña=(?);";
            String u = usuario.getText();
            String c = String.valueOf(contraseña.getPassword());

            ResultSet rs = conexion.executeQuery(consulta, u, c);

            // Verifica si hay resultados
        if (rs.next()) {
            // Obtiene el valor de user_rol
            String rol = rs.getString("user_rol");

                // Realiza la validación
                return switch (rol) {
                    case "admin" -> "admin";
                    case "vendedor" -> "vendedor";
                    default -> "desconocido";
                };
        } else {
            return "incorrecto";
        }
            }catch(SQLException e){
    JOptionPane.showMessageDialog(null,"Error:"+e.toString());
        }
        return null;
    }
    
    public void Aceptar(){
        
    }
    }
