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
public class PanelUsuarios extends javax.swing.JPanel {

    /**
     * Creates new form PanelProductos
     */
    public PanelUsuarios() {
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
        HeaderUsuarios = new javax.swing.JPanel();
        UsuariosContainer = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(660, 580));

        Panel.setBackground(new java.awt.Color(255, 255, 255));
        Panel.setPreferredSize(new java.awt.Dimension(660, 580));
        Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HeaderUsuarios.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout HeaderUsuariosLayout = new javax.swing.GroupLayout(HeaderUsuarios);
        HeaderUsuarios.setLayout(HeaderUsuariosLayout);
        HeaderUsuariosLayout.setHorizontalGroup(
            HeaderUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        HeaderUsuariosLayout.setVerticalGroup(
            HeaderUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Panel.add(HeaderUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, -1));

        UsuariosContainer.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("USUARIOS");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("USUARIOS");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Usuarios");

        javax.swing.GroupLayout UsuariosContainerLayout = new javax.swing.GroupLayout(UsuariosContainer);
        UsuariosContainer.setLayout(UsuariosContainerLayout);
        UsuariosContainerLayout.setHorizontalGroup(
            UsuariosContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsuariosContainerLayout.createSequentialGroup()
                .addGroup(UsuariosContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UsuariosContainerLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel2))
                    .addGroup(UsuariosContainerLayout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jLabel1)
                        .addGap(80, 80, 80)
                        .addComponent(jLabel3)))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        UsuariosContainerLayout.setVerticalGroup(
            UsuariosContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsuariosContainerLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(114, 114, 114)
                .addGroup(UsuariosContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addContainerGap(277, Short.MAX_VALUE))
        );

        Panel.add(UsuariosContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 660, 480));

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
    private javax.swing.JPanel HeaderUsuarios;
    private javax.swing.JPanel Panel;
    private javax.swing.JPanel UsuariosContainer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
