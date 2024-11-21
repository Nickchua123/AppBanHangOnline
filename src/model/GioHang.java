
package Model;

import Controller.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class GioHang {
    private String maSp;
    private String Soluong;
    private String img;
    private String ten;
    private String gia;
    private String tong;
    private String pttt;

    public String getPttt() {
        return pttt;
    }

    public void setPttt(String pttt) {
        this.pttt = pttt;
    }

    public String getTong() {
        return tong;
    }

    public void setTong(String tong) {
        this.tong = tong;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
    Connect cn = new Connect();

    public Connect getCn() {
        return cn;
    }

    public void setCn(Connect cn) {
        this.cn = cn;
    }

    public GioHang() {
    }

    public GioHang(String maSp, String Soluong) {
        this.maSp = maSp;
        this.Soluong = Soluong;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getSoluong() {
        return Soluong;
    }

    public void setSoluong(String Soluong) {
        this.Soluong = Soluong;
    }
    
//HamThem 
  public boolean CheckGioHang ( String userId,String productId) throws SQLException {    //String userId,
       String query = "SELECT COUNT(*) FROM GioHang WHERE ma_nguoi_dung = ? AND  ma_san_pham = ?"; //ma_nguoi_dung = ? AND
    
    try (   Connection conn = cn.connectSQL();
            PreparedStatement ps = conn.prepareStatement(query)) {
        ps.setString(1, userId); // Mã người dùng
        ps.setString(2, productId); // Mã sản phẩm
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0; // Trả về true nếu sản phẩm đã tồn tại
        }
    }
    return false; // Không tìm thấy sản phẩm
}

  public void addToCart(String userId, String productId, String quantity) throws SQLException {  //
    if (CheckGioHang( userId,productId)) {                                //              
        // Sản phẩm đã tồn tại -> Cập nhật số lượng
        int quantityInt = Integer.parseInt(quantity);
        if(CheckSoLuongTrongGioHang(userId,productId, quantityInt)){
            String updateQuery = "UPDATE GioHang SET so_luong = so_luong + ? WHERE ma_nguoi_dung = ? AND  ma_san_pham = ?";  //
        try (   Connection connection = cn.connectSQL();
                PreparedStatement ps = connection.prepareStatement(updateQuery)) {
            ps.setString(1, quantity);
            ps.setString(2, userId);
            ps.setString(3, productId);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null,"Cập nhật số lượng sản phẩm trong giỏ hàng thành công.");
            //    System.out.println("Cập nhật số lượng sản phẩm trong giỏ hàng thành công.");
            } else {
                JOptionPane.showMessageDialog(null,"Cập nhật số lượng thất bại.");
            }
        }
        }
        
    } else {
        // Sản phẩm chưa tồn tại -> Thêm mới
        String insertQuery = "INSERT INTO GioHang (ma_nguoi_dung, ma_san_pham, so_luong) VALUES (?, ?, ?)"; //
        try (    Connection connection = cn.connectSQL();
                PreparedStatement ps = connection.prepareStatement(insertQuery)) {
            ps.setString(1, userId);
            ps.setString(2, productId);
            ps.setString(3, quantity);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                 JOptionPane.showMessageDialog(null,"Thêm sản phẩm vào giỏ hàng thành công.");
            } else {
                 JOptionPane.showMessageDialog(null,"Thêm vào giỏ hàng thất bại.");
            }
        }
    }
}

public List<GioHang> GetGioHang(String userId) {
    List<GioHang> lists = new ArrayList<>();
    String sql = "SELECT " +
            "    GioHang.ma_nguoi_dung, " +
            "    GioHang.ma_san_pham, " +
            "    SanPham.imagle, " +
            "    SanPham.ten_san_pham, " +
            "    SanPham.gia, " +
            "    GioHang.so_luong, " +
            "    SanPham.gia * GioHang.so_luong AS tong_cong " +
            "FROM " +
            "    GioHang " +
            "JOIN " +
            "    SanPham " +
            "ON " +
            "    SanPham.ma_san_pham = GioHang.ma_san_pham " +
            "WHERE " +
            "    GioHang.ma_nguoi_dung = ?";

    try (Connection conn = cn.connectSQL();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        // Gán giá trị cho tham số
        ps.setString(1, userId);

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                GioHang sp = new GioHang();
                sp.setImg(rs.getString("imagle"));
                sp.setTen(rs.getString("ten_san_pham"));
                sp.setGia(rs.getString("gia"));
                sp.setSoluong(rs.getString("so_luong"));
                sp.setTong(rs.getString("tong_cong"));
                sp.setMaSp(rs.getString("ma_san_pham"));
                lists.add(sp);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lists;
}

public boolean DeleteaData(String maNguoiDung, String productId) throws SQLException {
    // SQL để xóa sản phẩm khỏi giỏ hàng của người dùng cụ thể
    String sql = "DELETE FROM GioHang WHERE ma_san_pham = ? AND ma_nguoi_dung = ?";
    try (Connection connection = cn.connectSQL();
         PreparedStatement ps = connection.prepareStatement(sql)) {
         
        // Thiết lập tham số
        ps.setString(1, productId);     // Mã sản phẩm
        ps.setString(2, maNguoiDung);  // Mã người dùng
        
        // Thực thi câu lệnh SQL
        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0; // Trả về true nếu xóa thành công
    }
}


public boolean CheckSoLuong(String maSanPham, int soLuong) {
    String sql = "SELECT so_luong_ton_kho FROM SanPham WHERE ma_san_pham = ?";
    try (Connection conn = cn.connectSQL();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, maSanPham);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int soLuongTonKho = rs.getInt("so_luong_ton_kho");
            if (soLuong <= soLuongTonKho) {
                return true; // Đủ tồn kho
            } else {
                JOptionPane.showMessageDialog(null, "Số lượng vượt quá tồn kho! Tồn kho hiện tại: " + soLuongTonKho);
            }
        } 
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false; // Không đủ tồn kho hoặc xảy ra lỗi
}


