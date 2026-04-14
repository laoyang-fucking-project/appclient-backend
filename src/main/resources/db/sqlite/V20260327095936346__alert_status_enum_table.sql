drop table if exists `alert_status_enum`;
create table `alert_status_enum` (
	alert_status_enum_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	status_name	varchar(512)	not null
);insert into	alert_status_enum	(alert_status_enum_id,status_name)	values	("1","待处理");
insert into	alert_status_enum	(alert_status_enum_id,status_name)	values	("2","处理中");
insert into	alert_status_enum	(alert_status_enum_id,status_name)	values	("3","已处理");
