/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import DAO.HabitacionesDAO;
import DAO.TipoHabitacionesDAO;
import DTO.HabitacionesDTO;
import DTO.TipoHabitacionesDTO;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jahdi
 */
public class HabitacionesView extends javax.swing.JFrame {

    /**
     * Creates new form HabitacionesView
     */
    public HabitacionesView() {
        initComponents();
        
        TipoHabitacionesDAO tipos = new TipoHabitacionesDAO();
        List<TipoHabitacionesDTO> listaTipos = tipos.obtenerTipoHabitaciones();
        for(TipoHabitacionesDTO tipo : listaTipos){
            jCbTipos.addItem(tipo.getId() + " - " + tipo.getTipo());
        }
        
        // ItemListener al jCbTipos
        jCbTipos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    String selectedItem = (String) jCbTipos.getSelectedItem();
                    int selectedId = Integer.parseInt(selectedItem.split(" - ")[0]);

                    TipoHabitacionesDTO tipoSeleccionado = null;
                    for (TipoHabitacionesDTO tipo : listaTipos) {
                        if (tipo.getId() == selectedId) {
                            tipoSeleccionado = tipo;
                            break;
                        }
                    }

                    if (tipoSeleccionado != null) {
                        jTxtDescripcion.setText(tipoSeleccionado.getDescripcion());
                        jTxtCapacidad.setText(String.valueOf(tipoSeleccionado.getCapacidad()));
                    }
                }
            }
        });

        String selectedItem = (String) jCbTipos.getSelectedItem();
        int selectedId = Integer.parseInt(selectedItem.split(" - ")[0]);
        TipoHabitacionesDTO tipoSeleccionado = null;
        for (TipoHabitacionesDTO tipo : listaTipos) {
            if (tipo.getId() == selectedId) {
                tipoSeleccionado = tipo;
                break;
            }
        }

        if (tipoSeleccionado != null) {
            jTxtDescripcion.setText(tipoSeleccionado.getDescripcion());
            jTxtCapacidad.setText(String.valueOf(tipoSeleccionado.getCapacidad()));
        }
        
        mostrarHabitaciones();
        
        jBtnActualizar.setEnabled(false);
        jBtnEliminar.setEnabled(false);
        
        jTbHabitaciones.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    boolean filaSelec = (jTbHabitaciones.getSelectedRow() != -1);
                    jBtnActualizar.setEnabled(filaSelec);
                    jBtnEliminar.setEnabled(filaSelec);
                    
                    int filaSeleccionada = jTbHabitaciones.getSelectedRow();
                    if(filaSeleccionada != -1){
                        DefaultTableModel model = (DefaultTableModel) jTbHabitaciones.getModel();
                        jTxtNumero.setText(model.getValueAt(filaSeleccionada, 1).toString());
                        
                        String tipoId = model.getValueAt(filaSeleccionada, 2).toString().split(" - ")[0];
                        for (int i = 0; i < jCbTipos.getItemCount(); i++) {
                            if (jCbTipos.getItemAt(i).contains(tipoId)) {
                                jCbTipos.setSelectedIndex(i);
                                ItemEvent eventI = new ItemEvent(jCbTipos, ItemEvent.ITEM_STATE_CHANGED, jCbTipos.getSelectedItem(), ItemEvent.SELECTED);
                                for (ItemListener listener : jCbTipos.getItemListeners()) {
                                    listener.itemStateChanged(eventI);
                                }
                                break;
                            }
                        }
                        
                    
                    }
                }
            }
        });
        
        
    }
    
    private void mostrarHabitaciones() {
        String[] columnas = {
            "ID", 
            "NUMERO HABITACION", 
            "TIPO", 
            "CAPACIDAD", 
            "DESCRIPCION"
        };

        DefaultTableModel tableModel = new DefaultTableModel(columnas, 0);
        HabitacionesDAO habitacionesDAO = new HabitacionesDAO();
        List<HabitacionesDTO> listaHabitaciones = habitacionesDAO.obtenerHabitaciones();

        for (HabitacionesDTO habitacion : listaHabitaciones) {
            Object[] data = {
                habitacion.getId(),
                habitacion.getHabitacion(),
                habitacion.getTipoHabitacion() + " - " + habitacion.getTipo(),
                habitacion.getCapacidad(),
                habitacion.getDescripcion()
            };
            tableModel.addRow(data);
        }

        jTbHabitaciones.setModel(tableModel);
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
        jTxtNumero = new javax.swing.JTextField();
        jCbTipos = new javax.swing.JComboBox<>();
        jTxtDescripcion = new javax.swing.JTextField();
        jTxtCapacidad = new javax.swing.JTextField();
        jBtnAgregar = new javax.swing.JButton();
        jBtnActualizar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbHabitaciones = new javax.swing.JTable();
        jBtnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setText("HABITACIONES");

        jLabel2.setText("Numero de habitacion:");

        jLabel3.setText("Tipo de Habitacion:");

        jLabel4.setText("Descripcion:");

        jLabel5.setText("Capacidad:");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(80, 80, 80)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTxtNumero)
                        .addComponent(jCbTipos, 0, 130, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jBtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(jBtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)
                        .addComponent(jBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jCbTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTxtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAgregar)
                    .addComponent(jBtnActualizar)
                    .addComponent(jBtnEliminar))
                .addGap(17, 17, 17))
        );

        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        jTbHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTbHabitaciones);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnRegresar)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgregarActionPerformed
        try {
            if(jTxtNumero.getText().trim().length() > 0 && jCbTipos.getSelectedIndex() != -1){
                String numeroHabitacion = jTxtNumero.getText().trim();

                int tipoHabitacionId = Integer.parseInt(jCbTipos.getSelectedItem().toString().split(" - ")[0]);

                HabitacionesDTO nuevaHabitacion = new HabitacionesDTO(0, numeroHabitacion, tipoHabitacionId, "", 0, "");

                HabitacionesDAO habitaciones = new HabitacionesDAO();
                boolean exito = habitaciones.agregarHabitacion(nuevaHabitacion);

                if (exito) {
                    JOptionPane.showMessageDialog(this, "Habitacion agregada correctamente.");
                    mostrarHabitaciones();
                    jTxtNumero.setText("");
                    jCbTipos.setSelectedIndex(0);
                } else {
                    JOptionPane.showMessageDialog(this, "Error al agregar la habitacion.", "Error", JOptionPane.ERROR_MESSAGE);
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
            int filaSeleccionada = jTbHabitaciones.getSelectedRow();
             if (filaSeleccionada != -1){
                if(jTxtNumero.getText().trim().length() > 0 && jCbTipos.getSelectedIndex() != -1){
                    int id = (Integer) jTbHabitaciones.getValueAt(filaSeleccionada, 0);
                    String numeroHabitacion = jTxtNumero.getText().trim();
                    int tipoHabitacionId = Integer.parseInt(jCbTipos.getSelectedItem().toString().split(" - ")[0]);
                    
                    HabitacionesDTO habitacionActualizada = new HabitacionesDTO(id, numeroHabitacion, tipoHabitacionId, "", 0, "");

                    HabitacionesDAO habitaciones = new HabitacionesDAO();
                    boolean exito = habitaciones.actualizarHabitacion(habitacionActualizada);

                    if (exito) {
                        JOptionPane.showMessageDialog(this, "Habitacion actualizada correctamente.");
                        mostrarHabitaciones();
                        jTxtNumero.setText("");
                        jCbTipos.setSelectedIndex(0);
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al actualizar la habitacion.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Porfavor, asegurese que todos los campos estan completos", "Campos faltantes", JOptionPane.WARNING_MESSAGE);
                }
             }
        } catch (Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ejecutar esta accion", "Error inesperado", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnActualizarActionPerformed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
        try {
            int filaSeleccionada = jTbHabitaciones.getSelectedRow();
             if (filaSeleccionada != -1){
                 int id = (Integer) jTbHabitaciones.getValueAt(filaSeleccionada, 0);
                 int confirmacion = JOptionPane.showConfirmDialog(this, "¿Esta seguro de eliminar esta habitacion?", "Confirmar Eliminacion", JOptionPane.YES_NO_OPTION);
                 if (confirmacion == JOptionPane.YES_OPTION){
                     HabitacionesDAO habitaciones = new HabitacionesDAO();
                     boolean exito = habitaciones.eliminarHabitacion(id);
                     
                     if (exito) {
                        JOptionPane.showMessageDialog(this, "Habitacion eliminada correctamente.");
                        mostrarHabitaciones();
                        jTxtNumero.setText("");
                        jCbTipos.setSelectedIndex(0);
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al eliminar la reserva.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                 }
             }
        } catch (Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ejecutar esta accion", "Error inesperado", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnEliminarActionPerformed

    private void jBtnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRegresarActionPerformed
        this.dispose();
        MenuView menu = new MenuView();
        menu.setVisible(true);
    }//GEN-LAST:event_jBtnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(HabitacionesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HabitacionesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HabitacionesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HabitacionesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HabitacionesView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnActualizar;
    private javax.swing.JButton jBtnAgregar;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnRegresar;
    private javax.swing.JComboBox<String> jCbTipos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbHabitaciones;
    private javax.swing.JTextField jTxtCapacidad;
    private javax.swing.JTextField jTxtDescripcion;
    private javax.swing.JTextField jTxtNumero;
    // End of variables declaration//GEN-END:variables
}
