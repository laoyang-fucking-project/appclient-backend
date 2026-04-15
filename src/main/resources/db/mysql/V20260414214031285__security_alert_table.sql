drop table if exists `security_alert`;
create table `security_alert` (
	security_alert_id	INT	 not null auto_increment,
	alert_type_enum_alert_type_enum_id_1	INT	not null,
	alert_level_enum_alert_level_enum_id_1	INT	not null,
	alert_status_enum_alert_status_enum_id_1	INT	not null,
	description	TEXT	,
	report_user_info_user_info_id_1	INT	not null,
	process_progress	varchar(512)	,
	create_time	DATETIME	,
	primary key (security_alert_id)
);insert into	security_alert	(report_user_info_user_info_id_1,security_alert_id,alert_status_enum_alert_status_enum_id_1,alert_level_enum_alert_level_enum_id_1,create_time,description,alert_type_enum_alert_type_enum_id_1,process_progress)	values	("1","1","1","3","2024-06-01 10:00:00","小区火情报警，火势已控制","1","已派遣消防队");
