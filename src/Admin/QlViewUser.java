
package Admin;

import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NguoiDung;

public class QlViewUser extends javax.swing.JPanel {
    private NguoiDung lsp = new NguoiDung();
    private AdminDashboard mainAdmin;
    boolean a = false;
    boolean b = true;
    public QlViewUser( AdminDashboard mainAdmin) throws SQLException {
         this.mainAdmin = mainAdmin;
        initComponents();
        XemNguoiDung();
        setKhoa(a);
    }

    public void XemNguoiDung() throws SQLException{
      model.NguoiDung sp = new model.NguoiDung();
              String id = (String) mainAdmin.getId();
              System.out.println("so id"+id);
    
            sp = lsp.getNguoiDung(id);
            txtName.setText(sp.getTen());
            txtName.setDisabledTextColor(Color.BLACK);
            txtEmail.setText(sp.getEmail());
            txtEmail.setDisabledTextColor(Color.BLACK);
            txtDc.setText(sp.getDc());
            txtDc.setDisabledTextColor(Color.BLACK);
            txtSdt.setText(sp.getSdt());
            txtSdt.setDisabledTextColor(Color.BLACK);
            txtLever.setSelectedItem(sp.getLever());
            
    }
    public void setKhoa(boolean a){
            txtName.setEnabled(a);
            txtDc.setEnabled(a);
            txtEmail.setEnabled(a);
            txtSdt.setEnabled(a);
            txtLever.setEnabled(a);
            
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDc = new javax.swing.JTextField();
        lbMk = new javax.swing.JLabel();
        lbMkl = new javax.swing.JLabel();
        btQuayLai = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtLever = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(840, 600));

        jPanel3.setPreferredSize(new java.awt.Dimension(840, 600));

        jLabel2.setText("Email");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.setPreferredSize(new java.awt.Dimension(331, 35));

        jLabel3.setText("Số điện thoại");

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtName.setPreferredSize(new java.awt.Dimension(331, 35));

        jLabel7.setText("Tên người dùng");

        txtSdt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSdt.setPreferredSize(new java.awt.Dimension(331, 35));

        jLabel5.setText("Địa chỉ");

        txtDc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDc.setPreferredSize(new java.awt.Dimension(331, 35));

        lbMk.setForeground(new java.awt.Color(255, 0, 51));
        lbMk.setPreferredSize(new java.awt.Dimension(31, 16));

        lbMkl.setForeground(new java.awt.Color(255, 0, 51));
        lbMkl.setPreferredSize(new java.awt.Dimension(31, 16));

        btQuayLai.setText("Quay lại");
        btQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQuayLaiActionPerformed(evt);
            }
        });

        jLabel6.setText("Lever");

        txtLever.setBackground(new java.awt.Color(204, 204, 204));
        txtLever.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btQuayLai)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMk, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMkl, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(479, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(txtLever, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(246, 246, 246))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btQuayLai)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(6, 6, 6)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(txtDc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addComponent(txtLever, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(294, 294, 294)
                .addComponent(lbMk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(lbMkl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQuayLaiActionPerformed
        try {
            mainAdmin.showNguoiDung();
        } catch (SQLException ex) {
            Logger.getLogger(QlViewUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btQuayLaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btQuayLai;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbMk;
    private javax.swing.JLabel lbMkl;
    private javax.swing.JTextField txtDc;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JComboBox<String> txtLever;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSdt;
    // End of variables declaration//GEN-END:variables
}
