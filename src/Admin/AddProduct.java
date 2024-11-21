
package Admin;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Category;
import model.Product;

public class AddProduct extends javax.swing.JPanel {
    private AdminDashboard mainframe;
    private Product lsp = new Product();
    private String imagle;
    private final DefaultTableModel tableModel = new DefaultTableModel(); 
    
    public AddProduct(AdminDashboard mainframe) throws SQLException {
        this.mainframe = mainframe;
        initComponents();
       String []colsName = {"ID", "Ảnh","Tên", "Mô tả", "Giá", "Số lượng","Mã danh mục"};
        // đặt tiêu đề cột cho tableModel
        tableModel.setColumnIdentifiers(colsName);
        // kết nối jtable với tableModel
        table.setModel(tableModel);
        //gọi hàm ShowData để đưa dữ liệu vào tableModel
        ShowData();
        setKhoa(true);
         populateComboBox();
         setTable();
    }
     public void ShowData() throws SQLException{
       tableModel.setRowCount(0);
       List<Product> lst= lsp.getSanPham();
        Object[] rows = new Object[7];
     
        for (Product sp : lst) {
        rows[0] = sp.getMa();
        rows[2] = sp.getTen();
        rows[3] = sp.getMoTa();
        rows[4] = sp.getGia();
        rows[5] = sp.getSoluong();
        rows[6] = sp.getMaDM();
        // Lấy đường dẫn ảnh từ cơ sở dữ liệu
        String imagePath = sp.getImagle(); // Giả sử getImagle trả về kiểu String (đường dẫn ảnh)

        if (imagePath != null && !imagePath.isEmpty()) {
            // Tạo ImageIcon từ đường dẫn
            ImageIcon icon = new ImageIcon(imagePath);
           
            // Đảm bảo rằng hình ảnh sẽ được hiển thị với kích thước cố định
            Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            table.getColumnModel().getColumn(1).setPreferredWidth(120); // hoặc bất kỳ độ rộng nào bạn mong muốn
            table.setRowHeight(100); // đặt chiều cao hàng thành 100 pixel

            rows[1] = new ImageIcon(img);
        } else {
            rows[1] = null; // Nếu không có ảnh
        }
        
        tableModel.addRow(rows);
    }

    // Thiết lập bộ render cho cột ảnh
    table.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
        @Override
        public void setValue(Object value) {
            setIcon((value instanceof ImageIcon) ? (ImageIcon) value : null);
        }
    });
       

    
     
}
    public void setNull(){
        txtid.setText("");
        txtTen.setText("");
        txtMota.setText("");
        txtGia.setText("");
        txtSoluong.setText("");
        lbAnh.setIcon(null); 
    }
    
    private void setKhoa(boolean a){
        txtid.setEnabled(!a);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btThem = new javax.swing.JButton();
        btChonAnh = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbAnh = new javax.swing.JLabel();
        txtMaDm = new javax.swing.JComboBox<>();
        txtSoluong = new javax.swing.JTextField();
        btXoa = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        txtMota = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btReset = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(840, 603));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(840, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(840, 1200));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 51, 51))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(822, 600));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ảnh", "Tên", "Mô tả", "Giá", "Số lượng", "Mã danh mục"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(table);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thiết lập sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 51, 51))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(822, 600));
        jPanel3.setVerifyInputWhenFocusTarget(false);

        btThem.setText("Thêm");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btChonAnh.setText("Ảnh");
        btChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChonAnhActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Giá");

        lbAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbAnh.setOpaque(true);
        lbAnh.setPreferredSize(new java.awt.Dimension(300, 250));

        txtSoluong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btXoa.setText("Xóa");
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        btSua.setText("Sửa");
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });

        txtid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMota.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("ID");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Tên sản phẩm");

        btReset.setText("Làm mới");
        btReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResetActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mô tả");

        txtGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Số lượng");

        jLabel6.setText("Ma danh mục");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtid)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTen)
                            .addComponent(txtMota)
                            .addComponent(txtGia)
                            .addComponent(txtSoluong)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaDm, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btChonAnh)
                            .addComponent(lbAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btReset)
                .addGap(18, 18, 18)
                .addComponent(btThem)
                .addGap(18, 18, 18)
                .addComponent(btSua)
                .addGap(18, 18, 18)
                .addComponent(btXoa)
                .addGap(225, 225, 225))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel4))
                            .addComponent(lbAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(4, 4, 4)
                        .addComponent(txtMaDm, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btChonAnh))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThem)
                    .addComponent(btSua)
                    .addComponent(btXoa)
                    .addComponent(btReset))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void populateComboBox() {
    try {
        List<String> maDanhMucList = new Category().getAllMaDanhMuc();
        for (String ma : maDanhMucList) {
            txtMaDm.addItem(ma); // Thêm mã danh mục vào JComboBox
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu mã danh mục", "Thông báo", JOptionPane.ERROR_MESSAGE);
    }
}
    private void btChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChonAnhActionPerformed
       JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Chọn một ảnh");

    int result = fileChooser.showOpenDialog(null);
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        if (!selectedFile.exists() || !(selectedFile.getName().endsWith(".jpg") || 
                                      selectedFile.getName().endsWith(".jpeg") || 
                                      selectedFile.getName().endsWith(".png") || 
                                      selectedFile.getName().endsWith(".gif"))){
            JOptionPane.showMessageDialog(null, "File không hợp lệ. Vui lòng chọn file ảnh.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String fileName = selectedFile.getName();

        // Kiểm tra tên ảnh không có dấu tiếng Việt
        if (!fileName.matches("^[a-zA-Z0-9._-]+$")) {
            JOptionPane.showMessageDialog(null, "Tên ảnh không được chứa dấu tiếng Việt.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Nếu tên ảnh hợp lệ, tiến hành hiển thị ảnh
        ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
        imagle = selectedFile.getAbsolutePath(); // Lưu đường dẫn ảnh
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        lbAnh.setIcon(new ImageIcon(scaledImage));
    }
    }//GEN-LAST:event_btChonAnhActionPerformed

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
      String ten = txtTen.getText();
    String moTa = txtMota.getText();
    String gia = txtGia.getText();
    String soLuong = txtSoluong.getText();
    String regex = "^[0-9]+$";
    String id = txtid.getText();
    String MaDm = (String) txtMaDm.getSelectedItem();
    
    if (id.length()!=0) {
        JOptionPane.showMessageDialog(this, "Vui lòng ấn nút làm mới trước khi thêm thông tin.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (ten.isEmpty() || moTa.isEmpty() || gia.isEmpty() || soLuong.isEmpty() || imagle == null) {
        JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (!gia.matches(regex) || !soLuong.matches(regex)) {
        JOptionPane.showMessageDialog(this, "Vui lòng chỉ điền số cho giá và số lượng.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    try {
        // Tạo sản phẩm
        Product sp = new Product();
        sp.setTen(ten);
        sp.setMoTa(moTa);
        sp.setSoluong(soLuong);
        sp.setGia(gia);
        sp.setImagle(imagle);
        sp.setMaDM(MaDm);
        System.out.println(""+imagle);
         if (sp.InsertData(sp)) {
        JOptionPane.showMessageDialog(this, "Thêm dữ liệu thành công"); 
        ShowData();
         }
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    }//GEN-LAST:event_btThemActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
         txtid.setText(tableModel.getValueAt(selectedRow, 0).toString());
         txtTen.setText(tableModel.getValueAt(selectedRow, 2).toString());
         txtMota.setText(tableModel.getValueAt(selectedRow, 3).toString());
         txtGia.setText(tableModel.getValueAt(selectedRow, 4).toString());
         txtSoluong.setText(tableModel.getValueAt(selectedRow, 5).toString());
         txtMaDm.setSelectedItem(tableModel.getValueAt(selectedRow, 6).toString());
        
       
         
 // Lấy đối tượng từ cột 6 (ảnh)
        Object value = tableModel.getValueAt(selectedRow, 1);
        String id = (String) tableModel.getValueAt(selectedRow, 0);
            try {
                Product spd = lsp.getDetail(id);
                imagle = spd.getImagle();           
            } catch (SQLException ex) {
                Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        if (value instanceof ImageIcon) {
            ImageIcon imageIcon = (ImageIcon) value;                
             Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(lbAnh.getWidth(), lbAnh.getHeight(), Image.SCALE_SMOOTH);      
            lbAnh.setIcon(new ImageIcon(scaledImage)); // Đặt trực tiếp lên label
             
        } else {
            lbAnh.setIcon(null); // Nếu không có ảnh
        }
         
        }
    }//GEN-LAST:event_tableMouseClicked

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        // TODO add your handling code here:
         String ml=txtid.getText();
        try {
             if(ml.length()==0)
              JOptionPane.showMessageDialog(null,"Chon 1 loai SP de xoa", "Thong bao",1);
        else
             {
        if(JOptionPane.showConfirmDialog(null, "Ban muon xoa san pham nay hay khong? ","Thong bao",2)==0)
             {
              lsp.DeleteData(ml);//goi ham xoa du lieu theo ma loai
              ShowData();//Do du lieu vao table Model
              setNull();//Xoa trang Textfield
        }
        }
        }
        catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"Xóa thất bại","Thong bao",1);
        }
    }//GEN-LAST:event_btXoaActionPerformed

    private void btResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetActionPerformed
        // TODO add your handling code here:
        setNull();
    }//GEN-LAST:event_btResetActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        // TODO add your handling code here:
         String ten = txtTen.getText();
         String moTa = txtMota.getText();
         String gia = txtGia.getText();
         String soLuong = txtSoluong.getText();
         String id = txtid.getText();
         String MaDm = (String) txtMaDm.getSelectedItem();
    
    if (id.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần sửa", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (ten.isEmpty() || moTa.isEmpty() || gia.isEmpty() || soLuong.isEmpty() || imagle == null) {
        JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    try {
        // Tạo sản phẩm
        Product sp = new Product();
        sp.setTen(ten);
        sp.setMoTa(moTa);
        sp.setSoluong(soLuong);
        sp.setGia(gia);
        sp.setMa(id);
        sp.setMaDM(MaDm);
        sp.setImagle(imagle);
        
         if (sp.EditData(sp)) {
        JOptionPane.showMessageDialog(this, "Cập nhật dữ liệu thành công"); 
        ShowData();
         }
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    }//GEN-LAST:event_btSuaActionPerformed
    private void setTable(){
        table.setRowHeight(100); // Đặt chiều cao của mỗi hàng là 25 pixels
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16)); // Font cho tiêu đề cột
        table.setSelectionBackground(new Color(173, 216, 230)); // Màu xanh nhạt// Màu nền khi chọn hàng
        table.setSelectionForeground(Color.BLUE);       // Màu chữ khi chọn hàng
        table.setShowGrid(false);
       scrollPane.setBorder(BorderFactory.createEmptyBorder());
        table.getColumnModel().getColumn(0).setPreferredWidth(10); // Đặt độ rộng mặc định của cột ID là 30
        table.getColumnModel().getColumn(1).setMinWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setMaxWidth(100);
// Thiết lập màu nền xen kẽ cho các hàng trong bảng
    table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, 
                boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (!isSelected) {
    c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(240, 240, 240)); // Màu xen kẽ
}

            return c;
        }

           
    });


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btChonAnh;
    private javax.swing.JButton btReset;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbAnh;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtGia;
    private javax.swing.JComboBox<String> txtMaDm;
    private javax.swing.JTextField txtMota;
    private javax.swing.JTextField txtSoluong;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
