drop table if exists `sensor_data_record`;
create table `sensor_data_record` (
	sensor_data_record_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	smart_home_device_smart_device_id_1	INTEGER	not null,
	sensor_value	FLOAT	not null,
	record_time	DATETIME	
);