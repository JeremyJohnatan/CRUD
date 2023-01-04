/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package crud;

import java.sql.*;
import javax.swing.JOptionPane;
//import com.mysql.cj.xdevapi.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class view extends javax.swing.JFrame {
    private DefaultTableModel tbl;
    
    String id;

    /**
     * Creates new form view
     */
    public view() {
        initComponents();
        tbl = new DefaultTableModel();
        this.jTable.setModel(tbl);
        tbl.addColumn("id");
        tbl.addColumn("No Handphone");
        tbl.addColumn("Nama");
        tbl.addColumn("Berat Laundry (kg)");
        tbl.addColumn("type");
        table();
    }
    
    public void reset(){
        this.tnohp.setText("");
        this.tnama.setText("");
        this.tberat.setText("");
        this.cb_type.setSelectedItem("");
    }
    
    public void ambiltabel(){
        int i=this.jTable.getSelectedRow();
        
        if(i==-1){
            return;
        }
        this.id = (String) tbl.getValueAt(i, 0);
        String nohandphone=(String) tbl.getValueAt(i, 1);
        this.tnohp.setText(nohandphone);
        String nama=(String) tbl.getValueAt(i, 2);
        this.tnama.setText(nama);
        String beratkg=(String) tbl.getValueAt(i, 3);
        this.tberat.setText(beratkg);
        String type=(String) tbl.getValueAt(i, 4);
        this.cb_type.setSelectedItem(type);
        
    }

    public void table (){
        
        tbl.getDataVector().removeAllElements();
        tbl.fireTableDataChanged();
            
        
        
        try {
            Statement st = (Statement)koneksi.getConnection().createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM tb_pesananlaundry");
        
        while(rs.next()){
           
            tbl.addRow(new Object[]{
            rs.getString("id"),
            rs.getString("no_handphone"),
            rs.getString("nama"),
            rs.getString("berat_laundry"),
            rs.getString("type")
             }
            );
            jTable.setModel(tbl);           
        }
            JOptionPane.showMessageDialog(null,"Koneksi Database Berhasil");
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Koneksi Database Gagal" + e.getMessage());
        }
    }
    
    void cari(){
//        DefaultTableModel tbl= new DefaultTableModel();
//        tbl = new DefaultTableModel();
        tbl.getDataVector().removeAllElements();
        tbl.fireTableDataChanged();
            
//        tbl.addColumn("id");
//        tbl.addColumn("No Handphone");
//        tbl.addColumn("Nama");
//        tbl.addColumn("Berat Laundry (kg)");
//        tbl.addColumn("type");
         try {
             String sql = "SELECT * FROM tb_pesananlaundry WHERE nama like '%" + tcari.getText() + "%'";
             Connection con = (Connection) koneksi.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql);
             
            while(rs.next()){
                tbl.addRow(new Object[]{
                rs.getString("id"),
                rs.getString("no_handphone"),
                rs.getString("nama"),
                rs.getString("berat_laundry"),
                rs.getString("type")
                 }
                );
//                jTable.setModel(tbl);           
            }
              
              st.close();
              rs.close();
         } catch (Exception e) {
         }
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tnohp = new javax.swing.JTextField();
        tnama = new javax.swing.JTextField();
        tberat = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        tCari = new javax.swing.JButton();
        tcari = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        cb_type = new javax.swing.JComboBox<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 153, 255));
        setForeground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel1.setText("Pesanan Laundry");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("No Handphone");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Nama");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Berat Laundry (Kg)");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Type");

        tnohp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnohpActionPerformed(evt);
            }
        });

        jButton1.setText("Simpan");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton3.setText("Edit");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Hapus");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        tCari.setText("Cari");
        tCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCariActionPerformed(evt);
            }
        });

        tcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcariActionPerformed(evt);
            }
        });

        jTable.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable);

        cb_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "cuci setrika", "setrika" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(tCari)
                                .addGap(18, 18, 18)
                                .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(108, 108, 108)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(22, 22, 22)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tnohp)
                                            .addComponent(tnama)
                                            .addComponent(tberat, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                            .addComponent(cb_type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(90, 90, 90)
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton4)))
                                .addGap(0, 153, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tnohp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tberat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cb_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCari)
                    .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tnohpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnohpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnohpActionPerformed

    private void tcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcariActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        try {
            String sql = "INSERT INTO tb_pesananlaundry(no_handphone, nama, berat_laundry, type) VALUES ('"+ tnohp.getText() +"', '" 
                    + tnama.getText() + "', '"+ tberat.getText() +"', '"+ cb_type.getSelectedItem() +"')"; 
            
            Connection con = (Connection) koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            table();
            
            JOptionPane.showMessageDialog(null, "Berhasil Menyimpan");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan" + e.getMessage());
            
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        ambiltabel();
    }//GEN-LAST:event_jTableMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        try {
            
            System.out.println(id);
            
            String type = null;
            
            if(cb_type.getSelectedItem().equals("cuci setrika")){
                type = "cuci setrika"; 
            }else{
                type = "cuci";
            }
            
            String sql = "UPDATE tb_pesananlaundry SET no_handphone='" + tnohp.getText()+ "',nama='" + tnama.getText()
                    + "',berat_laundry ='" + tberat.getText()+ "',type='" + type + "' WHERE id='" + id + "'";
            Connection con = (Connection) koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
            table();
            reset();
            JOptionPane.showMessageDialog(null, "Berhasil Edit");
            
           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Edit" + e.getMessage());
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        try {
            String sql = "DELETE FROM tb_pesananlaundry WHERE id ='" + id + "'";
            
            Connection con = (Connection) koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
            table();
            reset();
            JOptionPane.showMessageDialog(null, "Berhasil Hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Hapus"+ e.getMessage());
        }
    }//GEN-LAST:event_jButton4MouseClicked

    private void tCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCariActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_tCariActionPerformed

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
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new view().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_type;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton tCari;
    private javax.swing.JTextField tberat;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tnama;
    private javax.swing.JTextField tnohp;
    // End of variables declaration//GEN-END:variables
}
