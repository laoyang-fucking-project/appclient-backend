drop table if exists `user_info`;
create table `user_info` (
	user_info_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	phone_number	VARCHAR(64)	not null,
	username	varchar(512)	,
	password	VARCHAR(64)	,
	role_enum_role_enum_id_1	INTEGER	not null
);insert into	user_info	(password,role_enum_role_enum_id_1,phone_number,user_info_id,username)	values	("******","1","13800000000","1","张三");
