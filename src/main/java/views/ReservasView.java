/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import DAO.EstadoReservaDAO;
import DAO.HabitacionesDAO;
import DAO.HuespedesDAO;
import DAO.ReservasDAO;
import DTO.EstadoReservaDTO;
import DTO.HabitacionesDTO;
import DTO.HuespedesDTO;
import DTO.ReservasDTO;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jahdi
 */
public class ReservasView extends javax.swing.JFrame {

    /**
     * Creates new form ReservasView
     */
    public ReservasView() {
        initComponents();
        
        HuespedesDAO huespedes = new HuespedesDAO();
        List<HuespedesDTO> listaHuespedes = huespedes.obtenerHuespedes();
        jCbHuesped.removeAllItems();
        for(HuespedesDTO huesped : listaHuespedes){
            jCbHuesped.addItem(huesped.getId() + " - " + huesped.getNombre() + " " + huesped.getApellido());
        }
        
        HabitacionesDAO habitaciones = new HabitacionesDAO();
        List<HabitacionesDTO> listaHabitaciones = habitaciones.obtenerHabitaciones();

        jCbHabitacion.removeAllItems();

        for (HabitacionesDTO habitacion : listaHabitaciones) {
            jCbHabitacion.addItem(habitacion.getId() + " - Habitacion " + habitacion.getHabitacion());
        }
        
        EstadoReservaDAO estadoReservas = new EstadoReservaDAO();
        List<EstadoReservaDTO> listaEstados = estadoReservas.obtenerEstadosReserva();

        jCbEstado.removeAllItems();

        for (EstadoReservaDTO estado : listaEstados) {
            jCbEstado.addItem(estado.getId() + " - " + estado.getEstado());
        }
        
        jTxtPrecio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c) && c != '.') {
                    e.consume();
                }
            }
        });
        
        mostrarReservas();
        
        jDateEntrada.getDateEditor().setEnabled(false);
        jDateSalida.getDateEditor().setEnabled(false);
        jBtnActualizar.setEnabled(false);
        jBtnEliminar.setEnabled(false);
        
        jTbReservas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    boolean filaSelec = (jTbReservas.getSelectedRow() != -1);
                    jBtnActualizar.setEnabled(filaSelec);
                    jBtnEliminar.setEnabled(filaSelec);
                    
                    int filaSeleccionada = jTbReservas.getSelectedRow();
                    if(filaSeleccionada != -1){
                        DefaultTableModel model = (DefaultTableModel) jTbReservas.getModel();
                        String huespedNombre = model.getValueAt(filaSeleccionada, 1).toString();
                        String habitacionNumero = model.getValueAt(filaSeleccionada, 2).toString();
                        java.sql.Date fechaEntrada = java.sql.Date.valueOf(model.getValueAt(filaSeleccionada, 3).toString());
                        java.sql.Date fechaSalida = java.sql.Date.valueOf(model.getValueAt(filaSeleccionada, 4).toString());
                        String estadoReserva = model.getValueAt(filaSeleccionada, 5).toString();
                        double precio = Double.parseDouble(model.getValueAt(filaSeleccionada, 6).toString());

                        jTxtPrecio.setText(String.valueOf(precio));
                        jDateEntrada.setDate(fechaEntrada);
                        jDateSalida.setDate(fechaSalida);

                        for (int i = 0; i < jCbHuesped.getItemCount(); i++) {
                            if (jCbHuesped.getItemAt(i).contains(huespedNombre)) {
                                jCbHuesped.setSelectedIndex(i);
                                break;
                            }
                        }

                        for (int i = 0; i < jCbHabitacion.getItemCount(); i++) {
                            if (jCbHabitacion.getItemAt(i).contains(habitacionNumero)) {
                                jCbHabitacion.setSelectedIndex(i);
                                break;
                            }
                        }

                        for (int i = 0; i < jCbEstado.getItemCount(); i++) {
                            if (jCbEstado.getItemAt(i).contains(estadoReserva)) {
                                jCbEstado.setSelectedIndex(i);
                                break;
                            }
                        }
                    }
                }
            }
        });
    }
    
    private void mostrarReservas() {
        String[] columnas = {
            "ID", 
            "HUESPED", 
            "HABITACIÓN", 
            "FECHA ENTRADA", 
            "FECHA SALIDA", 
            "ESTADO RESERVA", 
            "PRECIO"
        };

        DefaultTableModel tableModel = new DefaultTableModel(columnas, 0);
        ReservasDAO reservaDAO = new ReservasDAO();
        List<ReservasDTO> listaReservas = reservaDAO.obtenerReservas();

        for (ReservasDTO reserva : listaReservas) {
            Object[] data = {
                reserva.getId(),
                reserva.getHuespedNombre(), 
                reserva.getNumeroHabitacion(), 
                reserva.getFechaEntrada(),
                reserva.getFechaSalida(),
                reserva.getEstadoReserva(),
                reserva.getPrecio()
            };

            tableModel.addRow(data);
        }

        jTbReservas.setModel(tableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCbHuesped = new javax.swing.JComboBox<>();
        jCbHabitacion = new javax.swing.JComboBox<>();
        jCbEstado = new javax.swing.JComboBox<>();
        jTxtPrecio = new javax.swing.JTextField();
        jDateEntrada = new com.toedter.calendar.JDateChooser();
        jDateSalida = new com.toedter.calendar.JDateChooser();
        jBtnAgregar = new javax.swing.JButton();
        jBtnActualizar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbReservas = new javax.swing.JTable();
        jBtnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setText("RESERVACION");

        jLabel2.setText("Huesped:");

        jLabel3.setText("Habitacion:");

        jLabel4.setText("Fecha de Entrada:");

        jLabel5.setText("Fecha de Salida:");

        jLabel6.setText("Estado de la Reserva:");

        jLabel7.setText("Precio:");

        jDateEntrada.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jDateSalida.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jBtnAgregar.setText("Agregar");
        jBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgregarActionPerformed(evt);
            }
        });

        jBtnActualizar.setText("Actualizar");
        jBtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnActualizarActionPerformed(evt);
            }
        });

        jBtnEliminar.setText("Eliminar");
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jCbHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jDateEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jCbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(126, 126, 126)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jCbHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jDateSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jTxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jBtnAgregar)
                        .addGap(118, 118, 118)
                        .addComponent(jBtnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnEliminar)))
                .addContainerGap(256, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jCbHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCbHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addComponent(jDateSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jDateEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jCbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAgregar)
                    .addComponent(jBtnActualizar)
                    .addComponent(jBtnEliminar))
                .addGap(19, 19, 19))
        );

        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        jTbReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTbReservas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addContainerGap())
        );

        jBtnRegresar.setText("Regresar");
        jBtnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnRegresar)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRegresarActionPerformed
        this.dispose();
        MenuView menu = new MenuView();
        menu.setVisible(true);
    }//GEN-LAST:event_jBtnRegresarActionPerformed

    private void jBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgregarActionPerformed
        try {
            if(jCbHuesped.getSelectedIndex() != -1 && jCbHabitacion.getSelectedIndex() != -1 && jDateEntrada.getDate() != null && 
                    jDateSalida.getDate() != null && jCbEstado.getSelectedIndex() != -1 && jTxtPrecio.getText().trim().length() > 0){
                int huespedId = Integer.parseInt(jCbHuesped.getSelectedItem().toString().split(" - ")[0]);
                int habitacionId = Integer.parseInt(jCbHabitacion.getSelectedItem().toString().split(" - ")[0]);
                int estadoReservaId = Integer.parseInt(jCbEstado.getSelectedItem().toString().split(" - ")[0]);
                double precio = Double.parseDouble(jTxtPrecio.getText().trim());
                
                java.sql.Date fechaEntrada = new java.sql.Date(jDateEntrada.getDate().getTime());
                java.sql.Date fechaSalida = new java.sql.Date(jDateSalida.getDate().getTime());
                
                ReservasDAO reservas = new ReservasDAO();
                boolean exito = reservas.agregarReserva(huespedId, habitacionId, fechaEntrada, fechaSalida, estadoReservaId, precio);
                
                if (exito) {
                    JOptionPane.showMessageDialog(this, "Reserva agregada correctamente.");
                    mostrarReservas();
                    jCbHuesped.setSelectedIndex(-1);
                    jCbHabitacion.setSelectedIndex(-1);
                    jCbEstado.setSelectedIndex(-1);
                    jDateEntrada.setDate(null); 
                    jDateSalida.setDate(null);
                    jTxtPrecio.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al agregar la reserva.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Porfavor, asegurese que todos los campos estan completos", "Campos faltantes", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ejecutar esta accion", "Error inesperado", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnAgregarActionPerformed

    private void jBtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnActualizarActionPerformed
        try {
            int filaSeleccionada = jTbReservas.getSelectedRow();
            if (filaSeleccionada != -1){
                if(jCbHuesped.getSelectedIndex() != -1 && jCbHabitacion.getSelectedIndex() != -1 && jDateEntrada.getDate() != null && 
                    jDateSalida.getDate() != null && jCbEstado.getSelectedIndex() != -1 && jTxtPrecio.getText().trim().length() > 0){
                    int id = Integer.parseInt(jTbReservas.getValueAt(filaSeleccionada, 0).toString());
                    int huespedId = Integer.parseInt(jCbHuesped.getSelectedItem().toString().split(" - ")[0]);
                    int habitacionId = Integer.parseInt(jCbHabitacion.getSelectedItem().toString().split(" - ")[0]);
                    int estadoReservaId = Integer.parseInt(jCbEstado.getSelectedItem().toString().split(" - ")[0]);
                    double precio = Double.parseDouble(jTxtPrecio.getText().trim());

                    java.sql.Date fechaEntrada = new java.sql.Date(jDateEntrada.getDate().getTime());
                    java.sql.Date fechaSalida = new java.sql.Date(jDateSalida.getDate().getTime());

                    ReservasDAO reservas = new ReservasDAO();
                    boolean exito = reservas.actualizarReserva(id, huespedId, habitacionId, fechaEntrada, fechaSalida, estadoReservaId, precio);
                    
                    if (exito) {
                        JOptionPane.showMessageDialog(this, "Reserva actualizada correctamente.");
                        mostrarReservas();
                        jCbHuesped.setSelectedIndex(-1);
                        jCbHabitacion.setSelectedIndex(-1);
                        jCbEstado.setSelectedIndex(-1);
                        jDateEntrada.setDate(null); 
                        jDateSalida.setDate(null);
                        jTxtPrecio.setText("");
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al actualizar la reserva.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Porfavor, asegurese que todos los campos estan completos", "Campos faltantes", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una reserva", "Seleccion de Fila", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ejecutar esta accion", "Error inesperado", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnActualizarActionPerformed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
        try {
            int filaSeleccionada = jTbReservas.getSelectedRow();
            if (filaSeleccionada != -1){
                int id = (Integer) jTbReservas.getValueAt(filaSeleccionada, 0);
                 int confirmacion = JOptionPane.showConfirmDialog(this, "¿Esta seguro de eliminar esta reserva?", "Confirmar Eliminacion", JOptionPane.YES_NO_OPTION);
                 if (confirmacion == JOptionPane.YES_OPTION){
                    ReservasDAO reservas = new ReservasDAO();
                    boolean exito = reservas.eliminarReserva(id);
                    
                    if (exito) {
                        JOptionPane.showMessageDialog(this, "Reserva eliminada correctamente.");
                        mostrarReservas();
                        jCbHuesped.setSelectedIndex(-1);
                        jCbHabitacion.setSelectedIndex(-1);
                        jCbEstado.setSelectedIndex(-1);
                        jDateEntrada.setDate(null); 
                        jDateSalida.setDate(null);
                        jTxtPrecio.setText("");
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al eliminar la reserva.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                 }
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una reserva", "Seleccion de Fila", JOptionPane.WARNING_MESSAGE);
                return;
            }
           
        } catch (Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ejecutar esta accion", "Error inesperado", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReservasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservasView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnActualizar;
    private javax.swing.JButton jBtnAgregar;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnRegresar;
    private javax.swing.JComboBox<String> jCbEstado;
    private javax.swing.JComboBox<String> jCbHabitacion;
    private javax.swing.JComboBox<String> jCbHuesped;
    private com.toedter.calendar.JDateChooser jDateEntrada;
    private com.toedter.calendar.JDateChooser jDateSalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbReservas;
    private javax.swing.JTextField jTxtPrecio;
    // End of variables declaration//GEN-END:variables
}
