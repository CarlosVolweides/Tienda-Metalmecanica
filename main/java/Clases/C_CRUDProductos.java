/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Conexiones.ConexionTienda;
import Vistas.PanelProductos;
import Vistas.ProductosNew;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author User
 */
public class C_CRUDProductos {
    
    String ID;
    String nombre;
    String precio;
    
    public String getIDProducto() {
        return ID;
    }

    public void setIDProducto(String IDProducto) {
        this.ID = IDProducto;
    }

    public String getNombreProducto() {
        return nombre;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombre = nombreProducto;
    }
    
    public String getPrecioProducto() {
        return precio;
    }

    public void setPrecioProducto(String precioProducto) {
        this.precio = precioProducto;
    }

    
    public void MostrarProductos(JTable paramregistros){
            ConexionTienda objetoConexion = ConexionTienda.getInstance();
            
            DefaultTableModel modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
        
        String sql="";
        
        modelo.addColumn("ID");
        modelo.addColumn("Producto");
        modelo.addColumn("Precio");
        paramregistros.setRowSorter(OrdenarTabla);
        sql ="SELECT * FROM Productos";
        
        String[] datos = new String[3];
        
        try{
            
            ResultSet rs = objetoConexion.executeQuery(sql);
            
            while(rs.next()){
                
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                
                modelo.addRow(datos);
            }
            
            paramregistros.setModel(modelo);
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo mostar los registro de la BD");
            
        }
    }
    
    
    
    
    public void InsertarProducto(JTextField nombre, JTextField precio) throws SQLException{
        
        ConexionTienda conexion = ConexionTienda.getInstance();
        
        setNombreProducto(nombre.getText());
        setPrecioProducto(precio.getText());
        
        String sql = "INSERT INTO productos(nombre_producto,costo,stock) Values((?),(?),0);";
        
        try { 
            
            int rs = conexion.executeUpdate(sql, getNombreProducto(), getPrecioProducto(), null);
            if (rs>0){
                JOptionPane.showMessageDialog(null, "Datos insertados correctamente");
            }
        } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error, fallo en la inseción de datos. Descripcion: "+e.toString());
        }
        
    }
    
    public void ModificarProducto(JTable tabla) throws SQLException{
        
        try{
        int seleccion = tabla.getSelectedRow();
        if(seleccion == -1){
            JOptionPane.showMessageDialog(null, "Por favor selecciona un producto de la tabla para modificar");
            return;
        }
        
        String id = tabla.getValueAt(seleccion, 0).toString();
        String nombre = tabla.getValueAt(seleccion, 1).toString();
        String precio = tabla.getValueAt(seleccion, 2).toString();
        
        ConexionTienda conexion = ConexionTienda.getInstance();
        
        String query = "UPDATE productos SET nombre_producto = (?), costo = (?) WHERE id_producto = (?)";
        int rs = conexion.executeUpdate(query, nombre, precio,id);
        if(rs>0){
            System.out.println("Paso el rs.next");
            JOptionPane.showMessageDialog(null, "Modificacion realizada");
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo modificar");
            
        }
    } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error:"+e.toString());
    }
    }
    
    public void EliminarProducto(JTable tabla) throws SQLException{
        
        try{
            int seleccion = tabla.getSelectedRow();
            if(seleccion == -1){
                JOptionPane.showMessageDialog(null, "Por favor selecciona un producto de la tabla para eliminar");
                return;
            }
            String[] datos = new String[1];
            datos[0] = tabla.getValueAt(seleccion, 0).toString();

            ConexionTienda conexion = ConexionTienda.getInstance();

            String query = "DELETE FROM Productos where id_producto = ?";


            int rs = conexion.executeDelete(query, datos);
            if(rs>0){
                System.out.println("Paso el rs.next");
                JOptionPane.showMessageDialog(null, "Producto Eliminado Exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo eliminar");

            }
        } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Error en eliminarProducto:"+e.toString());
        }
        
        
    
    }
    
}
