create database BanHangOnline
go

use  BanHangOnline
go

CREATE TABLE DanhMucSanPham (
    ma_danh_muc NVARCHAR(12) PRIMARY KEY,
    ten_danh_muc NVARCHAR(100) NOT NULL
);

CREATE TABLE SanPham (
    ma_san_pham INT IDENTITY(1,1) PRIMARY KEY,
    ten_san_pham NVARCHAR(255) NOT NULL,
    mo_ta NVARCHAR(MAX),
    gia DECIMAL(10, 0) NOT NULL,
    so_luong_ton_kho INT DEFAULT 0,
	imagle VARCHAR(500) NOT NULL,
    ma_danh_muc NVARCHAR(12),
    ngay_tao DATETIME DEFAULT GETDATE(),
    ngay_cap_nhat DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (ma_danh_muc) REFERENCES DanhMucSanPham(ma_danh_muc)
);

-- Bảng DonHang
CREATE TABLE DonHang (
    ma_don_hang INT IDENTITY(1,1) PRIMARY KEY,
    ma_nguoi_dung INT NOT NULL,
    tong_tien DECIMAL(10, 0) NOT NULL,
    trang_thai_thanh_toan NVARCHAR(50) CHECK (trang_thai_thanh_toan IN (N'chờ xử lý', N'đã thanh toán', N'thất bại')),
    phuong_thuc_thanh_toan NVARCHAR(50),
    dia_chi_giao_hang NVARCHAR(MAX),
    trang_thai_giao_hang NVARCHAR(50) CHECK (trang_thai_giao_hang IN (N'chờ giao', N'đang giao', N'đã giao', N'đã trả lại')),
    ngay_dat_hang DATETIME DEFAULT GETDATE(),
    ngay_giao_hang_du_kien DATETIME,
    ngay_giao_hang_thuc_te DATETIME,
    FOREIGN KEY (ma_nguoi_dung) REFERENCES NguoiDung(ma_nguoi_dung)
);

-- Bảng ChiTietDonHang
CREATE TABLE ChiTietDonHang (
    ma_chi_tiet_don_hang INT IDENTITY(1,1) PRIMARY KEY,
    ma_don_hang INT NOT NULL,
    ma_san_pham INT NOT NULL,
    so_luong INT NOT NULL,
    gia DECIMAL(10, 0) NOT NULL,
    FOREIGN KEY (ma_don_hang) REFERENCES DonHang(ma_don_hang),
    FOREIGN KEY (ma_san_pham) REFERENCES SanPham(ma_san_pham)
);
CREATE TABLE NguoiDung (
    ma_nguoi_dung INT IDENTITY(1,1) PRIMARY KEY,
    ten_dang_nhap NVARCHAR(50) NOT NULL,
    email NVARCHAR(100) NOT NULL UNIQUE,
	so_dien_thoai NVARCHAR(15),
    dia_chi NVARCHAR(MAX),
	lever NVARCHAR(6)  CHECK (lever IN ('User', 'Admin')) DEFAULT 'User',
    mat_khau_ma_hoa NVARCHAR(255) NOT NULL,
    ma_bi_mat NVARCHAR(255) NOT NULL,
    ngay_tao DATETIME DEFAULT GETDATE(),
    ngay_cap_nhat DATETIME DEFAULT GETDATE()
);
-- Bảng GioHang
CREATE TABLE GioHang (
    ma_gio_hang INT IDENTITY(1,1) PRIMARY KEY,
    ma_nguoi_dung INT NOT NULL,
    ma_san_pham INT NOT NULL,
    so_luong INT DEFAULT 1,
    FOREIGN KEY (ma_nguoi_dung) REFERENCES NguoiDung(ma_nguoi_dung),
    FOREIGN KEY (ma_san_pham) REFERENCES SanPham(ma_san_pham)
);
-- DanhMucSanPham SanPham DonHang  ChiTietDonHang NguoiDung GioHang
select * from NguoiDung
--xoa ban ghi 
delete from  DonHang
--xoa bang
drop table   DonHang
alter table NguoiDung add lever NVARCHAR(6),

-- Tạo Trigger cập nhật `ngay_cap_nhat`
CREATE TRIGGER trg_UpdateSanPham
ON SanPham
AFTER UPDATE
AS
BEGIN
    SET NOCOUNT ON;
    UPDATE SanPham
    SET ngay_cap_nhat = GETDATE()
    WHERE ma_san_pham IN (SELECT DISTINCT ma_san_pham FROM Inserted);
END;

INSERT INTO DanhMucSanPham (ma_danh_muc, ten_danh_muc)
VALUES 
    ('DM001', N'Điện tử'),
    ('DM002', N'Gia dụng'),
    ('DM003', N'Thời trang');

INSERT INTO SanPham (ten_san_pham, mo_ta, gia, so_luong_ton_kho, imagle, ma_danh_muc)
VALUES 
    (N'Tivi Samsung', N'Tivi 4K UHD 55 inch', 15000000, 20, 'C:\Users\dungp\OneDrive\Pictures\Saved Pictures\OIP.jpeg', 'DM001'),
    (N'Quạt điều hòa', N'Quạt mát tiết kiệm điện', 3000000, 50, 'C:\Users\dungp\OneDrive\Pictures\Saved Pictures\R.jpeg', 'DM002'),
    (N'Áo khoác nam', N'Áo khoác mùa đông', 500000, 100, 'C:\Users\dungp\OneDrive\Pictures\Saved Pictures\R (1).jpeg', 'DM003');
	
	


	 INSERT INTO GioHang (ma_nguoi_dung, ma_san_pham, so_luong, gia)
VALUES 
    (1, 3, 2, 1000000),
    (2, 1, 1, 15000000);

	INSERT INTO ChiTietDonHang (ma_don_hang, ma_san_pham, so_luong, gia)
VALUES 
    (1, 1, 1, 15000000),
    (2, 2, 1, 3000000);

	INSERT INTO DonHang (ma_nguoi_dung, tong_tien, trang_thai_thanh_toan, phuong_thuc_thanh_toan, dia_chi_giao_hang, trang_thai_giao_hang, ngay_giao_hang_du_kien)
VALUES 
    (1, 15000000, N'đã thanh toán', N'Chuyển khoản', N'Hà Nội', N'đang giao', '2024-11-25'),
    (2, 3000000, N'chờ xử lý', N'Thanh toán khi nhận hàng', N'Đà Nẵng', N'chờ giao', '2024-11-30');
