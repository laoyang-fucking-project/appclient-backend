drop table if exists `device_alert_record`;
create table `device_alert_record` (
	device_alert_record_id	int	 not null auto_increment,
	smart_home_device_smart_device_id_1	INT	not null,
	alert_type	varchar(512)	,
	alert_level	varchar(512)	,
	alert_message	varchar(512)	,
	is_resolved	int	,
	create_time	DATETIME	,
	primary key (device_alert_record_id)
);