package User;

import Admin.Product;
import Login.Login;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.SessionManager;


public class Home extends javax.swing.JFrame {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Home() throws SQLException {
        initComponents();
        lbHello.setText("Chào mừng "+SessionManager.getUsername());
        showTrangChu();
        CheckSession();
         PnTrangChu.setBackground(new Color(60, 80, 100));
    }
    public void showTrangChu() throws SQLException {
        main.removeAll();
        HomeSales a = new HomeSales(this);  // Truyền JFrame vào Product
        main.add(a);
        main.revalidate();
        main.repaint();
    }
    
     public void showGioHang() throws SQLException {
        main.removeAll();
        ShoppingCart a = new ShoppingCart(this);  // Truyền JFrame vào Product
        main.add(a);
        main.revalidate();
        main.repaint();
    }
     
     public void showDetail() throws SQLException {
        main.removeAll();
        DetailProduct a = new DetailProduct(this);  // Truyền JFrame vào Product
        main.add(a);
        main.revalidate();
        main.repaint();
    }
     public void showDonHang() throws SQLException {
        main.removeAll();
        ViewOrder a = new ViewOrder(this);  // Truyền JFrame vào Product
        main.add(a);
        main.revalidate();
        main.repaint();
    }
    public void showViewUser() throws SQLException {
        main.removeAll();
        ViewUser a = new ViewUser(this);  // Truyền JFrame vào Product
        main.add(a);
        main.revalidate();
        main.repaint();
    }
    public void CheckSession(){
        if(SessionManager.getId()==null){
            int cos =JOptionPane.showConfirmDialog(this, "Bạn muốn đăng nhập không.","Cảnh báo",JOptionPane.YES_NO_OPTION);
            if(cos == JOptionPane.YES_OPTION ){
                Login a = new Login();
               a.setVisible(true);
                this.dispose();
            }
            else{
                 JOptionPane.getRootFrame().dispose();
            }
                
            }
    } 
     private void resetPanelBackgrounds() {
    PnDonHang.setBackground(new Color(42, 58, 73));
    PnGioHang.setBackground(new Color(42, 58, 73));
    PnTaiKhoan.setBackground(new Color(42, 58, 73));
    PnTrangChu.setBackground(new Color(42, 58, 73));
   
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        PnTrangChu = new javax.swing.JPanel();
        lbNguoiDung = new javax.swing.JLabel();
        PnGioHang = new javax.swing.JPanel();
        lbDonHang = new javax.swing.JLabel();
        PnDonHang = new javax.swing.JPanel();
        lbSanPham = new javax.swing.JLabel();
        PnTaiKhoan = new javax.swing.JPanel();
        lbLoai = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbHello = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        main = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(42, 58, 73));
        jPanel3.setPreferredSize(new java.awt.Dimension(251, 640));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText(" DASHBOARD");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 250, 50));

        PnTrangChu.setBackground(new java.awt.Color(42, 58, 73));
        PnTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PnTrangChuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PnTrangChuMouseEntered(evt);
            }
        });
        PnTrangChu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbNguoiDung.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbNguoiDung.setForeground(new java.awt.Color(255, 255, 255));
        lbNguoiDung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N
        lbNguoiDung.setText("Trang chủ");
        PnTrangChu.add(lbNguoiDung, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 210, 50));

        jPanel3.add(PnTrangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 250, 50));

        PnGioHang.setBackground(new java.awt.Color(42, 58, 73));
        PnGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PnGioHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PnGioHangMouseEntered(evt);
            }
        });
        PnGioHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbDonHang.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbDonHang.setForeground(new java.awt.Color(255, 255, 255));
        lbDonHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/shop.png"))); // NOI18N
        lbDonHang.setText("Giỏ hàng ");
        PnGioHang.add(lbDonHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 210, 50));

        jPanel3.add(PnGioHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 250, 50));

        PnDonHang.setBackground(new java.awt.Color(42, 58, 73));
        PnDonHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PnDonHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PnDonHangMouseEntered(evt);
            }
        });
        PnDonHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbSanPham.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbSanPham.setForeground(new java.awt.Color(255, 255, 255));
        lbSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/product.png"))); // NOI18N
        lbSanPham.setText("Đơn hàng");
        PnDonHang.add(lbSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 210, 50));

        jPanel3.add(PnDonHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 250, 50));

        PnTaiKhoan.setBackground(new java.awt.Color(42, 58, 73));
        PnTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PnTaiKhoanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PnTaiKhoanMouseEntered(evt);
            }
        });
        PnTaiKhoan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbLoai.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbLoai.setForeground(new java.awt.Color(255, 255, 255));
        lbLoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tag.png"))); // NOI18N
        lbLoai.setText("Tài khoản");
        PnTaiKhoan.add(lbLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 210, 50));

        jPanel3.add(PnTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 250, 50));

        jPanel2.setBackground(new java.awt.Color(64, 194, 150));
        jPanel2.setPreferredSize(new java.awt.Dimension(1184, 64));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ONLINE SHOPPING");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/power.png"))); // NOI18N
        jLabel2.setText("Đăng xuất");
        jLabel2.setPreferredSize(new java.awt.Dimension(50, 30));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        lbHello.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHello.setForeground(new java.awt.Color(255, 255, 255));
        lbHello.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHello.setPreferredSize(new java.awt.Dimension(120, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbHello, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lbHello, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        main.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                    .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PnTrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnTrangChuMouseClicked
        try {
            showTrangChu();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }//GEN-LAST:event_PnTrangChuMouseClicked

    private void PnGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnGioHangMouseClicked
        try {
            showGioHang();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PnGioHangMouseClicked

    private void PnDonHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnDonHangMouseClicked
        try {
            // TODO add your handling code here:
            showDonHang();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PnDonHangMouseClicked

    private void PnTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnTaiKhoanMouseClicked
        try {
            // TODO add your handling code here:
            showViewUser();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PnTaiKhoanMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
         int cos = JOptionPane.showConfirmDialog(null, "Bạn muốn đăng xuất không", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(cos == JOptionPane.YES_OPTION){
            Login lg = new Login();
            lg.setVisible(true);
            this.dispose();
            SessionManager.clearSession();
        }else{
            JOptionPane.getRootFrame().dispose();
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void PnTrangChuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnTrangChuMouseEntered
        // TODO add your handling code here:
        resetPanelBackgrounds();
        PnTrangChu.setBackground(new Color(60, 80, 100));
    }//GEN-LAST:event_PnTrangChuMouseEntered

    private void PnGioHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnGioHangMouseEntered
        // TODO add your handling code here:
        resetPanelBackgrounds();
        PnGioHang.setBackground(new Color(60, 80, 100));
    }//GEN-LAST:event_PnGioHangMouseEntered

    private void PnDonHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnDonHangMouseEntered
        // TODO add your handling code here:
         resetPanelBackgrounds();
        PnDonHang.setBackground(new Color(60, 80, 100));
    }//GEN-LAST:event_PnDonHangMouseEntered

    private void PnTaiKhoanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnTaiKhoanMouseEntered
        // TODO add your handling code here:
         resetPanelBackgrounds();
        PnTaiKhoan.setBackground(new Color(60, 80, 100));
    }//GEN-LAST:event_PnTaiKhoanMouseEntered

    
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Home().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnDonHang;
    private javax.swing.JPanel PnGioHang;
    private javax.swing.JPanel PnTaiKhoan;
    private javax.swing.JPanel PnTrangChu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbDonHang;
    private javax.swing.JLabel lbHello;
    private javax.swing.JLabel lbLoai;
    private javax.swing.JLabel lbNguoiDung;
    private javax.swing.JLabel lbSanPham;
    private javax.swing.JPanel main;
    // End of variables declaration//GEN-END:variables
}
