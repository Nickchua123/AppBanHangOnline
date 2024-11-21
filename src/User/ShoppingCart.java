
package User;

import Admin.Order;
import Controller.Connect;
import com.sun.jdi.connect.spi.Connection;
import java.awt.Color;
import java.awt.Component;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import model.Product;
import model.SessionManager;
import model.TableActionCellEditor;
import model.TableActionCellRender;
import model.TableActionEventGioHang;
public class ShoppingCart extends javax.swing.JPanel {
private final DefaultTableModel tableModel = new DefaultTableModel();
    private Model.GioHang gh = new Model.GioHang(); // Sử dụng Model.ShoppingCart bình thường.
     private TableRowSorter<DefaultTableModel> rowSorter;
    private Home mainForm;
    private Connect cn = new Connect();
    String idUser = SessionManager.getId();
    public ShoppingCart (Home mainForm) {
        this.mainForm =mainForm;
        initComponents();
        
        String[] colName = {"Id","Ảnh", "Sản phẩm", "Số lượng", "Thành tiền", "Thông tin"};
        tableModel.setColumnIdentifiers(colName);
        table.setModel(tableModel);
        rowSorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(rowSorter);
         TableActionEventGioHang event1 = new TableActionEventGioHang(){
            @Override
        public void Cong(int row) {
        String maSanPham = table.getValueAt(row, 0).toString();
        int currentQuantity = Integer.parseInt(table.getValueAt(row, 3).toString());
        int newQuantity = currentQuantity + 1; // Tăng số lượng
        if(gh.CheckSoLuong(maSanPham, newQuantity)==false){
            return;
        }        
        gh.updateCartQuantity(idUser,maSanPham, newQuantity); // Gửi số lượng mới
        table.setValueAt(newQuantity, row, 3); // Cập nhật trong bảng
        ShowData();
}

          @Override
         public void Tru(int row) {
        String maSanPham = table.getValueAt(row, 0).toString();
        int currentQuantity = Integer.parseInt(table.getValueAt(row, 3).toString());
    if (currentQuantity > 1) {
        int newQuantity = currentQuantity - 1; // Giảm số lượng
        table.setValueAt(newQuantity, row, 3); // Cập nhật trong bảng
        gh.updateCartQuantity(idUser,maSanPham, newQuantity); // Gửi số lượng mới
        ShowData();
    } else {
        if(table.isEditing()) {
             table.getCellEditor().stopCellEditing(); // Dừng chỉnh sửa nếu có
            }
             DefaultTableModel model = (DefaultTableModel) table.getModel();               
             // Lấy giá trị ID từ dòng sẽ xóa (sử dụng row thay vì getSelectedRow)
             Object id = table.getValueAt(row, 0);     
               
             try {
             // Gọi phương thức xóa dữ liệu trong cơ sở dữ liệu
              int confirm =JOptionPane.showConfirmDialog(null,"Xóa sản phẩm khỏi giỏ hàng?","Xác nhận",JOptionPane.YES_NO_OPTION);
              if(confirm == JOptionPane.YES_OPTION){
                   // Xóa dòng trong bảng
                    model.removeRow(row);  
                    gh.DeleteaData(idUser, (String) id);
              }
           
            } catch (SQLException ex) {
                ex.printStackTrace();
             }
    }
}

            @Override
            public void Xoa(int row) {
            if(table.isEditing()) {
             table.getCellEditor().stopCellEditing(); // Dừng chỉnh sửa nếu có
            }
             DefaultTableModel model = (DefaultTableModel) table.getModel();               
             // Lấy giá trị ID từ dòng sẽ xóa (sử dụng row thay vì getSelectedRow)
             Object id = table.getValueAt(row, 0);     
               
             try {
             // Gọi phương thức xóa dữ liệu trong cơ sở dữ liệu
              int confirm =JOptionPane.showConfirmDialog(null,"Xóa sản phẩm khỏi giỏ hàng?","Xác nhận",JOptionPane.YES_NO_OPTION);
              if(confirm == JOptionPane.YES_OPTION){
                   // Xóa dòng trong bảng
                    model.removeRow(row);  
                    gh.DeleteaData(idUser, (String) id);
              }
           
            } catch (SQLException ex) {
                ex.printStackTrace();
             }}

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
            }            }
             
             
             
          
        } ;
        
        table.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event1));
         table.setName("tableGioHang");
        ShowData();
        SetTable();
        lbTotal.setText(": " + tinhTongSoLuong());
    }
     private void ShowData() {
        tableModel.setRowCount(0);
        Object[] rows = new Object[5];
        List<Model.GioHang> lst = gh.GetGioHang(idUser); // Sử dụng dữ liệu từ Model.ShoppingCart.

        for (Model.GioHang sp : lst) { // Chú ý sử dụng Model.ShoppingCart ở đây.
            rows[0] = sp.getMaSp();
           rows[2] = "<html>" + sp.getTen() + "<br>" + sp.getGia() + "</html>";
            rows[3] = sp.getSoluong();
            rows[4] = sp.getTong();
            
                // Lấy đường dẫn ảnh từ cơ sở dữ liệu
        String imagePath = sp.getImg(); // Giả sử getImagle trả về kiểu String (đường dẫn ảnh)

        if (imagePath != null && !imagePath.isEmpty()) {
            // Tạo ImageIcon từ đường dẫn
            ImageIcon icon = new ImageIcon(imagePath);
            
            
            //Dieu Chinh kich thuoc
            

            // Đảm bảo rằng hình ảnh sẽ được hiển thị với kích thước cố định
            Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

            rows[1] = new ImageIcon(img);
        } else {
            rows[1] = null; // Nếu không có ảnh
        }
            tableModel.addRow(rows);
        }
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
          scrollPane.setBorder(BorderFactory.createEmptyBorder());
         table.getColumnModel().getColumn(0).setMinWidth(10);
         table.getColumnModel().getColumn(0).setPreferredWidth(25);
         table.getColumnModel().getColumn(0).setMaxWidth(100);
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
        lbTotal.setText(": " + tinhTongSoLuong());
    } else {        
        rowSorter.setRowFilter(null);
        lbTotal.setText(": " + tinhTongSoLuong());
    }
    }
   private int tinhTongSoLuong() {
    int tongSoLuong = 0;
    for (int i = 0; i < table.getRowCount(); i++) {
        // Lấy giá trị của cột "Số lượng" (giả sử cột số lượng ở vị trí 2)
        int soLuong = Integer.parseInt(table.getValueAt(i, 4).toString());
        tongSoLuong += soLuong; // Cộng dồn số lượng
    }
    return tongSoLuong;
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btTim = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        btThanhToan = new javax.swing.JButton();
        rdTienmat = new javax.swing.JRadioButton();
        rdChuyenkhoan = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setPreferredSize(new java.awt.Dimension(927, 546));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Ảnh", "Sản phẩm", "Số lượng", "Thành tiền", "Thông tin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(100);
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tổng tiền");

        lbTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btThanhToan.setBackground(new java.awt.Color(255, 102, 102));
        btThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btThanhToan.setText("Thanh toán");
        btThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThanhToanActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdTienmat);
        rdTienmat.setText("Tiền mặt");

        buttonGroup1.add(rdChuyenkhoan);
        rdChuyenkhoan.setText("Chuyển khoản");

        jLabel2.setText("Phương thức thanh toán");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btTim)
                                .addGap(125, 125, 125)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdTienmat)
                                        .addGap(31, 31, 31)
                                        .addComponent(rdChuyenkhoan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                                        .addComponent(btThanhToan))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(76, 76, 76))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btTim, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(txtSearch)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdTienmat)
                            .addComponent(rdChuyenkhoan))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
