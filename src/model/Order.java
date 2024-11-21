
package model;

import Controller.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Order {
    private String ten;
    private String email;
    private String sdt;
    private String dc;
    private String Pttt;
    private String Tttt;
    private String tenSp;
    private String sl;
    private String tt;
    private String gia;
    private String mactdh;
    private String maNd;
    private String sDh;

    public String getTt() {
        return tt;
    }

    public void setTt(String tt) {
        this.tt = tt;
    }

    

    public String getsDh() {
        return sDh;
    }

    public void setsDh(String sDh) {
        this.sDh = sDh;
    }

    public String getMaNd() {
        return maNd;
    }

    public void setMaNd(String maNd) {
        this.maNd = maNd;
    }

    public String getMactdh() {
        return mactdh;
    }

    public void setMactdh(String mactdh) {
        this.mactdh = mactdh;
    }
    

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    private String img;
    
    private Connect cn = new Connect();

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public String getPttt() {
        return Pttt;
    }

    public void setPttt(String Pttt) {
        this.Pttt = Pttt;
    }

    public String getTttt() {
        return Tttt;
    }

    public void setTttt(String Tttt) {
        this.Tttt = Tttt;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }

    

    public Order() {
    }

   
    public Connect getCn() {
        return cn;
    }

    public void setCn(Connect cn) {
        this.cn = cn;
    }
    
 public List<Order> getDonHang(String ml) throws SQLException{
     ArrayList<Order> lists = new ArrayList<>();
     String sql = "SELECT \n" +
"    SanPham.imagle, \n" +
"    SanPham.ten_san_pham, \n" +
"    SUM(ChiTietDonHang.so_luong) AS so_luong,\n" +
"    SanPham.gia,DonHang.phuong_thuc_thanh_toan,\n" +
"    SUM(ChiTietDonHang.so_luong * SanPham.gia) AS tong_tien\n" +
"FROM \n" +
"    SanPham\n" +
"JOIN \n" +
"    ChiTietDonHang ON SanPham.ma_san_pham = ChiTietDonHang.ma_san_pham\n" +
"JOIN \n" +
"    DonHang ON ChiTietDonHang.ma_don_hang = DonHang.ma_don_hang\n" +
"JOIN \n" +
"    NguoiDung ON DonHang.ma_nguoi_dung = NguoiDung.ma_nguoi_dung\n" +
"WHERE \n" +
"    NguoiDung.ma_nguoi_dung = ?\n" +
"GROUP BY \n" +
"    SanPham.imagle, SanPham.ten_san_pham, SanPham.gia,DonHang.phuong_thuc_thanh_toan;";
 
    try (Connection conn = cn.connectSQL();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        
        // Đặt tham số cho truy vấn SQL
        pst.setString(1, ml);
        
        try (ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
               Order sp = new Order();
                sp.setImg(rs.getString("imagle"));
                sp.setTenSp(rs.getString("ten_san_pham"));
                sp.setSl(rs.getString("so_luong"));
                sp.setGia(rs.getString("gia"));
                sp.setTt(rs.getString("tong_tien"));
                sp.setPttt(rs.getString("phuong_thuc_thanh_toan"));
                 lists.add(sp);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lists;
    }     
      
     
public List<Order> showDonHang() throws SQLException{
        ArrayList<Order> lists = new ArrayList<>();
        String sql = "SELECT \n" +
"    NguoiDung.ma_nguoi_dung, \n" +
"    ten_dang_nhap,\n" +
"    SUM(ChiTietDonHang.so_luong) AS so_san_pham, \n" +
"    dia_chi,\n" +
"    trang_thai_thanh_toan, \n" +
"    SUM(ChiTietDonHang.gia * so_luong) AS tong_cong\n" +
"FROM \n" +
"    ChiTietDonHang ,DonHang,SanPham,NguoiDung\n" +
"Where \n" +
"     ChiTietDonHang.ma_don_hang = DonHang.ma_don_hang\n" +
"and \n" +
"    DonHang.ma_nguoi_dung = NguoiDung.ma_nguoi_dung\n" +
"and \n" +
"    SanPham.ma_san_pham = ChiTietDonHang.ma_san_pham\n" +
"\n" +
"GROUP BY \n" +
"    NguoiDung.ma_nguoi_dung, ten_dang_nhap, dia_chi, trang_thai_thanh_toan;";
        try( Connection conn = cn.connectSQL();
        Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)){
            
            while(rs.next()){
                Order sp = new Order();
                sp.setMaNd(rs.getString("ma_nguoi_dung"));
                sp.setTt(rs.getString("tong_cong"));                             
                sp.setsDh(rs.getString("so_san_pham"));
                sp.setTttt(rs.getString("trang_thai_thanh_toan"));
                sp.setTen(rs.getString("ten_dang_nhap"));
                sp.setDc(rs.getString("dia_chi"));
               
                lists.add(sp);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        };
      return lists;
         
}

 public Order getThongTin(String ml) throws SQLException{
    String sql = "select ten_dang_nhap,email,dia_chi,so_dien_thoai,phuong_thuc_thanh_toan,trang_thai_thanh_toan\n" +
"from NguoiDung, DonHang\n" +
"where NguoiDung.ma_nguoi_dung =DonHang.ma_nguoi_dung and NguoiDung.ma_nguoi_dung =?";
    Order sp = null;
    try (Connection conn = cn.connectSQL();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        
        // Đặt tham số cho truy vấn SQL
        pst.setString(1, ml);
        
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                sp = new Order();
                sp.setTen(rs.getString("ten_dang_nhap"));
                sp.setEmail(rs.getString("email"));
                sp.setDc(rs.getString("dia_chi"));
                sp.setSdt(rs.getString("so_dien_thoai"));
                sp.setPttt(rs.getString("phuong_thuc_thanh_toan"));
                sp.setTttt(rs.getString("trang_thai_thanh_toan"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return sp;
    }
 public boolean InsertData(Order obj) throws SQLException{
      String sql = "INSERT INTO DonHang(ma_nguoi_dung,tong_tien,dia_chi,trang_thai_thanh_toan) values(?, ?, ?, ?)";
      try(Connection conn = cn.connectSQL();
          PreparedStatement pst = conn.prepareStatement(sql) ){
          pst.setString(1, obj.getMaNd());
          pst.setString(2, obj.getTt());
          pst.setString(3, obj.getDc());
          pst.setString(4, obj.getTttt());
          pst.executeUpdate();
          return true;
      }catch(SQLException e){
          e.printStackTrace();
      }
      return false;
}


 



}
