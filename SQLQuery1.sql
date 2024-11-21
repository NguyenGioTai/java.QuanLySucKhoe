CREATE DATABASE QuanLySucKhoe;
USE QuanLySucKhoe;

-- Bảng user
CREATE TABLE [user] (
    id INT PRIMARY KEY IDENTITY(1,1),
    username NVARCHAR(50) NOT NULL,
    password NVARCHAR(50) NOT NULL
);

-- Bảng ChiSoSucKhoe
CREATE TABLE ChiSoSucKhoe (
    MaPhieu INT IDENTITY(1,1) PRIMARY KEY,
    UserID INT,
    Ngay NVARCHAR(100),
    TinhTrangCoThe NVARCHAR(100),
    GioiTinh NVARCHAR(10),
    ChieuCao FLOAT,
    CanNang FLOAT,
    HuyetAp NVARCHAR(50),
    NhipTim INT,
    LuongDuongMau FLOAT,
    NhietDoCoThe FLOAT,
    CONSTRAINT FK_UserChiSo FOREIGN KEY (UserID) REFERENCES [user](id)
);

-- Bảng ChieuCao
CREATE TABLE ChieuCaoVaCanNang (
    id INT PRIMARY KEY IDENTITY(1,1),
    MaPhieu INT,
    thoiGian NVARCHAR(255),
    chieuCao FLOAT,
	canNang FLOAT,
    CONSTRAINT FK_ChiSoChieuCao FOREIGN KEY (MaPhieu) REFERENCES ChiSoSucKhoe(MaPhieu)
);

-- Tạo bảng MucTieuHoanThanh
CREATE TABLE MucTieuHoanThanh (
    id INT IDENTITY(1,1) PRIMARY KEY,  -- Khóa chính tự tăng
             
    ThoiGianHoanThanh NVARCHAR(255),  -- Ngày giờ hoàn thành, mặc định là thời gian hiện tại
    ChieuCaoHoanThanh FLOAT CHECK (ChieuCaoHoanThanh > 0), -- Ràng buộc chiều cao phải lớn hơn 0
    CanNangHoanThanh FLOAT CHECK (CanNangHoanThanh > 0)   -- Ràng buộc cân nặng phải lớn hơn 0
);

-- Bảng CanNang


select *
from [user];

select *
from ChieuCaoVaCanNang;

SELECT * FROM ChiSoSucKhoe;

ALTER TABLE ChiSoSucKhoe
DROP COLUMN UserID;

ALTER TABLE ChiSoSucKhoe
ADD  UserID INT IDENTITY(1,1);

select* from MucTieuHoanThanh;