public boolean kiemTraGioHang(String maNguoiDung) {
     List<Model.GioHang> gioHang = gh.GetGioHang(maNguoiDung);  // Lấy giỏ hàng từ cơ sở dữ liệu
    if (gioHang.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Giỏ hàng trống!");
        return false;
    }
    
    return true;
}

    private void btTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimActionPerformed
        String keyword = txtSearch.getText();
        search(keyword);
    }//GEN-LAST:event_btTimActionPerformed

    private void btThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThanhToanActionPerformed
      if (!kiemTraGioHang(idUser)) {
    return;
}

// Lấy danh sách mã đơn hàng từ bảng
List<String> maDonHangs = new ArrayList<>();
for (int i = 0; i < table.getRowCount(); i++) {
    String maDonHang = table.getValueAt(i, 0).toString(); // Cột 0 chứa mã đơn hàng
    maDonHangs.add(maDonHang);
}

// Lấy phương thức thanh toán từ nhóm radio button
String phuongThucThanhToan;
String trangThaiTT;
if (rdTienmat.isSelected()) {
    phuongThucThanhToan = "Tiền mặt";
    trangThaiTT ="chờ xử lý";
} else if (rdChuyenkhoan.isSelected()) {
    phuongThucThanhToan = "Chuyển khoản";
    trangThaiTT ="đã thanh toán";
} else {
    JOptionPane.showMessageDialog(null, "Vui lòng chọn phương thức thanh toán!");
    return;
}

