drop table if exists `smart_home_device`;
create table `smart_home_device` (
	smart_device_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	device_name	varchar(512)	not null,
	smart_device_type_enum_smart_device_type_enum_id_1	INTEGER	not null,
	smart_device_status_enum_smart_device_status_enum_id_1	INTEGER	not null,
	room_name	varchar(512)	not null,
	current_value	FLOAT	,
	is_on	INTEGER	,
	brightness	INTEGER	,
	last_update_time	DATETIME	,
	user_info_user_info_id_1	INTEGER	not null
);