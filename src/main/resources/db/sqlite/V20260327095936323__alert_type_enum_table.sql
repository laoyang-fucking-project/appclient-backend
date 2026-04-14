drop table if exists `alert_type_enum`;
create table `alert_type_enum` (
	alert_type_enum_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	type_name	varchar(512)	not null
);insert into	alert_type_enum	(alert_type_enum_id,type_name)	values	("1","火情");
insert into	alert_type_enum	(alert_type_enum_id,type_name)	values	("2","燃气");
