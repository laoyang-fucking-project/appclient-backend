drop table if exists `ai_chat_record`;
create table `ai_chat_record` (
	ai_chat_record_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	user_info_user_info_id_1	INTEGER	not null,
	question_text	TEXT	not null,
	answer_text	TEXT	,
	audio_url	varchar(512)	,
	create_time	DATETIME	
);insert into	ai_chat_record	(answer_text,question_text,user_info_user_info_id_1,create_time,audio_url,ai_chat_record_id)	values	("您可以在物业服务中选择报修类型，填写相关信息提交即可。","如何办理物业报修？","1","2024-06-01 12:00:00.0 00:00:00.0","","1");