// Xác nhận thanh toán
int confirm = JOptionPane.showConfirmDialog(null, 
    "Bạn có chắc chắn muốn thanh toán giỏ hàng không?", 
    "Xác nhận thanh toán", 
    JOptionPane.YES_NO_OPTION);

if (confirm != JOptionPane.YES_OPTION) {
    return;
}

try {
    // Tạo kết nối cơ sở dữ liệu
    java.sql.Connection connection = cn.connectSQL();
    connection.setAutoCommit(false); // Bắt đầu transaction

    // Thêm thông tin đơn hàng vào bảng `DonHang`
    String sqlInsertDonHang = "INSERT INTO DonHang (ma_nguoi_dung, tong_tien, phuong_thuc_thanh_toan, trang_thai_thanh_toan) VALUES (?, ?, ?, ?);";
    PreparedStatement psDonHang = connection.prepareStatement(sqlInsertDonHang, java.sql.Statement.RETURN_GENERATED_KEYS);
    int tongTien = tinhTongSoLuong(); // Giả sử đây là tổng tiền của giỏ hàng
    psDonHang.setString(1, idUser);
    psDonHang.setInt(2, tongTien);
    psDonHang.setString(3, phuongThucThanhToan);
    psDonHang.setString(4, trangThaiTT);
    psDonHang.executeUpdate();

    // Lấy ID đơn hàng vừa tạo
    java.sql.ResultSet rs = psDonHang.getGeneratedKeys();
    rs.next();
    int idDonHang = rs.getInt(1);

    // Thêm chi tiết từng sản phẩm vào bảng `ChiTietDonHang`
    String sqlInsertChiTiet = "INSERT INTO ChiTietDonHang (ma_don_hang, ma_san_pham, so_luong, gia) VALUES (?, ?, ?, ?)";
    PreparedStatement psChiTiet = connection.prepareStatement(sqlInsertChiTiet);

    // Cập nhật số lượng tồn kho
    String sqlUpdateTonKho = "UPDATE SanPham SET so_luong_ton_kho = so_luong_ton_kho - ? WHERE ma_san_pham = ?";
    PreparedStatement psUpdateTonKho = connection.prepareStatement(sqlUpdateTonKho);

    for (int i = 0; i < table.getRowCount(); i++) {
        String maSanPham = table.getValueAt(i, 0).toString();
        int soLuong = Integer.parseInt(table.getValueAt(i, 3).toString());
        int thanhTien = Integer.parseInt(table.getValueAt(i, 4).toString());

        // Thêm chi tiết vào bảng `ChiTietDonHang`
        psChiTiet.setInt(1, idDonHang);
        psChiTiet.setString(2, maSanPham);
        psChiTiet.setInt(3, soLuong);
        psChiTiet.setInt(4, thanhTien);
        psChiTiet.addBatch();

        // Cập nhật tồn kho
        psUpdateTonKho.setInt(1, soLuong);
        psUpdateTonKho.setString(2, maSanPham);
        psUpdateTonKho.addBatch();
    }

    psChiTiet.executeBatch();
    psUpdateTonKho.executeBatch();

    // Cập nhật trạng thái thanh toán và phương thức thanh toán vào CSDL
    String sqlUpdateOrder = "UPDATE DonHang " +
                            "SET trang_thai_thanh_toan = ?, phuong_thuc_thanh_toan = ? " +
                            "WHERE ma_don_hang IN (%s)";

    // Tạo danh sách placeholders động
    String placeholders = String.join(", ", maDonHangs.stream().map(id -> "?").toList());
    sqlUpdateOrder = String.format(sqlUpdateOrder, placeholders);

    try (PreparedStatement pst = connection.prepareStatement(sqlUpdateOrder)) {
        pst.setString(1, "Đã thanh toán");
        pst.setString(2, phuongThucThanhToan);

        for (int i = 0; i < maDonHangs.size(); i++) {
            pst.setString(i + 3, maDonHangs.get(i));
        }
        pst.executeUpdate();
    }

    // Xóa giỏ hàng
    gh.ClearCart(idUser);

    // Commit transaction
    connection.commit();

    // Hiển thị thông báo và cập nhật giao diện
    JOptionPane.showMessageDialog(null, "Thanh toán thành công!");
    ShowData(); // Cập nhật lại bảng giỏ hàng
    lbTotal.setText(": 0"); // Cập nhật tổng tiền

} catch (Exception e) {
    e.printStackTrace();
}

    }//GEN-LAST:event_btThanhToanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btThanhToan;
    private javax.swing.JButton btTim;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JRadioButton rdChuyenkhoan;
    private javax.swing.JRadioButton rdTienmat;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
