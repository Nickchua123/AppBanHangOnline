
package Admin;

import Login.Login;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.SessionManager;



public class AdminDashboard extends javax.swing.JFrame {
    private Object id ;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }
    
    public AdminDashboard() throws SQLException {
        initComponents();   
        showNguoiDung();
        PnNguoiDung.setBackground(new Color(60, 80, 100));
        lbHello.setText("Chào mừng "+SessionManager.getUsername());
    }

      // Hiển thị panel Product
    public void showSanPham() throws SQLException {
        main.removeAll();
        Product productPanel = new Product(this);  
        main.add(productPanel);
        main.revalidate();
        main.repaint();
    }

    // Hiển thị panel AddProduct
    public void showAddSanPham() throws SQLException {
        main.removeAll();
        AddProduct addSanPham = new AddProduct(this);  
        main.add(addSanPham);
        main.revalidate();
        main.repaint();
    }
    public void showDanhMuc() throws SQLException {
        main.removeAll();
        Category productPanel = new Category(this); 
        main.add(productPanel);
        main.revalidate();
        main.repaint();
    }

    // Hiển thị panel AddProduct
    public void showAddDanhMuc() throws SQLException {
        main.removeAll();
        AddCategory addDanhMuc = new AddCategory(this);  
        main.add(addDanhMuc);
        main.revalidate();
        main.repaint();
    }
    public void showNguoiDung() throws SQLException {
        main.removeAll();
        User productPanel = new User(this); 
        main.add(productPanel);
        main.revalidate();
        main.repaint();
    }

 
    public void showDonHang() throws SQLException {
        main.removeAll();
        Order addDanhMuc = new Order(this);  
        main.add(addDanhMuc);
        main.revalidate();
        main.repaint();
    }
    
    public void showViewDonHang() throws SQLException {
        main.removeAll();
        ViewOrder addDanhMuc = new ViewOrder(this);  
        main.add(addDanhMuc);
        main.revalidate();
        main.repaint();
    }
    public void showAddNguoiDung() throws SQLException {
        main.removeAll();
        AddUser addNd = new AddUser(this); 
        main.add(addNd);
        main.revalidate();
        main.repaint();
    }
    public void showViewNguoiDung() throws SQLException {
        main.removeAll();
        QlViewUser addNd = new QlViewUser(this); 
        main.add(addNd);
        main.revalidate();
        main.repaint();
    }
    public void showEditNguoiDung() throws SQLException {
        main.removeAll();
        EditUser addNd = new EditUser(this);  
        main.add(addNd);
        main.revalidate();
        main.repaint();
    }
    private void resetPanelBackgrounds() {
    PnNguoiDung.setBackground(new Color(42, 58, 73));
    PnDonHang.setBackground(new Color(42, 58, 73));
    PnSanPham.setBackground(new Color(42, 58, 73));
    PnLoai.setBackground(new Color(42, 58, 73));
    PnThongKe.setBackground(new Color(42, 58, 73));
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbHello = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        PnNguoiDung = new javax.swing.JPanel();
        lbNguoiDung = new javax.swing.JLabel();
        PnDonHang = new javax.swing.JPanel();
        lbDonHang = new javax.swing.JLabel();
        PnSanPham = new javax.swing.JPanel();
        lbSanPham = new javax.swing.JLabel();
        PnLoai = new javax.swing.JPanel();
        lbLoai = new javax.swing.JLabel();
        PnThongKe = new javax.swing.JPanel();
        lbThongKe = new javax.swing.JLabel();
        main = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(64, 194, 150));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ONLINE SHOPPING");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 440, 53));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/power.png"))); // NOI18N
        jLabel2.setText(" Đăng xuất");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 170, -1));

        lbHello.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHello.setForeground(new java.awt.Color(255, 255, 255));
        lbHello.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHello.setText("Admin@gmail.com");
        jPanel2.add(lbHello, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 27, 244, -1));

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

        PnNguoiDung.setBackground(new java.awt.Color(42, 58, 73));
        PnNguoiDung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PnNguoiDungMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PnNguoiDungMouseEntered(evt);
            }
        });
        PnNguoiDung.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbNguoiDung.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbNguoiDung.setForeground(new java.awt.Color(255, 255, 255));
        lbNguoiDung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N
        lbNguoiDung.setText("Người dùng");
        PnNguoiDung.add(lbNguoiDung, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 210, 50));

        jPanel3.add(PnNguoiDung, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 250, 50));

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

        lbDonHang.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbDonHang.setForeground(new java.awt.Color(255, 255, 255));
        lbDonHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/shop.png"))); // NOI18N
        lbDonHang.setText("Đơn hàng");
        PnDonHang.add(lbDonHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 210, 50));

        jPanel3.add(PnDonHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 250, 50));

        PnSanPham.setBackground(new java.awt.Color(42, 58, 73));
        PnSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PnSanPhamMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PnSanPhamMouseEntered(evt);
            }
        });
        PnSanPham.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbSanPham.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbSanPham.setForeground(new java.awt.Color(255, 255, 255));
        lbSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/product.png"))); // NOI18N
        lbSanPham.setText("Sản phẩm");
        PnSanPham.add(lbSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 210, 50));

        jPanel3.add(PnSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 250, 50));

        PnLoai.setBackground(new java.awt.Color(42, 58, 73));
        PnLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PnLoaiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PnLoaiMouseEntered(evt);
            }
        });
        PnLoai.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbLoai.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbLoai.setForeground(new java.awt.Color(255, 255, 255));
        lbLoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tag.png"))); // NOI18N
        lbLoai.setText("Danh mục");
        PnLoai.add(lbLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 210, 50));

        jPanel3.add(PnLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 250, 50));

        PnThongKe.setBackground(new java.awt.Color(42, 58, 73));
        PnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PnThongKeMouseEntered(evt);
            }
        });
        PnThongKe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbThongKe.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbThongKe.setForeground(new java.awt.Color(255, 255, 255));
        lbThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/trend.png"))); // NOI18N
        lbThongKe.setText("Thống kê");
        PnThongKe.add(lbThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 210, 50));

        jPanel3.add(PnThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 250, 50));

        main.setPreferredSize(new java.awt.Dimension(840, 603));
        main.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1097, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PnNguoiDungMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnNguoiDungMouseEntered
        // TODO add your handling code here:
         resetPanelBackgrounds();
         PnNguoiDung.setBackground(new Color(60, 80, 100));
    }//GEN-LAST:event_PnNguoiDungMouseEntered

    private void PnDonHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnDonHangMouseEntered
        // TODO add your handling code here:
         resetPanelBackgrounds();
        PnDonHang.setBackground(new Color(60, 80, 100));
    }//GEN-LAST:event_PnDonHangMouseEntered

    private void PnSanPhamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnSanPhamMouseEntered
        // TODO add your handling code here:
         resetPanelBackgrounds();
        PnSanPham.setBackground(new Color(60, 80, 100));
    }//GEN-LAST:event_PnSanPhamMouseEntered

    private void PnLoaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnLoaiMouseEntered
        // TODO add your handling code here:
         resetPanelBackgrounds();
        PnLoai.setBackground(new Color(60, 80, 100));
    }//GEN-LAST:event_PnLoaiMouseEntered

    private void PnThongKeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnThongKeMouseEntered
        // TODO add your handling code here:
         resetPanelBackgrounds();
         PnThongKe.setBackground(new Color(60, 80, 100));
    }//GEN-LAST:event_PnThongKeMouseEntered

    private void PnSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnSanPhamMouseClicked
        try {
            // TODO add your handling code here:
            showSanPham();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_PnSanPhamMouseClicked

    private void PnNguoiDungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnNguoiDungMouseClicked
         try {
        showNguoiDung();
        } catch (SQLException ex) {
        Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
  
    }//GEN-LAST:event_PnNguoiDungMouseClicked

    private void PnDonHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnDonHangMouseClicked
        try {
            // TODO add your handling code here:
            showDonHang();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PnDonHangMouseClicked

    private void PnLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnLoaiMouseClicked
        try {
            // TODO add your handling code here:
            showDanhMuc();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PnLoaiMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
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
    
   
    public static void main(String args[]) {
        

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AdminDashboard().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnDonHang;
    private javax.swing.JPanel PnLoai;
    private javax.swing.JPanel PnNguoiDung;
    private javax.swing.JPanel PnSanPham;
    private javax.swing.JPanel PnThongKe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbDonHang;
    private javax.swing.JLabel lbHello;
    private javax.swing.JLabel lbLoai;
    private javax.swing.JLabel lbNguoiDung;
    private javax.swing.JLabel lbSanPham;
    private javax.swing.JLabel lbThongKe;
    private javax.swing.JPanel main;
    // End of variables declaration//GEN-END:variables
}
