--数据库初始化
create database MYSTUDY;
use myStudy;

drop table if exists T_MENU;

drop table if exists T_MESSAGE;

drop table if exists T_REL_ROLE_MENU;

drop table if exists T_REL_USER_ROLE;

drop table if exists T_ROLE;

drop table if exists T_USER;

/*==============================================================*/
/* Table: T_MENU                                                */
/*==============================================================*/
create table T_MENU
(
   ID                   INT not null auto_increment comment '主键',
   NAME                 VARCHAR(50) comment '菜单名称',
   PARENT_ID            INT not null comment '父级ID',
   URL                  VARCHAR(200) comment '路径',
   SERIAL_NUM           INT not null comment '序号',
   STATUS               TINYINT not null comment '状态 0-无效 1-有效',
   REMARK               VARCHAR(2000) comment '备注',
   CREATOR              INT not null comment '创建人',
   CREATE_TIME          DATETIME not null comment '创建时间',
   UPDATE_PERSON        INT not null comment '更新人',
   UPDATE_TIME          DATETIME not null comment '更新时间',
   VERSION              SMALLINT not null comment '版本',
   primary key (ID)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8
comment = '菜单表';

/*==============================================================*/
/* Table: T_MESSAGE                                             */
/*==============================================================*/
create table T_MESSAGE
(
   ID                   INT not null auto_increment comment '主键',
   NAME                 VARCHAR(50) comment '留言人',
   CONTENT              VARCHAR(2000) comment '内容',
   AVATAR               VARCHAR(200) comment '头像',
   STATUS               TINYINT not null comment '状态 0-无效 1-有效',
   CREATOR              INT not null comment '创建人',
   CREATE_TIME          DATETIME not null comment '创建时间',
   UPDATE_PERSON        INT not null comment '更新人',
   UPDATE_TIME          DATETIME not null comment '更新时间',
   VERSION              SMALLINT not null comment '版本',
   primary key (ID)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8
comment = '留言表';

/*==============================================================*/
/* Table: T_REL_ROLE_MENU                                       */
/*==============================================================*/
create table T_REL_ROLE_MENU
(
   ID                   INT not null auto_increment comment '主键',
   ROLE_ID              INT not null comment '角色ID',
   MENU_ID              INT not null comment '菜单ID',
   CREATOR              INT not null comment '创建人',
   CREATE_TIME          DATETIME not null comment '创建时间',
   UPDATE_PERSON        INT not null comment '更新人',
   UPDATE_TIME          DATETIME not null comment '更新时间',
   VERSION              SMALLINT not null comment '版本',
   primary key (ID)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8
comment = '角色-菜单关联表';

/*==============================================================*/
/* Table: T_REL_USER_ROLE                                       */
/*==============================================================*/
create table T_REL_USER_ROLE
(
   ID                   INT not null auto_increment comment '主键',
   USER_ID              INT not null comment '用户ID',
   ROLE_ID              INT not null comment '角色ID',
   CREATOR              INT not null comment '创建人',
   CREATE_TIME          DATETIME not null comment '创建时间',
   UPDATE_PERSON        INT not null comment '更新人',
   UPDATE_TIME          DATETIME not null comment '更新时间',
   VERSION              SMALLINT not null comment '版本',
   primary key (ID)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8
comment = '用户-角色关联表';

/*==============================================================*/
/* Table: T_ROLE                                                */
/*==============================================================*/
create table T_ROLE
(
   ID                   INT not null auto_increment comment '主键',
   NAME                 VARCHAR(50) comment '角色名',
   STATUS               TINYINT not null comment '状态 0-无效 1-有效',
   REMARK               VARCHAR(2000) comment '备注',
   CREATOR              INT not null comment '创建人',
   CREATE_TIME          DATETIME not null comment '创建时间',
   UPDATE_PERSON        INT not null comment '更新人',
   UPDATE_TIME          DATETIME not null comment '更新时间',
   VERSION              SMALLINT not null comment '版本',
   primary key (ID)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8
comment = '角色表';

/*==============================================================*/
/* Table: T_USER                                                */
/*==============================================================*/
create table T_USER
(
   ID                   INT not null auto_increment comment '主键',
   USER_NAME            VARCHAR(50) comment '用户名',
   PASSWORD             VARCHAR(50) comment '密码',
   NICKNAME             VARCHAR(50) comment '昵称',
   REAL_NAME            VARCHAR(50) comment '真实姓名',
   PHONE                VARCHAR(50) comment '手机号码',
   EMAIL                VARCHAR(200) comment '邮箱',
   STATUS               TINYINT not null comment '状态 0-无效 1-有效',
   REMARK               VARCHAR(2000) comment '备注',
   CREATOR              INT not null comment '创建人',
   CREATE_TIME          DATETIME not null comment '创建时间',
   UPDATE_PERSON        INT not null comment '更新人',
   UPDATE_TIME          DATETIME not null comment '更新时间',
   VERSION              SMALLINT not null comment '版本',
   primary key (ID)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8
comment = '用户表';
