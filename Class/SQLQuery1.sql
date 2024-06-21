CREATE DATABASE Test1;
go
use Test1;
go
create table TaiKhoan (
	acc varchar(50) primary key not null,
	pass varchar(35) not null,
	fullname nvarchar(30) not null,
	dob datetime,
	gender bit default 1,
	phone varchar(20) default '',
	addr nvarchar(50) default '',
	memo ntext default ''
);
go
insert into TaiKhoan values ('admin', '1a2b3c', N'Nguyễn Minh Quang', '2003/06/12', 1, '0909998877', N'123 Lê Chính Thắng, Q3, TP.Hồ Chí Minh', '');
go
