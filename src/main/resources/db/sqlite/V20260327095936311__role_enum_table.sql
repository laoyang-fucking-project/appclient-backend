drop table if exists `role_enum`;
create table `role_enum` (
	role_enum_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	role_name	varchar(512)	not null
);insert into	role_enum	(role_name,role_enum_id)	values	("居民","1");
insert into	role_enum	(role_name,role_enum_id)	values	("物业","2");
