
package model;

import Controller.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Category {
    private String ma;
    private String Ten;
    private Connect cn = new Connect();

    public Connect getCn() {
        return cn;
    }

    public void setCn(Connect cn) {
        this.cn = cn;
    }
    public Category() {
    }

    public Category(String ma, String Ten) {
        this.ma = ma;
        this.Ten = Ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }
    
    //Ham Xem
     public List<Category> getDanhMuc() throws SQLException{
     ArrayList<Category> lists = new ArrayList<>();
        String sql = "SELECT * FROM DanhMucSanPham";
        try( Connection conn = cn.connectSQL();
        Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)       ){
            
            while(rs.next()){
                Category sp = new Category();
                sp.setMa(rs.getString("ma_danh_muc"));
                sp.setTen(rs.getString("ten_danh_muc"));
                lists.add(sp);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        };
      return lists;
       
    }
     
    //Lay ma danh muc 
     //Ham Xem
     public List<String> getAllMaDanhMuc() throws SQLException {
    List<String> danhMucIds = new ArrayList<>();
    String sql = "SELECT ma_danh_muc FROM DanhMucSanPham";
    try (Connection conn = cn.connectSQL();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            danhMucIds.add(rs.getString("ma_danh_muc"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return danhMucIds;
}
      public List<String> getAllTenDanhMuc() throws SQLException {
    List<String> danhMucIds = new ArrayList<>();
    String sql = "SELECT ten_danh_muc FROM DanhMucSanPham";
    try (Connection conn = cn.connectSQL();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            danhMucIds.add(rs.getString("ten_danh_muc"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return danhMucIds;
}
    //Ham them
     public boolean InsertData(Category obj) throws SQLException{
      String sql = "INSERT INTO DanhMucSanPham(ma_danh_muc, ten_danh_muc) values(?, ?)";
      try(Connection conn = cn.connectSQL();
          PreparedStatement pst = conn.prepareStatement(sql) ){
          pst.setString(1, obj.getMa());
          pst.setString(2, obj.getTen());
          pst.executeUpdate();
          return true;
      }catch(SQLException e){
          e.printStackTrace();
      }
      return false;
}
    //Ham sua
     public boolean EditData(Category obj) throws SQLException{
      String sql = "Update DanhMucSanPham set  ten_danh_muc=? where  ma_danh_muc=?";
      try(Connection conn = cn.connectSQL();
          PreparedStatement pst = conn.prepareStatement(sql) ){
          pst.setString(1, obj.getTen());
          pst.setString(2, obj.getMa());
          pst.executeUpdate();
          return true;
      }catch(SQLException e){
          e.printStackTrace();
      }
      return false;
}
    //Ham xoa
    public boolean DeleteData(String ml) throws SQLException{
      String sql = "Delete from DanhMucSanPham where  ma_danh_muc=?";
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
    
    public boolean isMaDanhMucExists(String ma) throws SQLException {
    String sql = "SELECT COUNT(*) FROM DanhMucSanPham WHERE ma_danh_muc = ?";
    try (Connection conn = cn.connectSQL();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setString(1, ma);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

}
