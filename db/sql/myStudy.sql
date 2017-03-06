--数据库初始化
create database MYSTUDY;
use myStudy;

--留言表
create table MESSAGE (
	ID bigint not null auto_increment comment 'ID',
	NAME varchar(120) not null comment '留言人',
	CONTENT varchar(2000) null comment '留言内容',
	STATUS int not null default 0 comment '状态 0-无效 1-有效 2-删除',
	CREATE_TIME datetime not null comment '创建时间',
	UPDATE_TIME datetime not null comment '最后一次修改时间',
	VERSION int not null comment '版本',
	primary key (ID)
) engine=InnoDB DEFAULT CHARSET=utf8 comment='留言表';