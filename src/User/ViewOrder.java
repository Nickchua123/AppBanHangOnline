
package User;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.SessionManager;
import model.Order;


public class ViewOrder extends javax.swing.JPanel {
   private final DefaultTableModel tableModel = new DefaultTableModel();
     private Home mainForm;
      private Order gh = new Order();
      String idUser = SessionManager.getId();
    public ViewOrder(Home mainForm) throws SQLException {
        this.mainForm = mainForm;
        initComponents();
           btInhoadon.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        inHoaDon();
    }
});
        String[] colName = {"Tên người dùng","Tên_sản_Phẩm", "số lượng", "thành_tiền", "Phương_thức_thanh_toán"};
        tableModel.setColumnIdentifiers(colName);
        table.setModel(tableModel);
        ShowData();
        setTable();
    }
     private void ShowData() throws SQLException {
        tableModel.setRowCount(0);
        Object[] rows = new Object[5];
        List<Order> lst = gh.getDonHang(idUser); // Sử dụng dữ liệu từ Model.GioHang.

        for (Order sp : lst) { // Chú ý sử dụng Model.GioHang ở đây.
            rows[0] = SessionManager.getUsername();
           rows[1] = sp.getTenSp();
            rows[3] = sp.getTt();
            rows[2] = sp.getSl();
            rows[4] = sp.getPttt();
             tableModel.addRow(rows);
              
    }}
    private void setTable(){
        table.setRowHeight(100); // Đặt chiều cao của mỗi hàng là 25 pixels
        table.setSelectionForeground(Color.BLUE);       // Màu chữ khi chọn hàng
        table.setShowGrid(false);
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
    private void inHoaDon() {
    int[] selectedRows = table.getSelectedRows();
    if (selectedRows.length == 0) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn ít nhất một đơn hàng để in hóa đơn.");
        return;
    }

    StringBuilder hoaDon = new StringBuilder();
    hoaDon.append("HÓA ĐƠN\n");
    hoaDon.append("-----------------------\n");

    for (int row : selectedRows) {
        Object tenNguoiDungObj = table.getValueAt(row, 0);
        Object tenSanPhamObj = table.getValueAt(row, 1);
        Object soLuongObj = table.getValueAt(row, 2);
        Object thanhTienObj = table.getValueAt(row, 3);
        Object phuongThucThanhToanObj = table.getValueAt(row, 4);

        // Kiểm tra các giá trị có null hay không
        String tenNguoiDung = (tenNguoiDungObj != null) ? tenNguoiDungObj.toString() : "Không có dữ liệu";
        String tenSanPham = (tenSanPhamObj != null) ? tenSanPhamObj.toString() : "Không có dữ liệu";
        String soLuong = (soLuongObj != null) ? soLuongObj.toString() : "Không có dữ liệu";
        String thanhTien = (thanhTienObj != null) ? thanhTienObj.toString() : "Không có dữ liệu";
        String phuongThucThanhToan = (phuongThucThanhToanObj != null) ? phuongThucThanhToanObj.toString() : "Không có dữ liệu";

        hoaDon.append("Tên người dùng: ").append(tenNguoiDung).append("\n");
        hoaDon.append("Tên sản phẩm: ").append(tenSanPham).append("\n");
        hoaDon.append("Số lượng: ").append(soLuong).append("\n");
        hoaDon.append("Thành tiền: ").append(thanhTien).append("\n");
        hoaDon.append("Phương thức thanh toán: ").append(phuongThucThanhToan).append("\n");
        hoaDon.append("-----------------------\n");
    }

    jTextArea1.setText(hoaDon.toString());
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btInhoadon = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jPanel1.setPreferredSize(new java.awt.Dimension(927, 546));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên người dùng", "Tên sản phẩm", "Giá", "Số lượng", "Phương thức thanh toán"
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

        btInhoadon.setBackground(new java.awt.Color(255, 102, 102));
        btInhoadon.setText("In hóa đơn");
        btInhoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInhoadonActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btInhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 171, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btInhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void btInhoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInhoadonActionPerformed
        try {
    if (jTextArea1.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Hóa đơn trống, không thể in!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }

    boolean isPrinted = jTextArea1.print(); // In toàn bộ nội dung JTextArea
    if (isPrinted) {
        JOptionPane.showMessageDialog(this, "In hóa đơn thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "In hóa đơn bị hủy!", "Thông báo", JOptionPane.WARNING_MESSAGE);
    }
} catch (PrinterException ex) {
    Logger.getLogger(ViewOrder.class.getName()).log(Level.SEVERE, null, ex);
    JOptionPane.showMessageDialog(this, "Lỗi in hóa đơn: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btInhoadonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btInhoadon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
