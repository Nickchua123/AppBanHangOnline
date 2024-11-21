
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Order;



public class ViewOrder extends javax.swing.JPanel {
    private AdminDashboard mainframe;
    private TableRowSorter<DefaultTableModel> rowSorter;
    private model.Order lsp = new model.Order();
  
    private boolean cothem=true;
    private final DefaultTableModel tableModel = new DefaultTableModel(); 
    
   public ViewOrder(AdminDashboard mainframe) throws SQLException {
        this.mainframe = mainframe;
        initComponents();
        String []colsName = {"Ảnh", "Sản phẩm", "Số lượng", "Giá", "Tổng cộng"};
        // đặt tiêu đề cột cho tableModel
        tableModel.setColumnIdentifiers(colsName);
        // kết nối jtable với tableModel
        table.setModel(tableModel);
       
         // Thiết lập bộ lọc cho bảng
        rowSorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(rowSorter);
         //gọi hàm ShowData để đưa dữ liệu vào tableModel
        ShowData();
        InfoOder();
        setTable();
    }
public void ShowData() throws SQLException{
       tableModel.setRowCount(0);
         String id = (String) mainframe.getId();
        List<model.Order> lst = lsp.getDonHang(id);
        Object[] rows = new Object[5];
     
        for (model.Order sp : lst) { 
        rows[1] = sp.getTenSp();
        rows[2] = sp.getSl();
        rows[3] = sp.getGia();
        rows[4] = sp.getTt();
         String imagePath = sp.getImg(); // Giả sử getImagle trả về kiểu String (đường dẫn ảnh)

        if (imagePath != null && !imagePath.isEmpty()) {
            // Tạo ImageIcon từ đường dẫn
            ImageIcon icon = new ImageIcon(imagePath);
            
            // Đảm bảo rằng hình ảnh sẽ được hiển thị với kích thước cố định
            Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            table.getColumnModel().getColumn(0).setPreferredWidth(120); // hoặc bất kỳ độ rộng nào bạn mong muốn
            table.setRowHeight(100); // đặt chiều cao hàng thành 100 pixel

            rows[0] = new ImageIcon(img);
        } else {
            rows[0] = null; // Nếu không có ảnh
        }
        
        tableModel.addRow(rows);
        }
 table.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
        @Override
        public void setValue(Object value) {
            setIcon((value instanceof ImageIcon) ? (ImageIcon) value : null);
        }
    });
}
public void InfoOder(){
    Order sp = new Order();
              String id = (String) mainframe.getId();
              System.out.println("so id"+id);
        try {
            sp = lsp.getThongTin(id);
            lbTen.setText(sp.getTen());
            lbEmail.setText(sp.getEmail());
            lbDc.setText(sp.getDc());
            lbSdt.setText(sp.getSdt());
            lbPttt.setText(sp.getPttt());
            lbTttt.setText(sp.getTttt());
            
                    } catch (SQLException ex) {
            Logger.getLogger(ViewOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbTen = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        lbDc = new javax.swing.JLabel();
        lbTttt = new javax.swing.JLabel();
        lbPttt = new javax.swing.JLabel();
        lbSdt = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(840, 603));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setPreferredSize(new java.awt.Dimension(840, 836));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách đơn hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 51, 51))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(822, 265));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ảnh", "Sản phẩm", "Số lượng", "Giá", "Tổng cộng"
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin đơn hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 51, 51))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(855, 512));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Tên khách hàng");
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Email");
        jLabel2.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Số điện thoại");
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Dịa chỉ");
        jLabel4.setOpaque(true);

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Phương thức thanh toán");
        jLabel5.setOpaque(true);

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Trạng thái thanh toán");
        jLabel6.setOpaque(true);

        lbTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbTen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTen.setText("\n");
        lbTen.setPreferredSize(new java.awt.Dimension(0, 21));

        lbEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbEmail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbEmail.setText("\n");
        lbEmail.setPreferredSize(new java.awt.Dimension(0, 21));

        lbDc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbDc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbDc.setText("\n");
        lbDc.setPreferredSize(new java.awt.Dimension(0, 21));

        lbTttt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbTttt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTttt.setText(" ");
        lbTttt.setPreferredSize(new java.awt.Dimension(0, 21));

        lbPttt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbPttt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbPttt.setText("\n");
        lbPttt.setPreferredSize(new java.awt.Dimension(0, 21));

        lbSdt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbSdt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSdt.setText("\n");
        lbSdt.setPreferredSize(new java.awt.Dimension(0, 21));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTen, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(lbEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbDc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTttt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPttt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(203, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbDc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbPttt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbTttt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
private void setTable() {
    table.setRowHeight(100); // Đặt chiều cao của mỗi hàng là 100 pixels
    table.setFont(new Font("Arial", Font.PLAIN, 14));
    table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16)); // Font cho tiêu đề cột
    table.setSelectionBackground(new Color(173, 216, 230)); // Màu nền khi chọn hàng
    table.setSelectionForeground(Color.BLUE); // Màu chữ khi chọn hàng
    table.setShowGrid(false);
    table.setBorder(null); // Tắt đường viền ngoài của bảng 
    scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Xóa đường viền của JScrollPane

    // Thiết lập căn giữa cho tất cả các cột
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
                                                       boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Cài đặt màu nền xen kẽ cho các hàng, không mất màu khi chọn
            if (!isSelected) {
                c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(240, 240, 240));
            }

            // Căn giữa văn bản
            setHorizontalAlignment(JLabel.CENTER);
            return c;
        }
    };

    // Áp dụng renderer này cho tất cả các cột trong bảng
    for (int i = 0; i < table.getColumnCount(); i++) {
        table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDc;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbPttt;
    private javax.swing.JLabel lbSdt;
    private javax.swing.JLabel lbTen;
    private javax.swing.JLabel lbTttt;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    
}
