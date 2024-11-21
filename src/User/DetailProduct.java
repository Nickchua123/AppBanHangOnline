
package User;

import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Product;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DetailProduct extends javax.swing.JPanel {
    private  Home mainForm;
    private Product lsp = new Product();
    public DetailProduct(Home mainForm) throws SQLException {
        this.mainForm = mainForm;
        initComponents();
        XemNguoiDung();
        SetKhoa();
    }
    public void XemNguoiDung() throws SQLException{
      model.Product sp = new model.Product();
              String id = (String) mainForm.getId();
              System.out.println("so id"+id);
    
            sp = lsp.getDetail(id);
            txtTen.setText(sp.getTen());
            txtDanhMuc.setText(sp.getTenDM());
            txtGia.setText(sp.getGia());
            txtSoLuongTK.setText(sp.getSoluong());
            txtMoTa.setText(sp.getMoTa());
            // Xử lý hiển thị ảnh sản phẩm
    String imagePath = sp.getImagle(); // Đường dẫn ảnh

    if (imagePath != null && !imagePath.isEmpty()) {
        try {
            // Tạo ImageIcon từ đường dẫn ảnh
            ImageIcon icon = new ImageIcon(imagePath);
            Image img = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            lbAnh.setIcon(new ImageIcon(img)); // Gán ảnh vào JLabel
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không thể tải ảnh từ đường dẫn: " + imagePath, 
                                          "Lỗi ảnh", JOptionPane.ERROR_MESSAGE);
            lbAnh.setIcon(null); // Xóa ảnh nếu có lỗi
        }
    } else {
        lbAnh.setIcon(null); // Xóa ảnh nếu không có đường dẫn
    }
      
            
    }
    private void SetKhoa(){
        txtDanhMuc.setEnabled(false);
        txtDanhMuc.setDisabledTextColor(Color.red);
        txtGia.setEnabled(false);
        txtGia.setDisabledTextColor(Color.red);
        txtMoTa.setEnabled(false);
        txtMoTa.setDisabledTextColor(Color.red);
        txtSoLuongTK.setEnabled(false);
        txtSoLuongTK.setDisabledTextColor(Color.red);
        txtTen.setEnabled(false);
        txtTen.setDisabledTextColor(Color.red);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDanhMuc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSoLuongTK = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lbAnh = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(927, 546));

        jPanel1.setPreferredSize(new java.awt.Dimension(927, 546));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tên sản phẩm");

        txtTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Giá");

        txtGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Mô tả ");

        txtDanhMuc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Danh mục");

        txtSoLuongTK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Số lượng tồn kho");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane1.setViewportView(txtMoTa);

        jButton1.setText("Quay lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(txtGia)
                            .addComponent(txtDanhMuc)
                            .addComponent(txtSoLuongTK)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(txtTen)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                        .addComponent(lbAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuongTK, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            mainForm.showTrangChu();
        } catch (SQLException ex) {
            Logger.getLogger(DetailProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAnh;
    private javax.swing.JTextField txtDanhMuc;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtSoLuongTK;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
