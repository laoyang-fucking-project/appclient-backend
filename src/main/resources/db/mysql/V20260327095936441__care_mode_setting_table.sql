drop table if exists `care_mode_setting`;
create table `care_mode_setting` (
	care_mode_setting_id	INT	 not null auto_increment,
	user_info_user_info_id_1	INT	not null,
	enabled	BOOL	not null,
	primary key (care_mode_setting_id)
);insert into	care_mode_setting	(user_info_user_info_id_1,care_mode_setting_id,enabled)	values	("1","1","true");
