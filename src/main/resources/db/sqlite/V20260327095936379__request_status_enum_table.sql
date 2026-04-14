drop table if exists `request_status_enum`;
create table `request_status_enum` (
	request_status_enum_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	status_name	varchar(512)	not null
);insert into	request_status_enum	(status_name,request_status_enum_id)	values	("待处理","1");
insert into	request_status_enum	(status_name,request_status_enum_id)	values	("处理中","2");
insert into	request_status_enum	(status_name,request_status_enum_id)	values	("已完成","3");
