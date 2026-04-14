drop table if exists `alert_level_enum`;
create table `alert_level_enum` (
	alert_level_enum_id	INT	 not null auto_increment,
	level_name	varchar(512)	not null,
	primary key (alert_level_enum_id)
);insert into	alert_level_enum	(alert_level_enum_id,level_name)	values	("1","低");
insert into	alert_level_enum	(alert_level_enum_id,level_name)	values	("2","中");
insert into	alert_level_enum	(alert_level_enum_id,level_name)	values	("3","高");
