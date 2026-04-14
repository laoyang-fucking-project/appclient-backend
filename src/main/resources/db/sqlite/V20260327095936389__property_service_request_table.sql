drop table if exists `property_service_request`;
create table `property_service_request` (
	property_service_request_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	request_type_enum_request_type_enum_id_1	INTEGER	not null,
	request_status_enum_request_status_enum_id_1	INTEGER	not null,
	user_info_user_info_id_1	INTEGER	not null,
	description	TEXT	not null,
	create_time	DATETIME	,
	process_progress	varchar(512)	
);insert into	property_service_request	(user_info_user_info_id_1,create_time,request_type_enum_request_type_enum_id_1,request_status_enum_request_status_enum_id_1,property_service_request_id,description,process_progress)	values	("1","2024-06-01 11:00:00.0 00:00:00.0","1","1","1","电梯故障，急需维修","已派维修人员");
