
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author USER
 */
public class ResepMasakanFrame extends javax.swing.JFrame {
    private DefaultTableModel tabelModel;
    

    /**
     * Creates new form ResepMasakanFrame
     */
    public ResepMasakanFrame() {
        initComponents();
        
        tabelModel = new DefaultTableModel(new String[]{"Nama Masakan", "Bahan", "Langkah"}, 0);
        tabelMasakan.setModel(tabelModel);
        
        btnTambah.addActionListener(evt -> tambahResep());
        btnEdit.addActionListener(evt -> editResep());
        btnHapus.addActionListener(evt -> hapusResep());
        btnImpor.addActionListener(evt -> imporData());
        btnEkspor.addActionListener(evt -> eksporData());
        btnKeluar.addActionListener(e -> System.exit(0));
    }
    
    private void tambahResep() {
        String nama = txtNamaMasakan.getText().trim();
        String bahan = txtAreaBahan.getText().trim();
        String langkah = txtAreaLangkah.getText().trim();

        if (nama.isEmpty() || bahan.isEmpty() || langkah.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Peringatan!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        tabelModel.addRow(new Object[]{nama, bahan, langkah});
        hapusInput();
    }
    
    private void editResep() {
        int selectedRow = tabelMasakan.getSelectedRow();
        if (selectedRow != -1) {
            String nama = JOptionPane.showInputDialog(this, "Edit nama masakan :", tabelModel.getValueAt(selectedRow, 0));
            if (nama != null && !nama.trim().isEmpty()){
                String bahan = JOptionPane.showInputDialog(this, "Edit bahan :", tabelModel.getValueAt(selectedRow, 1));
                String langkah = JOptionPane.showInputDialog(this, "Edit langkah-langkah :", tabelModel.getValueAt(selectedRow, 2));
                
                if (bahan != null && langkah != null) {
                    tabelModel.setValueAt(nama, selectedRow, 0);
                    tabelModel.setValueAt(bahan, selectedRow, 1);
                    tabelModel.setValueAt(langkah, selectedRow, 2);
            }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih resep untuk dihapus", "Peringatan!", JOptionPane.WARNING_MESSAGE);
        }   
    }
    
    private void hapusResep() {
        int selectedRow = tabelMasakan.getSelectedRow();
        if (selectedRow != -1) {
            tabelModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Pilih resep untuk dihapus", "Peringatan!", JOptionPane.WARNING_MESSAGE);
        }   
    }
    
    private void hapusInput() {
        txtNamaMasakan.setText("");
        txtAreaBahan.setText("");
        txtAreaLangkah.setText("");
    }
    
    private void imporData(){
        int result = jFileChooser1.showOpenDialog(this);
        if (result == jFileChooser1.APPROVE_OPTION){
            File file = jFileChooser1.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                tabelModel.setRowCount(0);
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.equals("---")) continue; // untuk skip pemisah
                    String nama = line;
                    String bahan = reader.readLine();
                    String langkah = reader.readLine();
                    tabelModel.addRow(new Object[]{nama, bahan, langkah});
                    reader.readLine(); 
                }
                JOptionPane.showMessageDialog(this, "Data Berhasil diimpor", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }   catch (IOException ex){
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mengimpor data!", "Error", JOptionPane.ERROR_MESSAGE);
            }  
        }
    }
    
    private void eksporData(){
        int result = jFileChooser1.showSaveDialog(this);
        if (result == jFileChooser1.APPROVE_OPTION){
            File file = jFileChooser1.getSelectedFile();
            try (FileWriter writer = new FileWriter(file)) {
                for (int i = 0; i < tabelModel.getRowCount(); i++){
                    writer.write((String) tabelModel.getValueAt(i, 0)); //data nama masakan
                    writer.write(System.lineSeparator());
                    writer.write((String) tabelModel.getValueAt(i, 1)); //data bahan
                    writer.write(System.lineSeparator());
                    writer.write((String) tabelModel.getValueAt(i, 2)); // data langkah
                    writer.write(System.lineSeparator());
                    writer.write("---");
                    writer.write(System.lineSeparator());
                }
                JOptionPane.showMessageDialog(this, "Data Berhasil diekspor!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }   catch (IOException ex){
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mengekspor data!", "Error", JOptionPane.ERROR_MESSAGE);
            }  
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNamaMasakan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaBahan = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaLangkah = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        btnImpor = new javax.swing.JButton();
        btnEkspor = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelMasakan = new javax.swing.JTable();
        jFileChooser1 = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Aplikasi Resep Masakan");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Resep Masakan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Nama Masakan");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Bahan-bahan");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Langkah-langkah");

        txtAreaBahan.setColumns(20);
        txtAreaBahan.setRows(5);
        jScrollPane1.setViewportView(txtAreaBahan);

        txtAreaLangkah.setColumns(20);
        txtAreaLangkah.setRows(5);
        jScrollPane2.setViewportView(txtAreaLangkah);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNamaMasakan, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1009, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNamaMasakan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel3)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel4)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));

        btnTambah.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnTambah.setText("Tambah Resep");

        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnEdit.setText("Edit Resep");

        btnHapus.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnHapus.setText("Hapus Resep");

        btnKeluar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        btnImpor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnImpor.setText("Impor Data");

        btnEkspor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnEkspor.setText("Ekspor Data");
        btnEkspor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEksporActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnTambah)
                .addGap(111, 111, 111)
                .addComponent(btnEdit)
                .addGap(110, 110, 110)
                .addComponent(btnHapus)
                .addGap(116, 116, 116)
                .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(btnEkspor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnImpor)
                .addGap(46, 46, 46))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImpor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEkspor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tabelMasakan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tabelMasakan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
               // TODO add your handling code here:
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnEksporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEksporActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEksporActionPerformed

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
            java.util.logging.Logger.getLogger(ResepMasakanFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResepMasakanFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResepMasakanFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResepMasakanFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResepMasakanFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEkspor;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnImpor;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnTambah;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelMasakan;
    private javax.swing.JTextArea txtAreaBahan;
    private javax.swing.JTextArea txtAreaLangkah;
    private javax.swing.JTextField txtNamaMasakan;
    // End of variables declaration//GEN-END:variables
}
