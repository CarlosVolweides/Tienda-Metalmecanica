/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class PanelVentas extends javax.swing.JPanel {

    /**
     * Creates new form PanelProductos
     */
    public PanelVentas() {
        initComponents();
    }
    
    public JPanel getFondo() {
        return Panel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        HeaderVentas = new javax.swing.JPanel();
        VentasContainer = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(660, 580));

        Panel.setBackground(new java.awt.Color(255, 255, 255));
        Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Ventas");
        Panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 146, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("PanelVentas");
        Panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 365, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Ventas");
        Panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 365, -1, -1));

        HeaderVentas.setBackground(new java.awt.Color(51, 102, 255));

        javax.swing.GroupLayout HeaderVentasLayout = new javax.swing.GroupLayout(HeaderVentas);
        HeaderVentas.setLayout(HeaderVentasLayout);
        HeaderVentasLayout.setHorizontalGroup(
            HeaderVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        HeaderVentasLayout.setVerticalGroup(
            HeaderVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Panel.add(HeaderVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, -1));

        VentasContainer.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout VentasContainerLayout = new javax.swing.GroupLayout(VentasContainer);
        VentasContainer.setLayout(VentasContainerLayout);
        VentasContainerLayout.setHorizontalGroup(
            VentasContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        VentasContainerLayout.setVerticalGroup(
            VentasContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        Panel.add(VentasContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 650, 380));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HeaderVentas;
    private javax.swing.JPanel Panel;
    private javax.swing.JPanel VentasContainer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
