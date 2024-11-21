
package User;

import Admin.Order;
import Model.GioHang;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Category;
import model.Product;
import model.SessionManager;
import model.TableActionCellEditor;
import model.TableActionCellRender;
import model.TableActionEventHomeSales;

public class HomeSales extends javax.swing.JPanel {
 private final DefaultTableModel tableModel = new DefaultTableModel();
   private TableRowSorter<DefaultTableModel> rowSorter;
    private Product sp = new Product();
    private Home mainForm;
    public HomeSales(Home mainForm) throws SQLException {
     this.mainForm = mainForm;
        initComponents();
        
        
        String [] colsName ={"Id","Ảnh","Sản phẩm","Danh Mục", "Số lượng tồn kho","Số lượng chọn", "Thông tin"};
        tableModel.setColumnIdentifiers(colsName);
        table.setModel(tableModel);
        rowSorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(rowSorter);
        TableActionEventHomeSales event = new TableActionEventHomeSales() {
           @Override
            public void Cong(int row) {
                 // Lấy giá trị hiện tại trong cột "Số lượng chọn"
        int currentQuantity = Integer.parseInt(table.getValueAt(row, 5).toString());
        int maxQuantity = Integer.parseInt(table.getValueAt(row, 4).toString()); // Số lượng tồn kho

        // Kiểm tra giới hạn tồn kho
        if (currentQuantity < maxQuantity) {
            table.setValueAt(currentQuantity + 1, row, 5); // Tăng số lượng chọn
        } else {
            JOptionPane.showMessageDialog(null, "Không thể chọn nhiều hơn số lượng tồn kho!");
        }
        }
                
            @Override
            public void Tru(int row) {
                // Lấy giá trị hiện tại trong cột "Số lượng chọn"
        int currentQuantity = Integer.parseInt(table.getValueAt(row, 5).toString());

        // Kiểm tra giới hạn tối thiểu
        if (currentQuantity > 0) {
            table.setValueAt(currentQuantity - 1, row, 5); // Giảm số lượng chọn
        } else {
            JOptionPane.showMessageDialog(null, "Số lượng chọn không thể nhỏ hơn 0!");
        }
        }            

            @Override
            public void Add(int row) {
            String idpr= table.getValueAt(row, 0).toString();
            String sl= table.getValueAt(row, 5).toString(); // Số lượng tồn kho
            String id = SessionManager.getId();           
            if(sl.equals("0")){
                JOptionPane.showMessageDialog(null, "Số lượng sản phẩm phải lớn hơn không!","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
                GioHang gh = new GioHang();
                        
                
               try {
                   gh.addToCart(id,idpr, sl);
               } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null, "Lỗi khi thêm sản phẩm vào giỏ hàng!");
                   Logger.getLogger(HomeSales.class.getName()).log(Level.SEVERE, null, ex);
               }
               
}

         @Override
         public void Detail(int row) {
             int selectedRow = table.getSelectedRow(); // lấy hàng đang chọn
            if (selectedRow != -1) { // kiểm tra có hàng nào đang được chọn không
                Object id = table.getValueAt(selectedRow, 0); // giả sử cột 0 là ID
                
                // Lưu ID vào mainAdmin và hiển thị giao diện chi tiết đơn hàng
                mainForm.setId((String) id); // Đảm bảo setId() có tham số là kiểu Object hoặc đúng kiểu id
                try {
                    mainForm.showDetail();
                } catch (SQLException ex) {
                    Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng trước!");
            }
         }
               
        
        } ;
        table.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
        table.setName("tableHomeSales");
        System.out.println("Name: "+table.getName());
        ShowData();
        SetTable();
        populateComboBox();
        txtMaDm.setSelectedItem(""); // Đặt mục mặc định là rỗng
        txtMaDm.addActionListener(e -> searchByComboBox());

    }
private void ShowData() throws SQLException{
       tableModel.setRowCount(0);
       List<Product> lst= sp.getSanPham();
       Object [] rows = new Object[6];
       
       for(Product lt : lst){
           rows[0] = lt.getMa();
           rows[2] ="<html>" + lt.getTen() + "<br>" + lt.getGia() + "</html>";
           rows[3] = lt.getTenDM();
           rows[4] = lt.getSoluong();
           rows[5] = "0";
      
           
           // Lấy đường dẫn ảnh từ cơ sở dữ liệu
        String imagePath = lt.getImagle(); // Giả sử getImagle trả về kiểu String (đường dẫn ảnh)

        if (imagePath != null && !imagePath.isEmpty()) {
            // Tạo ImageIcon từ đường dẫn
            ImageIcon icon = new ImageIcon(imagePath);
            
            
            //Dieu Chinh kich thuoc
            

            // Đảm bảo rằng hình ảnh sẽ được hiển thị với kích thước cố định
            Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
          
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
    
    private void SetTable(){
        table.setRowHeight(120);
        table.setShowGrid(false);
 //        table.getColumnModel().getColumn(1).setCellRenderer(new MultiLineCellRenderer());
         table.getColumnModel().getColumn(0).setMinWidth(10);
         table.getColumnModel().getColumn(0).setPreferredWidth(30);
         table.getColumnModel().getColumn(0).setMaxWidth(100);
         table.getColumnModel().getColumn(1).setMinWidth(10);
         table.getColumnModel().getColumn(1).setPreferredWidth(100);
         table.getColumnModel().getColumn(1).setMaxWidth(100);
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
    private void search(String keyword) { 
    if (!keyword.isEmpty()) {      
        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + keyword, 0, 2);               
        rowSorter.setRowFilter(rowFilter);
    } else {        
        rowSorter.setRowFilter(null);
    }}
    private void searchByComboBox() {
    String selectedCategory = (String) txtMaDm.getSelectedItem(); // Lấy giá trị từ JComboBox

    if (selectedCategory != null && !selectedCategory.isEmpty()) {
        // Lọc theo danh mục (giả sử cột 1 chứa tên danh mục)
        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + selectedCategory, 3); 
        rowSorter.setRowFilter(rowFilter);
    } else {
        rowSorter.setRowFilter(null); // Hiển thị tất cả nếu không có danh mục
    }
}

    private void populateComboBox() {
    try {
        txtMaDm.removeAllItems(); 
        txtMaDm.addItem("");
        List<String> maDanhMucList = new Category().getAllTenDanhMuc();
        for (String ma : maDanhMucList) {
            txtMaDm.addItem(ma); 
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu mã danh mục",  "Thông báo", JOptionPane.ERROR_MESSAGE);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btTim = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        txtMaDm = new javax.swing.JComboBox<>();

        jPanel1.setPreferredSize(new java.awt.Dimension(927, 546));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Ảnh", "Sản phẩm", "Danh mục", "Số lượng tồn kho", "Số lượng", "Thông tin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(100);
        scrollPane.setViewportView(table);

        btTim.setBackground(new java.awt.Color(51, 51, 255));
        btTim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btTim.setForeground(new java.awt.Color(255, 255, 255));
        btTim.setText("Tìm");
        btTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btTim))
                    .addComponent(txtMaDm, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearch)
                    .addComponent(btTim, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaDm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimActionPerformed
        String keyword = txtSearch.getText();
        search(keyword);

    }//GEN-LAST:event_btTimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btTim;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable table;
    private javax.swing.JComboBox<String> txtMaDm;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
