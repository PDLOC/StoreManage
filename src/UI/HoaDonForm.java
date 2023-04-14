/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package UI;

import java.util.Locale;
import DAO.HoaDonChiTietDAO;
import DAO.hdct1DAO;
import ENTITY.ChiTietHoaDon;
import ENTITY.HoaDon;
import java.sql.*;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Admin
 */
public class HoaDonForm extends javax.swing.JInternalFrame {

    DefaultTableModel tblModel;
    Connection cnn;
    Statement st;
    HoaDonChiTietDAO dao1 = new HoaDonChiTietDAO();

    /**
     * Creates new form HoaDonForm1
     */
    public HoaDonForm() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=duan1;encrypt=true;trustServerCertificate=true;";
            String user = "edu";
            String pass = "123";
            cnn = DriverManager.getConnection(url, user, pass);
            fillTable();
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

        txtma1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        txtma = new javax.swing.JTextField();
        btntim = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDanhSachsp = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        txtma1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtma1CaretUpdate(evt);
            }
        });
        txtma1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtma1ActionPerformed(evt);
            }
        });

        setPreferredSize(new java.awt.Dimension(990, 690));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaActionPerformed(evt);
            }
        });
        jPanel1.add(txtma, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 790, 25));

        btntim.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btntim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/search.png"))); // NOI18N
        btntim.setText("Tìm");
        btntim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimActionPerformed(evt);
            }
        });
        jPanel1.add(btntim, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 118, -1));

        tblDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Tên Nhân Viên", "Tên Khách Hàng", "Tổng Tiền", "Ngày Lập Hóa Đơn"
            }
        ));
        tblDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDanhSachMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSach);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1000, 250));

        tblDanhSachsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Thành Tiền"
            }
        ));
        tblDanhSachsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDanhSachspMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblDanhSachsp);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 1000, 290));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 990, 620));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ HÓA ĐƠN");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(355, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaActionPerformed

    private void btntimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimActionPerformed
        // TODO add your handling code here:
        fillTable();
    }//GEN-LAST:event_btntimActionPerformed

    private void tblDanhSachMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachMousePressed
      
         
        try {
            int index = tblDanhSach.getSelectedRow();
            TableModel model = tblDanhSach.getModel();
            String id = (String) model.getValueAt(index, 0);

            txtma1.setText(id);

        } catch (Exception e) {
            System.out.println("fm" + e);
        }
    }//GEN-LAST:event_tblDanhSachMousePressed

    private void tblDanhSachspMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachspMousePressed
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

    }//GEN-LAST:event_tblDanhSachspMousePressed

    private void txtma1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtma1CaretUpdate
        // TODO add your handling code here:
        fillTableHoaDonCT();
        
    }//GEN-LAST:event_txtma1CaretUpdate

    private void txtma1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtma1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtma1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btntim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDanhSach;
    private javax.swing.JTable tblDanhSachsp;
    private javax.swing.JTextField txtma;
    private javax.swing.JTextField txtma1;
    // End of variables declaration//GEN-END:variables
    hdct1DAO dao = new hdct1DAO();

    void fillTable() {
        DefaultTableModel modelct = (DefaultTableModel) tblDanhSach.getModel();
        modelct.setRowCount(0);
        try {

            String keyword = txtma.getText();
            List<HoaDon> list = dao.selectByKeyword(keyword);
            for (HoaDon ct : list) {
                Object[] row = {
                    ct.getMahd(),
                    ct.getTennv(),
                    ct.getTenkh(),
                    ct.getThanhtien(),
                    ct.getNgaymua()
                };
                modelct.addRow(row);
            }

        } catch (Exception e) {
            System.out.println(e);;
        }
    }
     HoaDonChiTietDAO dao12 = new HoaDonChiTietDAO();

    void fillTableHoaDonCT() {
        DefaultTableModel modelct = (DefaultTableModel) tblDanhSachsp.getModel();
        modelct.setRowCount(0);
        try {

            String keyword = txtma1.getText();
            List<ChiTietHoaDon> list = dao12.selectByKeyword(keyword);
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