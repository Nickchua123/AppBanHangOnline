package Login;

import Controller.Connect;
import javax.swing.ImageIcon;
import model.NguoiDung;

public class SighUp extends javax.swing.JFrame {
    public Connect cn= new Connect();
    NguoiDung ng =new NguoiDung();
    boolean[] isPasswordVisible = {false};
    boolean[] isPasswordVisible1 = {false};



    public SighUp() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btSighUp = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btLogin = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPassword1 = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtSdt = new javax.swing.JTextField();
        lbIcon = new javax.swing.JLabel();
        lbIcon1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDc = new javax.swing.JTextField();
        lbTen = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        lbSdt = new javax.swing.JLabel();
        lbDc = new javax.swing.JLabel();
        lbMk = new javax.swing.JLabel();
        lbMkl = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbBim = new javax.swing.JLabel();
        txtmbm = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 600));
        jPanel1.setLayout(null);

        jPanel3.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Đăng ký");

        jLabel2.setText("Email");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.setPreferredSize(new java.awt.Dimension(331, 35));

        jLabel3.setText("Số điện thoại");

        btSighUp.setBackground(new java.awt.Color(0, 102, 102));
        btSighUp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btSighUp.setForeground(new java.awt.Color(255, 255, 255));
        btSighUp.setText("Đăng ký");
        btSighUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btSighUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSighUpActionPerformed(evt);
            }
        });

        jLabel4.setText("Bạn đã có tài khoản");

        btLogin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btLogin.setForeground(new java.awt.Color(255, 0, 0));
        btLogin.setText("Đăng nhập");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtName.setPreferredSize(new java.awt.Dimension(331, 35));

        jLabel7.setText("Tên người dùng");

        txtPassword1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPassword1.setPreferredSize(new java.awt.Dimension(331, 35));

        jLabel8.setText("Mật khẩu");

        jLabel9.setText("Nhập lại mật khẩu");

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPassword.setPreferredSize(new java.awt.Dimension(331, 35));

        txtSdt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSdt.setPreferredSize(new java.awt.Dimension(331, 35));

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

        jLabel5.setText("Địa chỉ");

        txtDc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDc.setPreferredSize(new java.awt.Dimension(331, 35));

        lbTen.setForeground(new java.awt.Color(255, 0, 51));
        lbTen.setPreferredSize(new java.awt.Dimension(31, 16));

        lbEmail.setForeground(new java.awt.Color(255, 0, 51));
        lbEmail.setPreferredSize(new java.awt.Dimension(31, 16));

        lbSdt.setForeground(new java.awt.Color(255, 0, 51));
        lbSdt.setPreferredSize(new java.awt.Dimension(31, 16));

        lbDc.setForeground(new java.awt.Color(255, 0, 51));
        lbDc.setPreferredSize(new java.awt.Dimension(31, 16));

        lbMk.setForeground(new java.awt.Color(255, 0, 51));
        lbMk.setPreferredSize(new java.awt.Dimension(31, 16));

        lbMkl.setForeground(new java.awt.Color(255, 0, 51));
        lbMkl.setPreferredSize(new java.awt.Dimension(31, 16));

        jLabel6.setText("Mã bảo mật");

        lbBim.setForeground(new java.awt.Color(255, 0, 51));
        lbBim.setPreferredSize(new java.awt.Dimension(31, 16));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel1))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbMk, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lbMkl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtPassword1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbDc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbSdt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSdt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lbEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lbBim, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(49, 49, 49))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btSighUp, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(lbTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtmbm))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTen, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtmbm, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbBim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbIcon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMkl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btSighUp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btLogin))
                .addGap(31, 31, 31))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 400, 760);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   

    private void btSighUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSighUpActionPerformed
    String name = txtName.getText();
    String email = txtEmail.getText();
    String password = new String(txtPassword.getPassword());
    String password1 = new String(txtPassword1.getPassword());
    String mbm = new String(txtmbm.getPassword());
    String sdt = txtSdt.getText();
    String dc = txtDc.getText();
    String lever = "User";
    String nameRegex = "^[a-zA-ZàáảãạâầấẩẫậăằắẳẵặèéẻẽẹêềếểễệìíỉĩịòóỏõọôồốổỗộơờớởỡợùúủũụưừứửữựỳýỷỹỵđĐÀÁẢÃẠÂẦẤẨẪẬĂẰẮẲẴẶÈÉẺẼẸÊỀẾỂỄỆÌÍỈĨỊÒÓỎÕỌÔỒỐỔỖỘƠỜỚỞỠỢÙÚỦŨỤƯỪỨỬỮỰỲÝỶỸỴ ]+$";
    String emailRegex = "^[a-zA-Z0-9](\\.?[a-zA-Z0-9]){5,29}@[a-zA-Z]+\\.[a-zA-Z]{2,4}$";
    String sdtRegex = "^\\+?\\d{9,15}$";
    Boolean validate = true;
   
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
   
         ng.insertData(name, email,sdt,dc,lever, password,mbm);
    }//GEN-LAST:event_btSighUpActionPerformed

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        // TODO add your handling code here:
         Login LoginFrame = new Login(); 
         LoginFrame.setVisible(true);      
         LoginFrame.pack();                
         LoginFrame.setLocationRelativeTo(null); 
         this.dispose();
    }//GEN-LAST:event_btLoginActionPerformed
      
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

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SighUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogin;
    private javax.swing.JButton btSighUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
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
