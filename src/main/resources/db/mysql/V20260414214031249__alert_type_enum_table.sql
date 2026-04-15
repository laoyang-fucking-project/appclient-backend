drop table if exists `alert_type_enum`;
create table `alert_type_enum` (
	alert_type_enum_id	INT	 not null auto_increment,
	type_name	varchar(512)	not null,
	primary key (alert_type_enum_id)
);insert into	alert_type_enum	(alert_type_enum_id,type_name)	values	("1","火情");
insert into	alert_type_enum	(alert_type_enum_id,type_name)	values	("2","燃气");
