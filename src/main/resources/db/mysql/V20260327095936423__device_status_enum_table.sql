drop table if exists `device_status_enum`;
create table `device_status_enum` (
	device_status_enum_id	INT	 not null auto_increment,
	status_name	varchar(512)	not null,
	primary key (device_status_enum_id)
);insert into	device_status_enum	(status_name,device_status_enum_id)	values	("正常","1");
insert into	device_status_enum	(status_name,device_status_enum_id)	values	("异常","2");
insert into	device_status_enum	(status_name,device_status_enum_id)	values	("离线","3");
