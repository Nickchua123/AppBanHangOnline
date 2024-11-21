
package Admin;

import Controller.Connect;
import java.awt.Image;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.NguoiDung;


public class AddUser extends javax.swing.JPanel {
    public Connect cn= new Connect();
    private NguoiDung lsp = new NguoiDung();
    private AdminDashboard mainAdmin;
    model.NguoiDung ng =new model.NguoiDung();
    boolean[] isPasswordVisible = {false};
    boolean[] isPasswordVisible1 = {false};
    private String imagle;
    
    public AddUser(AdminDashboard mainAdmin) {
        this.mainAdmin = mainAdmin;
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btThem = new javax.swing.JButton();
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
        txtLever = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btXoa = new javax.swing.JButton();
        btQuayLai = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtmbm = new javax.swing.JPasswordField();
        lbBim = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(840, 600));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel3.setPreferredSize(new java.awt.Dimension(840, 800));

        jLabel2.setText("Email");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.setPreferredSize(new java.awt.Dimension(331, 35));

        jLabel3.setText("Số điện thoại");

        btThem.setBackground(new java.awt.Color(0, 102, 102));
        btThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btThem.setForeground(new java.awt.Color(255, 255, 255));
        btThem.setText("Thêm");
        btThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
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

        txtLever.setBackground(new java.awt.Color(204, 204, 204));
        txtLever.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));

        jLabel6.setText("Lever");

        btXoa.setBackground(new java.awt.Color(0, 102, 102));
        btXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btXoa.setForeground(new java.awt.Color(255, 255, 255));
        btXoa.setText("Làm mới");
        btXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        btQuayLai.setText("Quay lại");
        btQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQuayLaiActionPerformed(evt);
            }
        });

        jLabel10.setText("Mã bảo mật");

        lbBim.setForeground(new java.awt.Color(255, 0, 51));
        lbBim.setPreferredSize(new java.awt.Dimension(31, 16));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTen, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDc, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtLever, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(lbIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbMkl, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMk, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lbBim, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtmbm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)))
                .addGap(0, 205, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btQuayLai)
                .addGap(8, 8, 8))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btQuayLai)
                .addGap(61, 61, 61)
                .addComponent(jLabel7)
                .addGap(6, 6, 6)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lbTen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lbSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(txtDc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lbDc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addComponent(txtLever, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtmbm, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbBim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel9)
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(lbMkl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        jScrollPane1.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        String name = txtName.getText();
        String email = txtEmail.getText();
        String password = new String(txtPassword.getPassword());
        String password1 = new String(txtPassword1.getPassword());
        String mbm = new String(txtmbm.getPassword());
        String sdt = txtSdt.getText();
        String dc = txtDc.getText();
        String lever =(String) txtLever.getSelectedItem();
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
    if(mbm.isEmpty()){
       lbBim.setText("Vui lòng nhập mã bí mật");
       lbBim.setIcon(new ImageIcon(getClass().getResource("/icon/error.png"))); 
       validate = false;
    }else if(mbm.length() < 4){
       lbBim.setText("Mã bí mật phải có ít nhất 4 ký tự");
       lbBim.setIcon(new ImageIcon(getClass().getResource("/icon/error.png")));
       validate = false;
       
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
    }//GEN-LAST:event_btThemActionPerformed
   
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

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        // TODO add your handling code here:
        txtName.setText("");
        txtDc.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        txtPassword1.setText("");
        txtSdt.setText("");
        txtmbm.setText("");
        lbTen.setText("");
        lbTen.setIcon(null);
        lbDc.setText("");
        lbDc.setIcon(null);
        lbEmail.setText("");
        lbEmail.setIcon(null);
        lbMk.setText("");
        lbMk.setIcon(null);
        lbMkl.setText("");
        lbMkl.setIcon(null);
        lbSdt.setText("");
        lbSdt.setIcon(null);
        lbBim.setText("");
        lbBim.setIcon(null);
        
        
    }//GEN-LAST:event_btXoaActionPerformed

    private void btQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQuayLaiActionPerformed
          try {
            mainAdmin.showNguoiDung();
        } catch (SQLException ex) {
            Logger.getLogger(QlViewUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btQuayLaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btQuayLai;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btXoa;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JComboBox<String> txtLever;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPassword1;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JPasswordField txtmbm;
    // End of variables declaration//GEN-END:variables
}
