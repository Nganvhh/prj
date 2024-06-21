create database lichHen;
go
use lichHen;
go
create table taiKhoan (
	account varchar(50) primary key not null,
	pass varchar(35) not null,
	fullName nvarchar(30) not null,
	dob datetime,
	gender bit default 1,
	phone varchar(20) default '',
	addr nvarchar(50) default '',
	memo ntext default ''
);
go
create table banBe (
	soDT varchar(10) primary key not null,
	hoTen nvarchar(35) not null,
	gioiTinh bit default 1,
	ngaySinh datetime default '1900/1//1',
	diaChi nvarchar(100) default '',
	loaiQuanHe int default 0,	--Bạn học, Đồng nghiệp, Đối tác,...
	ghiChu ntext default ''
);
go
create table lichHen (
	account varchar(50) foreign key references taiKhoan (account) on update cascade,
	soDT varchar(10) foreign key references banBe(soDT) on update cascade,
	khiNao datetime not null,		--Hẹn lúc mấy giờ
	diaDiem nvarchar(100) not null,
	thoiGian int default 60,		--Gặp mặt trong thời gian bao lâu
	chiPhi int default 100000,		--Chi phí dự kiến
	ghiChu ntext default ''
);
go

insert into taiKhoan values ('admin', '1a2b3c', N'Nguyễn Minh Quang', '2003/06/12', 1, '0909998877', N'123 Lý Chính Thắng, Q.3, TP.Hồ Chí Minh', '');
insert into taiKhoan values ('manager', '111111', N'Nguyễn Quang Hưng', '2003/10/28', 1, '0918224466', N'1048 Cách Mạng Tháng Tám, P11, Q.3, TP.Hồ Chí Minh', '');