public void updateCartQuantity(String maNguoiDung, String maSanPham, int soLuong) {
    if (CheckSoLuong(maSanPham, soLuong)) {
        String sql = "UPDATE GioHang SET so_luong = ? WHERE ma_san_pham = ? AND ma_nguoi_dung = ?";
        
        try (Connection conn = cn.connectSQL();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Thiết lập các tham số trong câu lệnh SQL
            ps.setInt(1, soLuong);           // Cập nhật số lượng
            ps.setString(2, maSanPham);     // Sản phẩm cần cập nhật
            ps.setString(3, maNguoiDung);   // Người dùng hiện tại
            
            // Thực thi câu lệnh SQL
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật số lượng thành công!");
            } else {
                System.out.println("Không có thay đổi nào được thực hiện.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public boolean CheckSoLuongTrongGioHang(String maNguoiDung, String maSanPham, int soLuongThem) {
    int soLuongHienTaiTrongGioHang = getSoLuongHienTaiTrongGioHang(maNguoiDung, maSanPham);
    int tongSoLuong = soLuongHienTaiTrongGioHang + soLuongThem;
    String sql = "SELECT so_luong_ton_kho FROM SanPham WHERE ma_san_pham = ?";
    try (Connection conn = cn.connectSQL();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, maSanPham);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int soLuongTonKho = rs.getInt("so_luong_ton_kho");
                if (tongSoLuong <= soLuongTonKho) {
                    return true; // Số lượng hợp lệ
                } else {
                    JOptionPane.showMessageDialog(
                        null,
                        "Tổng số lượng sản phẩm trong giỏ và thêm vào (" + tongSoLuong +
                        ") vượt quá tồn kho (" + soLuongTonKho + ").",
                        "Lỗi vượt quá tồn kho",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
 
    return false; // Trả về false nếu không tìm thấy sản phẩm hoặc lỗi
}

private int getSoLuongHienTaiTrongGioHang(String maNguoiDung, String maSanPham) {
    String sql = "SELECT so_luong FROM GioHang WHERE ma_nguoi_dung = ? AND ma_san_pham = ?";
    try (Connection conn = cn.connectSQL();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, maNguoiDung);
        ps.setString(2, maSanPham);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("so_luong");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return 0; // Nếu không có sản phẩm trong giỏ, trả về 0
}

public boolean AddDetailDh(String maDonHang, List<GioHang> gioHang) {
    String sql = "INSERT INTO ChiTietDonHang (ma_don_hang, ma_san_pham, so_luong, gia) VALUES (?, ?, ?, ?)";

    try (Connection conn = cn.connectSQL();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        for (GioHang sp : gioHang) {
            // Kiểm tra giỏ hàng trống
            if (sp == null) {
                continue; // bỏ qua nếu sản phẩm không hợp lệ
            }
            String maSanPham = sp.getMaSp(); // Mã sản phẩm
            String soLuong = sp.getSoluong();      // Số lượng sản phẩm
            String gia = sp.getGia();           // Giá sản phẩm
           
            // Thiết lập các tham số vào câu lệnh SQL
            ps.setString(1, maDonHang);  // Mã đơn hàng
            ps.setString(2, maSanPham);  // Mã sản phẩm
            ps.setString(3, soLuong);    // Số lượng
            ps.setString(4, gia);     // Giá sản phẩm

            // Thực thi câu lệnh SQL
            ps.addBatch(); // Thêm vào batch để thực thi tất cả trong một lần
        }

        // Thực thi batch
        int[] affectedRows = ps.executeBatch();
        return affectedRows.length > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
 public void ClearCart(String idUser) {
        String sql = "DELETE FROM GioHang WHERE ma_nguoi_dung = ?";

        try ( Connection conn = cn.connectSQL();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, idUser); // Truyền ID người dùng
            ps.executeUpdate();     // Thực thi xóa giỏ hàng
            System.out.println("Đã xóa giỏ hàng của người dùng: " + idUser);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi xóa giỏ hàng: " + e.getMessage());
        }
    }
}
