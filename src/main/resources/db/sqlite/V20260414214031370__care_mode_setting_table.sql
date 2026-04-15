drop table if exists `care_mode_setting`;
create table `care_mode_setting` (
	care_mode_setting_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	user_info_user_info_id_1	INTEGER	not null,
	enabled	BOOL	not null
);insert into	care_mode_setting	(user_info_user_info_id_1,care_mode_setting_id,enabled)	values	("1","1","true");
