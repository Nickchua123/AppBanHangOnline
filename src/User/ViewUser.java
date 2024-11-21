package User;

import java.awt.Color;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.NguoiDung;
import model.SessionManager;

/**
 *
 * @author dungp
 */
public class ViewUser extends javax.swing.JPanel {
     private NguoiDung lsp = new NguoiDung();
     private Home mainForm;
     boolean a = false;
     boolean b = true;
     boolean[] isPasswordVisible = {false};
    boolean[] isPasswordVisible1 = {false};
    public ViewUser(Home mainForm) throws SQLException {
        this.mainForm = mainForm;
        initComponents();
         XemNguoiDung();
        SetKhoa(a);
        
    }

    public void XemNguoiDung() throws SQLException{
      model.NguoiDung sp = new model.NguoiDung();
              String id = SessionManager.getId();
            sp = lsp.getNguoiDung(id);
            txtName.setText(sp.getTen());
            txtName.setDisabledTextColor(Color.BLACK);
            txtEmail.setText(sp.getEmail());
            txtEmail.setDisabledTextColor(Color.BLACK);;
            txtDc.setText(sp.getDc());
             txtDc.setDisabledTextColor(Color.BLACK);
            txtSdt.setText(sp.getSdt());
            txtSdt.setDisabledTextColor(Color.BLACK);
           
            
            
    }
    public void SetKhoa(boolean a){
        txtName.setEnabled(a);
        txtEmail.setEnabled(a);
        txtDc.setEnabled(a);
        txtPassword.setEnabled(a);
        txtPassword1.setEnabled(a);
        txtSdt.setEnabled(a);
        txtmbm.setEnabled(a);
        btKLuu.setEnabled(a);
        btLuu.setEnabled(a);
        
           
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
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
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btSua = new javax.swing.JButton();
        btLuu = new javax.swing.JButton();
        btKLuu = new javax.swing.JButton();
        lbTen = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        lbSdt = new javax.swing.JLabel();
        lbDc = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtPassword1 = new javax.swing.JPasswordField();
        lbIcon = new javax.swing.JLabel();
        lbIcon1 = new javax.swing.JLabel();
        lbBim = new javax.swing.JLabel();
        txtmbm = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel3.setPreferredSize(new java.awt.Dimension(927, 710));

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

        jLabel8.setText("Mật khẩu");

        jLabel9.setText("Nhập lại mật khẩu");

        btSua.setText("Sửa");
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });

        btLuu.setText("Lưu");
        btLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLuuActionPerformed(evt);
            }
        });

        btKLuu.setText("K.Lưu");
        btKLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKLuuActionPerformed(evt);
            }
        });

        lbTen.setForeground(new java.awt.Color(255, 0, 51));
        lbTen.setPreferredSize(new java.awt.Dimension(31, 16));

        lbEmail.setForeground(new java.awt.Color(255, 0, 51));
        lbEmail.setPreferredSize(new java.awt.Dimension(31, 16));

        lbSdt.setForeground(new java.awt.Color(255, 0, 51));
        lbSdt.setPreferredSize(new java.awt.Dimension(31, 16));

        lbDc.setForeground(new java.awt.Color(255, 0, 51));
        lbDc.setPreferredSize(new java.awt.Dimension(31, 16));

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hide.png"))); // NOI18N
        lbIcon.setPreferredSize(new java.awt.Dimension(43, 24));
        lbIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbIconMouseClicked(evt);
            }
        });

        lbIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hide.png"))); // NOI18N
        lbIcon1.setPreferredSize(new java.awt.Dimension(43, 24));
        lbIcon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbIcon1MouseClicked(evt);
            }
        });

        lbBim.setForeground(new java.awt.Color(255, 0, 51));
        lbBim.setPreferredSize(new java.awt.Dimension(31, 16));

        txtmbm.setPreferredSize(new java.awt.Dimension(64, 35));

        jLabel10.setText("Mã bảo mật");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSdt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(307, 307, 307))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbBim, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmbm, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lbMkl, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbMk, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(btSua)
                                .addGap(32, 32, 32)
                                .addComponent(btLuu)
                                .addGap(28, 28, 28)
                                .addComponent(btKLuu)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbDc, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(258, 258, 258))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel7)
                .addGap(6, 6, 6)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(txtDc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lbDc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtmbm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbBim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbIcon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(lbMkl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btKLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jScrollPane1.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        // TODO add your handling code here:
        SetKhoa(b);
        btSua.setEnabled(false); 
    }//GEN-LAST:event_btSuaActionPerformed

    private void btLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLuuActionPerformed
        // TODO add your handling code here:
          // TODO add your handling code here:
         String name = txtName.getText();
         String email = txtEmail.getText();
         String dc = txtDc.getText();
         String sdt = txtSdt.getText();
         String lever = "User";
         String password = new String(txtPassword.getPassword());
         String password1 = new String(txtPassword1.getPassword());
         String mbm = new String(txtmbm.getPassword());
         boolean validate = true;
         String nameRegex = "^[0-9a-zA-ZàáảãạâầấẩẫậăằắẳẵặèéẻẽẹêềếểễệìíỉĩịòóỏõọôồốổỗộơờớởỡợùúủũụưừứửữựỳýỷỹỵđĐÀÁẢÃẠÂẦẤẨẪẬĂẰẮẲẴẶÈÉẺẼẸÊỀẾỂỄỆÌÍỈĨỊÒÓỎÕỌÔỒỐỔỖỘƠỜỚỞỠỢÙÚỦŨỤƯỪỨỬỮỰỲÝỶỸỴ ]+$";
         String emailRegex = "^[a-zA-Z0-9](\\.?[a-zA-Z0-9]){5,29}@[a-zA-Z]+\\.[a-zA-Z]{2,4}$";
         String sdtRegex = "^\\+?\\d{9,15}$";
         String id = SessionManager.getId();
        
   // Kiểm tra Tên người dùng
   if(name.isEmpty()){
        lbTen.setText("Vui lòng nhập tên");
        lbTen.setIcon(new ImageIcon(getClass().getResource("/icon/error.png"))); 
        validate = false;
   }else  if (name.length() < 3 || name.length() > 50){
        lbTen.setText("Tên người dùng phải từ 3 đến 50 ký tự");
        lbTen.setIcon(new ImageIcon(getClass().getResource("/icon/error.png"))); 
        validate = false;
   }else if (!name.matches(nameRegex)){
       lbTen.setText("Tên người chỉ chứa chữ cái,số hoặc khoảng trắng.");
       lbTen.setIcon(new ImageIcon(getClass().getResource("/icon/error.png"))); 
       validate = false;
   }else {
       lbTen.setText("");
       lbTen.setIcon(null);
   }
   

// Kiểm tra Email    
    if (email.isEmpty()) {
       lbEmail.setText("Vui lòng nhập email");
       lbEmail.setIcon(new ImageIcon(getClass().getResource("/icon/error.png"))); 
       validate = false;
  } else if(!email.matches(emailRegex)){
       lbEmail.setText("Email không hợp Vd: Admin1@gmail.com");
       lbEmail.setIcon(new ImageIcon(getClass().getResource("/icon/error.png"))); 
       validate = false;
  } else{
       lbEmail.setText("");
       lbEmail.setIcon(null);
  }

// Kiểm tra Số điện thoại
    if(sdt.isEmpty()){
       lbSdt.setText("Vui lòng nhập số điện thoại");
       lbSdt.setIcon(new ImageIcon(getClass().getResource("/icon/error.png"))); 
       validate = false;
    }else if(!sdt.matches(sdtRegex)){
       lbSdt.setText("Số điện thoại phải chứa 9-15 ký tự số");
       lbSdt.setIcon(new ImageIcon(getClass().getResource("/icon/error.png"))); 
       validate = false;
    } else{
       lbSdt.setText("");
       lbSdt.setIcon(null);
    }


// Kiềm tra địa chỉ
    if(dc.isEmpty()){
       lbDc.setText("Vui lòng nhập địa chỉ");
       lbDc.setIcon(new ImageIcon(getClass().getResource("/icon/error.png"))); 
       validate = false;
    }else if(!dc.matches(nameRegex)){
       lbDc.setText("Địa chỉ chứa chữ hoa, chữ thường và số,dấu cách");
       lbDc.setIcon(new ImageIcon(getClass().getResource("/icon/error.png"))); 
       validate = false;
    } else{
       lbDc.setText("");
       lbDc.setIcon(null);
    }
   // Kiểm tra bí mật
    if(password.isEmpty()){
       lbBim.setText("Vui lòng nhập mã bí mật");
       lbBim.setIcon(new ImageIcon(getClass().getResource("/icon/error.png"))); 
       validate = false;
    }else if(password.length() < 4){
       lbBim.setText("Mã bí mật phải có ít nhất 4 ký tự");
       lbBim.setIcon(new ImageIcon(getClass().getResource("/icon/error.png")));       
    } else{
       lbBim.setText("");
       lbBim.setIcon(null);
    }   
// Kiểm tra Mật khẩu
    if(password.isEmpty()){
       lbMk.setText("Vui lòng nhập mật khẩu");
       lbMk.setIcon(new ImageIcon(getClass().getResource("/icon/error.png"))); 
       validate = false;
    }else if(password.length() < 8){
       lbMk.setText("Mật khẩu phải có ít nhất 8 ký tự");
       lbMk.setIcon(new ImageIcon(getClass().getResource("/icon/error.png"))); 
       validate = false;
    } else if(!password.matches(".*[A-Z].*")
            || !password.matches(".*[a-z].*") 
            || !password.matches(".*\\d.*") 
            || !password.matches(".*[!@#$%^&*].*")){
        lbMk.setText("Mật khẩu bao gồm chữ hoa, thường, số và ký tự đặc biệt");
        lbMk.setIcon(new ImageIcon(getClass().getResource("/icon/error.png"))); 
        validate = false;
        
    } else{
       lbMk.setText("");
       lbMk.setIcon(null);
    }

// Kiểm tra Nhập lại mật khẩu
     if (password1.isEmpty()) {
       lbMkl.setText("Vui lòng nhập lại mật khẩu");
       lbMkl.setIcon(new ImageIcon(getClass().getResource("/icon/error.png"))); 
       validate = false;
    } else if(!password.equals(password1)){
       lbMkl.setText("Mật khẩu nhập lại không khớp");
       lbMkl.setIcon(new ImageIcon(getClass().getResource("/icon/error.png"))); 
       validate = false;
    } else{
       lbMkl.setText("");
       lbMkl.setIcon(null);
    }
    if (!validate) {
    return;
    }
    
    try {
        // Tạo sản phẩm
        model.NguoiDung sp = new model.NguoiDung();
        sp.setTen(name);
        sp.setEmail(email);
        sp.setSdt(sdt);
        sp.setDc(dc);
        sp.setLever(lever);
        sp.setMk(password);
        sp.setMa(id);
        sp.setMbm(mbm);
        
         if (sp.EditData(sp)) {
        JOptionPane.showMessageDialog(this, "Cập nhật dữ liệu thành công"); 
         }
         else{
              JOptionPane.showMessageDialog(this, "Cập nhật dữ liệu thất bại"); 
         }
          SetKhoa(a);
          btSua.setEnabled(true);
          txtPassword.setText("");
          txtPassword1.setText("");
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    }//GEN-LAST:event_btLuuActionPerformed

    private void btKLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKLuuActionPerformed
        // TODO add your handling code here:
        SetKhoa(a);
       btSua.setEnabled(true);
       lbTen.setText("");
       lbTen.setIcon(null);
       lbDc.setText("");
       lbDc.setIcon(null);
       lbEmail.setText("");
       lbEmail.setIcon(null);
       lbSdt.setText("");
       lbSdt.setIcon(null);
       lbMk.setText("");
       lbMk.setIcon(null);
       lbMkl.setText("");
       lbMkl.setIcon(null);
    }//GEN-LAST:event_btKLuuActionPerformed

    private void lbIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbIconMouseClicked
        isPasswordVisible[0] = !isPasswordVisible[0];
        if (isPasswordVisible[0]) {
            txtPassword.setEchoChar((char) 0); // Hiển thị mật khẩu
            lbIcon.setIcon(new ImageIcon(getClass().getResource("/icon/show.png")));
        } else {
            txtPassword.setEchoChar('*'); // Ẩn mật khẩu
            lbIcon.setIcon(new ImageIcon(getClass().getResource("/icon/hide.png")));
        }
    }//GEN-LAST:event_lbIconMouseClicked

    private void lbIcon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbIcon1MouseClicked
        isPasswordVisible1[0] = !isPasswordVisible1[0];
        if (isPasswordVisible1[0]) {
            txtPassword1.setEchoChar((char) 0); // Hiển thị mật khẩu
            lbIcon1.setIcon(new ImageIcon(getClass().getResource("/icon/show.png")));
        } else {
            txtPassword1.setEchoChar('*'); // Ẩn mật khẩu
            lbIcon1.setIcon(new ImageIcon(getClass().getResource("/icon/hide.png")));
        }
    }//GEN-LAST:event_lbIcon1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btKLuu;
    private javax.swing.JButton btLuu;
    private javax.swing.JButton btSua;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBim;
    private javax.swing.JLabel lbDc;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbIcon1;
    private javax.swing.JLabel lbMk;
    private javax.swing.JLabel lbMkl;
    private javax.swing.JLabel lbSdt;
    private javax.swing.JLabel lbTen;
    private javax.swing.JTextField txtDc;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPassword1;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JPasswordField txtmbm;
    // End of variables declaration//GEN-END:variables
}
