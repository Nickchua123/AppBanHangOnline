package model;

import Controller.Connect;
import Login.Login;
import Login.SighUp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class NguoiDung {
    private String ma;
    private String ten;
    private String email;
    private String sdt;
    private String dc;
    private String lever;
    private String mk;
    private String mbm;

    public String getMbm() {
        return mbm;
    }

    public void setMbm(String mbm) {
        this.mbm = mbm;
    }
    private Connect cn = new Connect();
    
    public NguoiDung() {
    }

    public NguoiDung(String ma, String ten, String email, String sdt, String dc, String lever, String mk) {
        this.ma = ma;
        this.ten = ten;
        this.email = email;
        this.sdt = sdt;
        this.dc = dc;
        this.lever = lever;
        this.mk = mk;
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

    public String getLever() {
        return lever;
    }

    public void setLever(String lever) {
        this.lever = lever;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }
 
//Ham xem
     public List<NguoiDung> getNguoiDung() throws SQLException{
     ArrayList<NguoiDung> lists = new ArrayList<>();
        String sql = "SELECT * FROM NguoiDung";
        try( Connection conn = cn.connectSQL();
        Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)){
            
            while(rs.next()){
                NguoiDung sp = new NguoiDung();
                sp.setMa(rs.getString("ma_nguoi_dung"));
                sp.setTen(rs.getString("ten_dang_nhap"));
                sp.setEmail(rs.getString("email"));
                sp.setSdt(rs.getString("so_dien_thoai"));
                sp.setDc(rs.getString("dia_chi"));
                sp.setLever(rs.getString("lever"));
               
                lists.add(sp);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        };
      return lists;
       
    }
//Ham xem theo ma
    public NguoiDung getNguoiDung(String ml) throws SQLException{
    String sql = "SELECT * FROM NguoiDung WHERE ma_nguoi_dung = ?";
    NguoiDung sp= null;
    try (Connection conn = cn.connectSQL();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        
        // Đặt tham số cho truy vấn SQL
        pst.setString(1, ml);
        
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                 sp = new NguoiDung();
                sp.setTen(rs.getString("ten_dang_nhap"));
                sp.setEmail(rs.getString("email"));
                sp.setSdt(rs.getString("so_dien_thoai"));
                sp.setDc(rs.getString("dia_chi"));
                sp.setLever(rs.getString("lever"));
               
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return sp;
    }
//Ham sua
     //Dieu chinh 1 dong du lieu vao table NguoiDung
      public boolean EditData(NguoiDung obj) throws SQLException{
      String hashedPassword = Login.PasswordUtils.hashPassword(obj.getMk());
       String hashedMbm = Login.PasswordUtils.hashPassword(obj.getMbm());
      String sql = "Update NguoiDung set ten_dang_nhap=?, email=?, so_dien_thoai=?, dia_chi=?, lever=?, mat_khau_ma_hoa=?,ma_bi_mat=? where ma_nguoi_dung=?";
      try(Connection conn = cn.connectSQL();
          PreparedStatement pst = conn.prepareStatement(sql) ){
          pst.setString(1, obj.getTen());
          pst.setString(2, obj.getEmail());
          pst.setString(3, obj.getSdt());
          pst.setString(4, obj.getDc());
          pst.setString(5, obj.getLever());
          pst.setString(6, hashedPassword);
          pst.setString(7, hashedMbm);
          pst.setString(8, obj.getMa());
          pst.executeUpdate();
          return true;
      }catch(SQLException e){
          e.printStackTrace();
      }
      return false;
}
     
//Ham them
      public void insertData(String name, String email, String sdt, String dc,String Lever, String password, String mbm) {
    String hashedPassword = Login.PasswordUtils.hashPassword(password);
    String hashedMbm = Login.PasswordUtils.hashPassword(mbm);
    if (hashedPassword == null) {
        JOptionPane.showMessageDialog(null, "Lỗi khi mã hóa mật khẩu.");
        return;
    }
    if (hashedMbm == null) {
        JOptionPane.showMessageDialog(null, "Lỗi khi mã hóa mã bí mật.");
        return;
    }

    try (Connection connection = cn.connectSQL()) {
        // Kiểm tra email đã tồn tại
        String checkEmailSql = "SELECT COUNT(*) FROM NguoiDung WHERE Email = ?";
        try (PreparedStatement checkStmt = connection.prepareStatement(checkEmailSql)) {
            checkStmt.setString(1, email);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(null, "Email đã tồn tại, vui lòng chọn email khác.");
                    return;
                }
            }
        }
        
        // Thêm dữ liệu vào cơ sở dữ liệu
        String sql = "INSERT INTO NguoiDung (ten_dang_nhap, email, so_dien_thoai, dia_chi,lever, mat_khau_ma_hoa, ma_bi_mat) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, sdt);
            preparedStatement.setString(4, dc);
            preparedStatement.setString(5, Lever);
            preparedStatement.setString(6, hashedPassword);
            preparedStatement.setString(7, hashedMbm);
            
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Đăng ký thành công!");
            }
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi khi thực hiện thao tác cơ sở dữ liệu.");
    }
}
//Ham xoa
           //Xoa 1 dong du lieu vao table NguoiDung
      public boolean DeleteData(String ml) throws SQLException{
      String sql = "Delete from NguoiDung where ma_nguoi_dung=?";
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
//Ham kiểm tra đăng nhập
 public boolean checkLogin(String email, String password) {
    String query = "SELECT * FROM NguoiDung WHERE email = ?";
    
    try (Connection connection = cn.connectSQL();
         PreparedStatement stmt = connection.prepareStatement(query)) {
        
        stmt.setString(1, email);
        
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                String storedHashedPassword = rs.getString("mat_khau_ma_hoa");
                return storedHashedPassword.equals(Login.PasswordUtils.hashPassword(password));
            }
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return false; 
}

 //Hàm lấy id
   public NguoiDung getId(String email) throws SQLException{
    String sql = "SELECT * FROM NguoiDung WHERE email = ?";
    NguoiDung sp = null;
    try (Connection conn = cn.connectSQL();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        
        // Đặt tham số cho truy vấn SQL
        pst.setString(1, email);
        
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                 sp = new NguoiDung();
                sp.setMa(rs.getString("ma_nguoi_dung"));
                sp.setLever(rs.getString("lever"));
                sp.setTen(rs.getString("ten_dang_nhap"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return sp;
    }
}
