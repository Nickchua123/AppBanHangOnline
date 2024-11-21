
package Admin;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;


public class Product extends javax.swing.JPanel {
     private AdminDashboard mainframe;
     private TableRowSorter<DefaultTableModel> rowSorter;
      private model.Product lsp = new model.Product();
     private boolean cothem=true;
    private final DefaultTableModel tableModel = new DefaultTableModel(); 
     public Product(AdminDashboard mainframe) throws SQLException {
        this.mainframe = mainframe;
        initComponents();
        String []colsName = {"ID", "Ảnh", "Tên", "Giá", "Số lượng"};
        // đặt tiêu đề cột cho tableModel
        tableModel.setColumnIdentifiers(colsName);
        // kết nối jtable với tableModel
        table.setModel(tableModel);
       
         // Thiết lập bộ lọc cho bảng
        rowSorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(rowSorter);
         //gọi hàm ShowData để đưa dữ liệu vào tableModel
        ShowData();
        setTable();
    }
 public void ShowData() throws SQLException{
       tableModel.setRowCount(0);
       List<model.Product> lst= lsp.getSanPham();
        Object[] rows = new Object[5];
     
        for (model.Product sp : lst) { 
        rows[0] = sp.getMa();
        rows[2] = sp.getTen();
        rows[3] = sp.getGia();
        rows[4] = sp.getSoluong();
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
     

 private void setTable(){
        table.setRowHeight(100); // Đặt chiều cao của mỗi hàng là 25 pixels
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16)); // Font cho tiêu đề cột
        table.setSelectionBackground(new Color(173, 216, 230)); // Màu xanh nhạt// Màu nền khi chọn hàng
        table.setSelectionForeground(Color.BLUE);       // Màu chữ khi chọn hàng
        table.setShowGrid(false);
       scrollPane.setBorder(BorderFactory.createEmptyBorder());
        table.getColumnModel().getColumn(0).setPreferredWidth(10); 
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
     
// Phương thức tìm kiếm
    private void search(String keyword) { 
    // Nếu từ khóa không rỗng
    if (!keyword.isEmpty()) {
        // Định nghĩa bộ lọc chỉ áp dụng cho cột "ID" (cột 0) và "Tên" (cột 1)
        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + keyword, 0, 1);
        
        // Áp dụng bộ lọc lên RowSorter của bảng
        rowSorter.setRowFilter(rowFilter);
    } else {
        // Nếu từ khóa tìm kiếm rỗng, loại bỏ bộ lọc để hiển thị tất cả các hàng
        rowSorter.setRowFilter(null);
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btTim = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(247, 246, 249));
        setPreferredSize(new java.awt.Dimension(840, 600));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Sản phẩm");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Xem, thêm, sửa , xóa");

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thêm");
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
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(247, 246, 249));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên", "Giá", "Số lượng", "Ảnh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btTim)
                .addGap(28, 509, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearch)
                    .addComponent(btTim, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/price-tag (2).png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try {
             mainframe.showAddSanPham();
         } catch (SQLException ex) {
             Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void btTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimActionPerformed
        // TODO add your handling code here:
        String keyword = txtSearch.getText();
        search(keyword);
    }//GEN-LAST:event_btTimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btTim;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
