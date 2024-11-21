package Admin;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.TableActionCellEditor;
import model.TableActionCellRender;
import model.TableActionEvent;
import model.TableActionEventNd;


public class User extends javax.swing.JPanel {
    private AdminDashboard mainAdmin;
    private TableRowSorter<DefaultTableModel> rowSorter;
    private final DefaultTableModel tableModel = new DefaultTableModel(); 
     private model.NguoiDung lsp = new model.NguoiDung();
    
    public User(AdminDashboard mainAdmin) throws SQLException {
        this.mainAdmin = mainAdmin;
        initComponents();
         String []colsName = {"ID", "Tên", "Email", "Lever","Thông tin"};
        tableModel.setColumnIdentifiers(colsName);       
        table.setModel(tableModel);
        rowSorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(rowSorter);
        
         TableActionEventNd event = new TableActionEventNd() {
        @Override
        public void Detail(int row) {
            int selectedRow = table.getSelectedRow(); // lấy hàng đang chọn
            if (selectedRow != -1) { // kiểm tra có hàng nào đang được chọn không
                Object id = table.getValueAt(selectedRow, 0); // giả sử cột 0 là ID
                
                // Lưu ID vào mainAdmin và hiển thị giao diện chi tiết đơn hàng
                mainAdmin.setId(id); // Đảm bảo setId() có tham số là kiểu Object hoặc đúng kiểu id
                
                try {
                    mainAdmin.showViewNguoiDung();
                } catch (SQLException ex) {
                    Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng trước!");
            }
        }

          @Override
        public void Delete(int row) {
             if(table.isEditing()) {
             table.getCellEditor().stopCellEditing(); // Dừng chỉnh sửa nếu có
            }

             DefaultTableModel model = (DefaultTableModel) table.getModel();
    
             // Lấy giá trị ID từ dòng sẽ xóa (sử dụng row thay vì getSelectedRow)
             Object id = table.getValueAt(row, 0); 
    
              // Xóa dòng trong bảng
              model.removeRow(row);
    
             try {
             // Gọi phương thức xóa dữ liệu trong cơ sở dữ liệu
             lsp.DeleteData((String) id);
    } catch (SQLException ex) {
        Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
    }
}


            @Override
            public void Edit(int row) {
               int selectedRow = table.getSelectedRow(); // lấy hàng đang chọn
            if (selectedRow != -1) { // kiểm tra có hàng nào đang được chọn không
                Object id = table.getValueAt(selectedRow, 0); // giả sử cột 0 là ID
                
                // Lưu ID vào mainAdmin và hiển thị giao diện chi tiết đơn hàng
                mainAdmin.setId(id); // Đảm bảo setId() có tham số là kiểu Object hoặc đúng kiểu id
                
                try {
                    mainAdmin.showEditNguoiDung();
                } catch (SQLException ex) {
                    Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng trước!");
            }
            }
    };

    table.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
    table.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
        ShowData();
        setTable();
    }
public void ShowData() throws SQLException{
       tableModel.setRowCount(0);
       List<model.NguoiDung> lst= lsp.getNguoiDung();
        Object[] rows = new Object[4];
     
        for (model.NguoiDung sp : lst) { 
        rows[0] = sp.getMa();
        rows[1] = sp.getTen();
        rows[2] = sp.getEmail();
        rows[3] = sp.getLever(); 
        tableModel.addRow(rows);   
    }
     
}
private void search(String keyword) { 
    if (!keyword.isEmpty()) {      
        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + keyword, 0, 1);               
        rowSorter.setRowFilter(rowFilter);
    } else {        
        rowSorter.setRowFilter(null);
    }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btThem = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btTim = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(247, 246, 249));
        jPanel2.setPreferredSize(new java.awt.Dimension(840, 600));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Người dùng");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Xem, thêm, sửa , xóa");

        btThem.setBackground(new java.awt.Color(51, 51, 255));
        btThem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btThem.setForeground(new java.awt.Color(255, 255, 255));
        btThem.setText("Thêm");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 419, Short.MAX_VALUE)
                .addComponent(btThem)
                .addGap(54, 54, 54))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(247, 246, 249));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên", "Email", "Lever", "Thông tin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(40);
        scrollPane.setViewportView(table);

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(153, 153, 153));

        btTim.setBackground(new java.awt.Color(51, 51, 255));
        btTim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btTim.setForeground(new java.awt.Color(255, 255, 255));
        btTim.setText("Tìm");
        btTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btTim)
                .addGap(28, 509, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearch)
                    .addComponent(btTim, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/price-tag (2).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        try {
            mainAdmin.showAddNguoiDung();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btThemActionPerformed

    private void btTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimActionPerformed
 String keyword = txtSearch.getText();
        search(keyword);
    }//GEN-LAST:event_btTimActionPerformed
private void setTable(){
        table.setRowHeight(40); // Đặt chiều cao của mỗi hàng là 25 pixels
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16)); // Font cho tiêu đề cột
        table.setSelectionBackground(new Color(173, 216, 230)); // Màu xanh nhạt// Màu nền khi chọn hàng
        table.setSelectionForeground(Color.BLUE);       // Màu chữ khi chọn hàng
        table.setShowGrid(false);
        table.setBorder(null);               // Tắt đường viền ngoài của bảng 
        scrollPane.setBorder(null); // Xóa đường viền của JScrollPane
       scrollPane.setBorder(BorderFactory.createEmptyBorder());
        table.getColumnModel().getColumn(0).setPreferredWidth(10); // Đặt độ rộng mặc định của cột ID là 30

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
    private javax.swing.JButton btThem;
    private javax.swing.JButton btTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
