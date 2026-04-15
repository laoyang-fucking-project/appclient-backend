drop table if exists `sensor_data_record`;
create table `sensor_data_record` (
	sensor_data_record_id	int	 not null auto_increment,
	smart_home_device_smart_device_id_1	INT	not null,
	sensor_value	FLOAT	not null,
	record_time	DATETIME	,
	primary key (sensor_data_record_id)
);