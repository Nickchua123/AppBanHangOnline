package model;

import Controller.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Product {
    private String ma;
    private String ten;
    private String moTa;
    private String Soluong;
    private String gia;
    private String maDM;
    private String TenDM;

    public String getTenDM() {
        return TenDM;
    }

    public void setTenDM(String TenDM) {
        this.TenDM = TenDM;
    }

    public String getMaDM() {
        return maDM;
    }

    public void setMaDM(String maDM) {
        this.maDM = maDM;
    }
    private String imagle;

    public String getImagle() {
        return imagle;
    }

    public void setImagle(String imagle) {
        this.imagle = imagle;
    }
    private Connect cn = new Connect();

   

    public Product() {
    }
    
    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getSoluong() {
        return Soluong;
    }

    public void setSoluong(String Soluong) {
        this.Soluong = Soluong;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

//Hàm xem
      public List<Product> getSanPham() throws SQLException{
     ArrayList<Product> lists = new ArrayList<>();
        String sql = "select * from SanPham, DanhMucSanPham\n" +
"where SanPham.ma_danh_muc = DanhMucSanPham.ma_danh_muc";
        try( Connection conn = cn.connectSQL();
        Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)       ){
            
            while(rs.next()){
                Product sp = new Product();
                sp.setMa(rs.getString("ma_san_pham"));
                sp.setTen(rs.getString("ten_san_pham"));
                sp.setMoTa(rs.getString("mo_ta"));
                sp.setGia(rs.getString("gia"));
                sp.setSoluong(rs.getString("so_luong_ton_kho"));
                sp.setMaDM(rs.getString("ma_danh_muc"));
                sp.setImagle(rs.getString("imagle"));
                sp.setTenDM(rs.getString("ten_danh_muc"));
                lists.add(sp);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        };
      return lists;
       
    }
//Truy van theo ma       
 public Product getDetail(String msp) throws SQLException{
    String sql = "select * from SanPham, DanhMucSanPham\n" +
"where SanPham.ma_danh_muc = DanhMucSanPham.ma_danh_muc and ma_san_pham =?";
    Product sp = null;
    try (Connection conn = cn.connectSQL();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        
        // Đặt tham số cho truy vấn SQL
        pst.setString(1, msp);
        
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                sp = new Product();
                sp.setTen(rs.getString("ten_san_pham"));
                sp.setMoTa(rs.getString("mo_ta"));
                sp.setImagle(rs.getString("imagle"));
                sp.setGia(rs.getString("gia"));
                sp.setTenDM(rs.getString("ten_danh_muc"));
                sp.setSoluong(rs.getString("so_luong_ton_kho"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return sp;
    }
//Hàm thêm
       public boolean InsertData(Product obj) throws SQLException{
      String sql = "INSERT INTO SanPham(ten_san_pham, mo_ta, gia, so_luong_ton_kho,imagle,ma_danh_muc) values(?, ?, ?, ?, ?, ?)";
      try(Connection conn = cn.connectSQL();
          PreparedStatement pst = conn.prepareStatement(sql) ){
          pst.setString(1, obj.getTen());
          pst.setString(2, obj.getMoTa());
          pst.setString(3, obj.getGia());
          pst.setString(4, obj.getSoluong());
           pst.setString(5, obj.getImagle());
            pst.setString(6, obj.getMaDM());
          pst.executeUpdate();
          return true;
      }catch(SQLException e){
          e.printStackTrace();
      }
      return false;
}
//Hàm Sửa 
       public boolean EditData(Product obj) throws SQLException{
      String sql = "Update SanPham set ten_san_pham=?,mo_ta = ?,gia=?,so_luong_ton_kho=?,imagle=?,ma_danh_muc=? where ma_san_pham=?";
      try(Connection conn = cn.connectSQL();
          PreparedStatement pst = conn.prepareStatement(sql) ){
          pst.setString(1, obj.getTen());
          pst.setString(2, obj.getMoTa());
          pst.setString(3, obj.getGia());
          pst.setString(4, obj.getSoluong());
          pst.setString(5, obj.getImagle());
          pst.setString(6, obj.getMaDM());
          pst.setString(7, obj.getMa());
          pst.executeUpdate();
          return true;
      }catch(SQLException e){
          e.printStackTrace();
      }
      return false;
}
//Hàm xóa    
public boolean DeleteData(String ml) throws SQLException{
      String sql = "Delete from SanPham where ma_san_pham=?";
       try(Connection conn = cn.connectSQL();
          PreparedStatement pst = conn.prepareStatement(sql) ){
          pst.setString(1, ml);
          pst.executeUpdate();
          return true;
      }catch(SQLException e){
          e.printStackTrace();
      }
      return false;
}

}
