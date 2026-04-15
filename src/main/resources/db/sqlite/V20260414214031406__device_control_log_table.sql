drop table if exists `device_control_log`;
create table `device_control_log` (
	device_control_log_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	smart_home_device_smart_device_id_1	INTEGER	not null,
	user_info_user_info_id_1	INTEGER	not null,
	action_type	varchar(512)	,
	action_value	varchar(512)	,
	create_time	DATETIME	
);