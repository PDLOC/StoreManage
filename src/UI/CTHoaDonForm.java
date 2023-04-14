/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package UI;

import DAO.HoaDonChiTietDAO;
import DAO.hdct1DAO;
import ENTITY.ChiTietHoaDon;
import ENTITY.HoaDon;
import java.sql.*;
import java.text.NumberFormat;

import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen vu
 */
public class CTHoaDonForm extends javax.swing.JDialog {

    DefaultTableModel tblModel;
    Connection cnn;
    Statement st;
    HoaDonChiTietDAO dao1 = new HoaDonChiTietDAO();
      public static CTHoaDonForm hdn3;
    public JTextField txt1;
    

    /**
     * Creates new form
     */
    public CTHoaDonForm() {

        initComponents();

        setLocationRelativeTo(null);

        try {
 hdn3 = this;
            txt1 = txtma;
            String url = "jdbc:sqlserver://localhost:1433;databaseName=duan1;encrypt=true;trustServerCertificate=true;";
            String user = "edu";
            String pass = "123";
            cnn = DriverManager.getConnection(url, user, pass);
           
        } catch (SQLException ex) {
            System.out.println("loi kn");
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

        txtma = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        txtma.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtmaCaretUpdate(evt);
            }
        });
        txtma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Đơn giá"
            }
        ));
        tblDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDanhSachMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSach);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 730, 210));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CHI TIẾT HÓA ĐƠN");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(222, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaActionPerformed

    private void tblDanhSachMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachMousePressed
        // TODO add your handling code here:

//      int npp=1;

		
	// tạo 1 NumberFormat để định dạng tiền tệ theo tiêu chuẩn của Việt Nam
	// đơn vị tiền tệ của Việt Nam là đồng
	Locale localeVN = new Locale("vi", "VN");
	NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
	
        try {
            int i = tblDanhSach.getSelectedRow();
            String mahd = (String) tblDanhSach.getValueAt(i, 0);
            List<ChiTietHoaDon> list = dao1.selectByKeyword(mahd);
            String str3 = "Hóa Đơn Chi Tiết", str = "";
            int str1 = 0;
            long str2 = 0;
            for (ChiTietHoaDon ct : list) {

                str+= ct.getTenSP();
                str1+= ct.getSoLuong();
                str2+= ct.getTongtien();
            }
            JOptionPane.showMessageDialog(null, "Tổng Sản Phẩm Đã :\t " 
                    + str1 
                    + "\n" + "Sản Phẩm:\n"
                    + str + "Tổng Giá Tiền:\t" 
                    +currencyVN.format(str2),str3,-1);
          
      
        } catch (Exception e) {
            System.out.println(e);;
        }


    }//GEN-LAST:event_tblDanhSachMousePressed

    private void txtmaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtmaCaretUpdate
        // TODO add your handling code here:
         fillTable();
//          try {
//            String sql = ("select Ten from khachhang where MaKH=?");
//            PreparedStatement ps = cnn.prepareStatement(sql);
//            ps.setString(1, txtma.getText());
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                TxtTenKH.setText(rs.getString(1));
//            } else {
//
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Lỗi 101:: Không thể kết nối đến máy chủ" + ex);
//        }
    }//GEN-LAST:event_txtmaCaretUpdate

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
            java.util.logging.Logger.getLogger(CTHoaDonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CTHoaDonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CTHoaDonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CTHoaDonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CTHoaDonForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDanhSach;
    private javax.swing.JTextField txtma;
    // End of variables declaration//GEN-END:variables
     HoaDonChiTietDAO dao = new HoaDonChiTietDAO();

    void fillTable() {
        DefaultTableModel modelct = (DefaultTableModel) tblDanhSach.getModel();
        modelct.setRowCount(0);
        try {

            String keyword = txtma.getText();
            List<ChiTietHoaDon> list = dao.selectByKeyword(keyword);
            for (ChiTietHoaDon ct : list) {
                Object[] row = {
                    ct.getMaHD(),
                    ct.getMaSP(),
                    ct.getTenSP(),
                    ct.getSoLuong(),
                    ct.getTongtien()
                };
                modelct.addRow(row);
            }

        } catch (Exception e) {
            System.out.println(e);;
        }
    }
}