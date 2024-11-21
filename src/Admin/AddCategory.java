package Admin;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Category;

public class AddCategory extends javax.swing.JPanel {
    private boolean cothem=true;
    private AdminDashboard mainAdmin;
    private model.Category lsp = new model.Category();
    private final DefaultTableModel tableModel = new DefaultTableModel(); 
    public AddCategory( AdminDashboard mainAdmin) throws SQLException {
        this.mainAdmin =mainAdmin;
        initComponents();
        String []colsName = {"ID","Tên"};
        tableModel.setColumnIdentifiers(colsName);
        table.setModel(tableModel);
        ShowData();
        setNull();
        setKhoa(true);
        setButton(true);
        setTable();
    }

      public void ShowData() throws SQLException{
       tableModel.setRowCount(0);
       List<Category> lst= lsp.getDanhMuc();
        Object[] rows = new Object[2];
     
        for (Category sp : lst) {
        rows[0] = sp.getMa();
        rows[1] = sp.getTen();  
        tableModel.addRow(rows);  
        
    }
     
}
    public void setNull(){
        txtid.setText("");
        txtTen.setText("");
       
    }
    
    private void setKhoa(boolean a){
        txtid.setEnabled(!a);
        txtTen.setEnabled(!a);
    }
    private void setButton(boolean a)
{
   this.btThem. setEnabled (a);
   this.btXoa. setEnabled (a);
   this.btSua. setEnabled (a);
   this.btLuu. setEnabled (!a);
   this.btKLuu. setEnabled (!a);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        btThem = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        btKLuu = new javax.swing.JButton();
        btLuu = new javax.swing.JButton();
        lbMa = new javax.swing.JLabel();
        lbTen = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(840, 603));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(840, 600));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách danh mục", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 51, 51))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(822, 400));

        scrollPane.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Mã loại:");

        txtid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tên loại:");

        txtTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenActionPerformed(evt);
            }
        });

        btThem.setBackground(new java.awt.Color(64, 167, 69));
        btThem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btThem.setText("Thêm");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btXoa.setBackground(new java.awt.Color(64, 167, 69));
        btXoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btXoa.setText("Xóa");
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        btSua.setBackground(new java.awt.Color(64, 167, 69));
        btSua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btSua.setText("Sửa");
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });

        btKLuu.setBackground(new java.awt.Color(64, 167, 69));
        btKLuu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btKLuu.setText("K.Lưu");
        btKLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKLuuActionPerformed(evt);
            }
        });

        btLuu.setBackground(new java.awt.Color(64, 167, 69));
        btLuu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btLuu.setText("Lưu");
        btLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLuuActionPerformed(evt);
            }
        });

        lbMa.setForeground(new java.awt.Color(255, 0, 51));
        lbMa.setPreferredSize(new java.awt.Dimension(31, 16));

        lbTen.setForeground(new java.awt.Color(255, 0, 51));
        lbTen.setPreferredSize(new java.awt.Dimension(31, 16));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMa, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTen, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btThem)
                        .addGap(181, 181, 181)
                        .addComponent(btSua)
                        .addGap(60, 60, 60)
                        .addComponent(btLuu)
                        .addGap(74, 74, 74)
                        .addComponent(btKLuu))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(btXoa)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThem)
                    .addComponent(btXoa)
                    .addComponent(btSua)
                    .addComponent(btLuu)
                    .addComponent(btKLuu))
                .addGap(39, 39, 39)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Danh sách danh mục");
    }// </editor-fold>//GEN-END:initComponents

    private void btKLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKLuuActionPerformed
        // TODO add your handling code here:
        setNull();
        setKhoa(true);
        setButton(true);
        lbMa.setText("");
        lbMa.setIcon(null);
        lbTen.setText("");
        lbTen.setIcon(null);
    }//GEN-LAST:event_btKLuuActionPerformed

    private void btLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLuuActionPerformed
        // TODO add your handling code here:
        String ml=txtid.getText();
        String tl=txtTen.getText();
        String regexId = "^[a-z0-9A-Z]+$";
       String regexna = "^[0-9a-zA-ZàáảãạâầấẩẫậăằắẳẵặèéẻẽẹêềếểễệìíỉĩịòóỏõọôồốổỗộơờớởỡợùúủũụưừứửữựỳýỷỹỵđĐÀÁẢÃẠÂẦẤẨẪẬĂẰẮẲẴẶÈÉẺẼẸÊỀẾỂỄỆÌÍỈĨỊÒÓỎÕỌÔỒỐỔỖỘƠỜỚỞỠỢÙÚỦŨỤƯỪỨỬỮỰỲÝỶỸỴ ]+$";
        boolean validate = true; 
        
       if (ml.isEmpty()) {
            lbMa.setText("Vui lòng nhập ma");
            lbMa.setIcon(new ImageIcon(getClass().getResource("/icon/error.png"))); 
            validate = false;
        }else if(!ml.matches(regexId)){
            lbMa.setText("Mã chỉ có các ký tự số và chữ");
            lbMa.setIcon(new ImageIcon(getClass().getResource("/icon/error.png"))); 
            validate = false;
        } 
            else{
            lbMa.setText("");
            lbMa.setIcon(null);
        }
       
       if (tl.isEmpty()) {
            lbTen.setText("Vui lòng nhập ten");
            lbTen.setIcon(new ImageIcon(getClass().getResource("/icon/error.png"))); 
            validate = false;
        }else if(!tl.matches(regexna)){
            lbTen.setText("Tên không được chứa ký tự đặc biệt");
            lbTen.setIcon(new ImageIcon(getClass().getResource("/icon/error.png"))); 
            validate = false;
        } 
            else{
            lbTen.setText("");
            lbTen.setIcon(null);
        }
        
       if(validate == false){
           return;
       }
            try {
              
                Category obj = new Category();
                obj.setMa(ml);
                obj.setTen(tl);
                if (cothem == true) { 
                    if (lsp.isMaDanhMucExists(ml)) {
                        JOptionPane.showMessageDialog(null, "Mã danh mục đã tồn tại. Vui lòng nhập mã khác.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    } else {
                        lsp.InsertData(obj);
                        tableModel.setRowCount(0); 
                        ShowData(); 
                    }
                } else { 
                    lsp.EditData(obj);
                    tableModel.setRowCount(0); 
                    ShowData(); 
                }
            }
            catch (SQLException ex) { JOptionPane.showMessageDialog(null,"Cap nhat that bai", "Thong bao",1);
            }
            setKhoa(false);
            setButton(true);
            
        
    }//GEN-LAST:event_btLuuActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
      
        String ml=txtid.getText();
        if(ml.length()==0) 
        JOptionPane.showMessageDialog(null,"Vui long chon danh mục can sua","Thong bao",1);
        else
        {
            setKhoa(false);
            this.txtid.enable(false);
            setButton(false); 
            cothem=false; 
        }
    }//GEN-LAST:event_btSuaActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        // TODO add your handling code here:
        String ml=txtid.getText();
        try {
            if(ml.length()==0)
            JOptionPane.showMessageDialog(null,"Vui lòng chọn danh mục để xóa", "Thong bao",1);
            else
            {
                if(JOptionPane.showConfirmDialog(null, "Ban muon xoa danh muc  " + ml + " nay hay khong?","Thong bao",2)==0)
                {
                    lsp.DeleteData(ml);
                    tableModel.setRowCount(0);
                    ShowData();
                    setNull();
                }
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Xóa thất bại","Thong bao",1);
        }
    }//GEN-LAST:event_btXoaActionPerformed

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        
        setNull();
        setKhoa(false);
        setButton(false);
        cothem=true;
    }//GEN-LAST:event_btThemActionPerformed

    private void txtTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenActionPerformed
       
    }//GEN-LAST:event_txtTenActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            txtid.setText(tableModel.getValueAt(selectedRow, 0).toString());
            txtTen.setText(tableModel.getValueAt(selectedRow, 1).toString());
        }
    }//GEN-LAST:event_tableMouseClicked
  private void setTable(){
        table.setRowHeight(25); 
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        table.setSelectionBackground(new Color(173, 216, 230)); 
        table.setSelectionForeground(Color.BLUE);       
        table.setShowGrid(false);
        table.setBorder(null);           
        scrollPane.setBorder(null); 
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
       
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
    private javax.swing.JButton btKLuu;
    private javax.swing.JButton btLuu;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbMa;
    private javax.swing.JLabel lbTen;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
