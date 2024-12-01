/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Conexiones.ConexionLogin;
import Conexiones.ConexionTienda;
import com.toedter.calendar.JDateChooser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Moises
 */
public class C_CRUDVentas {

    
    
    
    public void MostrarVentas(JTable paramregistros){
        ConexionTienda objetoConexion = ConexionTienda.getInstance();
            
        DefaultTableModel modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
        
        String sql="";
        
        modelo.addColumn("ID");
        modelo.addColumn("Fecha Venta");
        //paramregistros.setRowSorter(OrdenarTabla);
        sql ="SELECT * FROM Ventas";
        
        String[] datos = new String[2];
        
        try{
            
            ResultSet rs = objetoConexion.executeQuery(sql);
            
            while(rs.next()){
                
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                
                modelo.addRow(datos);
            }
            
            paramregistros.setModel(modelo);
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo mostar los registro de la BD");
            
        }
    }
    
    public void RellenarComboBox(String tabla, String valor, JComboBox combobox){
    String sql = "Select * from " + tabla;
    ConexionTienda objetoConexion = ConexionTienda.getInstance();
    
    try{
        ResultSet rs = objetoConexion.executeQuery(sql);
        while(rs.next())
        {
            combobox.addItem(rs.getString(valor));
        }
    } catch(Exception e){
        JOptionPane.showMessageDialog(null,"No se pudo mostar los registro de la BD"+e.toString());
    }
    }
    
    public void RellenarTablaVenta (DefaultTableModel modeloPedido, JTable tabla,String producto, int cantidad){
        
        String sql = "SELECT * FROM productos WHERE nombre_producto='" + producto+"';";
        ConexionTienda objetoConexion = ConexionTienda.getInstance();
        
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modeloPedido);
        
        try{
            ResultSet rs = objetoConexion.executeQuery(sql);
            while(rs.next()){
                
            float total = cantidad * rs.getFloat("costo");
            
            
             String[] datos = new String[4];
            
                
                datos[0] = producto;
                datos[1] = rs.getString("costo");
                datos[2] = String.valueOf(cantidad);
                datos[3] = String.valueOf(total);
                modeloPedido.addRow(datos);
            }
            
            tabla.setModel(modeloPedido);

        }catch(Exception e){
        JOptionPane.showMessageDialog(null,"No se pudo mostar los registro de la BD"+e.toString());
    }
        
    }
    
    public String CalcularTotal(JTable tabla){
        float fila = 0;
        float total = 0;
        
        for(int i=0;i<tabla.getRowCount();i++){
            fila =  Float.parseFloat(tabla.getValueAt(i, 3).toString());
            total += fila;
        }
        
        return "Total: "+total+"$";
    }
    
    public void InsertarVenta(JDateChooser txtfechaVenta, JTable tabla){
        try{
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String fechaString = formato.format(txtfechaVenta.getDate());
            String valores[] = {fechaString};
            System.out.println(valores[0]);
            
            String sql= "insert into Ventas(fecha_venta) values(?)";
            ConexionTienda conexion = ConexionTienda.getInstance();
            
            conexion.executeInsertar(sql, valores);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error, fallo en insertar Venta. Descripcion: "+e.toString());
        }
        
        /*try{
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error, fallo en insertar productoxventa. Descripcion: "+e.toString());
        }*/
           
    
    }
    
    public void ModificarVenta(JTable paramregistros)throws SQLException{
        try{
            int seleccion = paramregistros.getSelectedRow();
            if(seleccion == -1){
                JOptionPane.showMessageDialog(null, "Por favor selecciona un producto de la tabla para modificar");
                return;
            }
            
            String[] datosNuevos = new String[2];
            datosNuevos[0] = paramregistros.getValueAt(seleccion, 1).toString();//fecha_venta
            datosNuevos[1] = paramregistros.getValueAt(seleccion, 0).toString();//id_venta
            System.out.println("fecha de fila:"+datosNuevos[1]);
            //datosNuevos[2]= paramregistros.getValueAt(seleccion, 2).toString();

            ConexionTienda conexion = ConexionTienda.getInstance();

            String query = "UPDATE ventas SET fecha_venta = ? WHERE id_venta = ?";
            int rs = conexion.executeActualizarDatos(query, datosNuevos);
            if(rs>0){
                System.out.println("Paso el rs.next");
                JOptionPane.showMessageDialog(null, "Modificacion realizada");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo modificar");

            }
        } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Error :"+e.toString());
        }
    }
    
    public void ModificarVenta2(JTable tabla){
            int seleccion = tabla.getSelectedRow();
            if(seleccion == -1){
                JOptionPane.showMessageDialog(null, "Por favor selecciona un producto de la tabla para modificar");
                return;
            } 
            float cantidad = Float.parseFloat(tabla.getValueAt(seleccion, 2).toString());
            float costo = Float.parseFloat(tabla.getValueAt(seleccion, 1).toString());
            float total = costo*cantidad;
            
            tabla.setValueAt(total, seleccion, 3);
    }
    
    public void MostrarVentas2(JTable tabla){

    }
    
    
    public void EliminarVenta(JTable paramregistros)throws SQLException{
        
        try{
            int seleccion = paramregistros.getSelectedRow();
            if(seleccion == -1){
                JOptionPane.showMessageDialog(null, "Por favor selecciona un producto de la tabla para eliminar");
                return;
            }
            String[] datos = new String[1];
            datos[0] = paramregistros.getValueAt(seleccion, 0).toString();//id_venta

            ConexionTienda conexion = ConexionTienda.getInstance();

            String query = "DELETE FROM ventas where id_venta = ?";


            int rs = conexion.executeDelete(query, datos);
            if(rs>0){
                System.out.println("Paso el rs.next");
                JOptionPane.showMessageDialog(null, "Venta Eliminada Exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo eliminar");

            }
        } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Error en eliminarVenta:"+e.toString());
        }
        
        
        
    }

    public void EliminarVenta2(JTable tablaventa) {
        tablaventa.getSelectedRow();
    }
    
}
