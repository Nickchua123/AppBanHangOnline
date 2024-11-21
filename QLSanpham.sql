create database QLSanpham
go

use QLSanpham
go

create table LoaiSP(
   Maloai char(2) primary key,
   TenLoai Nvarchar(20)

)

create table Sanpham(
   MaSP char(4) primary key,
   TenSP Nvarchar(20),
   DonGia Bigint,
   Maloai char(2),
   FOREIGN KEY (Maloai) REFERENCES LoaiSP(Maloai)
)

insert into LoaiSP(Maloai,TenLoai) 
values ('BK','BanhKeo'),
       ('GK','GiaiKhat'),
	   ('MP','MiPham');

insert into Sanpham(MaSP,TenSP,DonGia,Maloai) 
values('SP01','Bánh mi','10000','BK'),
      ('SP02','Bánh bao','15000','BK'),
	  ('SP03','Cola cola ','12000','Gk'),
	  ('SP04','Pepsi','10000','GK'),
	  ('SP05','Kem chong nang','85000','MP');

select * from LoaiSP
select * from Sanpham

