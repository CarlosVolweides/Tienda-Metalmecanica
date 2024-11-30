/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Conexiones.ConexionTienda;
import Vistas.PanelProductos;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author User
 */
public class C_CRUDProductos {
    
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
    
    
    
    
    public void InsertarProducto(){
        
        
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
            JOptionPane.showConfirmDialog(null, "Modificacion realizada");
        }else{
            JOptionPane.showConfirmDialog(null, "No se pudo modificar");
            
        }
    } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error:"+e.toString());
    }
    }
    
    
    
}
