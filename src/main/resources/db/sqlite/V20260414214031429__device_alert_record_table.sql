drop table if exists `device_alert_record`;
create table `device_alert_record` (
	device_alert_record_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	smart_home_device_smart_device_id_1	INTEGER	not null,
	alert_type	varchar(512)	,
	alert_level	varchar(512)	,
	alert_message	varchar(512)	,
	is_resolved	INTEGER	,
	create_time	DATETIME	
);