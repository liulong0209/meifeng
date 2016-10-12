# Host: localhost  (Version: 5.6.25)
# Date: 2016-10-12 19:11:39
# Generator: MySQL-Front 5.3  (Build 4.13)

/*!40101 SET NAMES utf8 */;

#
# Source for table "action_log"
#

CREATE TABLE `action_log` (
  `ACTION_LOG_ID` bigint(20) NOT NULL COMMENT '操作标识',
  `LOGIN_LOG_ID` bigint(20) NOT NULL,
  `SYS_USER_ID` bigint(20) NOT NULL COMMENT '系统用户标识',
  `ACTION_TYPE` varchar(2) COLLATE utf8_unicode_ci NOT NULL COMMENT '操作类型 A 增加\r\n            M 修改\r\n            D 删除\r\n            O 启用\r\n            C 禁用\r\n            Q 查询',
  `ACTION_TEXT` varchar(1024) COLLATE utf8_unicode_ci NOT NULL COMMENT '操作内容 由程序员组织',
  `SYS_TEXT` varchar(4000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '系统内容 建议保存基础数据的增加，修改，启用执行的SQL语句或者进行系统相关查询时的查询条件等',
  `ACTION_TIME` datetime NOT NULL COMMENT '操作时间',
  `MENU_ID` int(11) NOT NULL,
  `MENU_URL` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ACTION_LOG_ID`,`LOGIN_LOG_ID`),
  KEY `IDX_ACTION_LOG_SYS_USER_ID` (`SYS_USER_ID`),
  KEY `IDX_ACTION_LOG_ACTION_TIME` (`ACTION_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户操作日志';

#
# Data for table "action_log"
#


#
# Source for table "app_table"
#

CREATE TABLE `app_table` (
  `APP_TABLE_ID` bigint(20) NOT NULL COMMENT '应用实体标识',
  `USER_NAME` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `TABLE_NAME` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '物理表名',
  `NAME` varchar(128) COLLATE utf8_unicode_ci NOT NULL COMMENT '中文表名',
  `STRUCURE_TYPE` varchar(8) COLLATE utf8_unicode_ci NOT NULL COMMENT '结构类型 H 横表\r\n            V 纵表\r\n            ',
  `STS` char(1) COLLATE utf8_unicode_ci NOT NULL COMMENT '状态 A 在用\r\n            P 注销',
  `STS_DATE` datetime NOT NULL COMMENT '状态时间',
  `REMARKS` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`APP_TABLE_ID`),
  KEY `IDX_SYS_LABLE_KEY2` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='应用实体 应用系统中所涉及到的实体';

#
# Data for table "app_table"
#


#
# Source for table "app_table_column"
#

CREATE TABLE `app_table_column` (
  `APP_TABLE_COLUMN_ID` bigint(20) NOT NULL COMMENT '应用实体字段标识',
  `APP_TABLE_ID` bigint(20) DEFAULT NULL COMMENT '应用实体标识',
  `COLUMN_NAME` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '物理字段',
  `NAME` varchar(128) COLLATE utf8_unicode_ci NOT NULL COMMENT '字段名称',
  `SORT_POSITION` int(11) DEFAULT NULL COMMENT '字段位置',
  `PRIMARY_KEY` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '是否主键',
  `SEQUEUE_NAME` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '关联序列',
  `FOREIGN_KEY` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '是否外键',
  `NULLABLE` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '是否可空',
  `IS_UNIQUE` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '是否唯一',
  `DATA_TYPE` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '数据类型',
  `DATA_LENGTH` int(11) DEFAULT NULL COMMENT '数据长度',
  `DATA_PRECISION` int(11) DEFAULT NULL COMMENT '数据精度',
  `VALUE_EXPRESS` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '取值规则',
  `DATA_DEFAULT` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '默认值',
  `STS` char(1) COLLATE utf8_unicode_ci NOT NULL COMMENT '状态 A 在用\r\n            P 注销',
  `STS_DATE` datetime NOT NULL COMMENT '状态时间',
  `REMARKS` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`APP_TABLE_COLUMN_ID`),
  KEY `IDX_SYS_LABLE_KEY3` (`NAME`),
  KEY `FK_APP_TABL_REF_APP_TABL` (`APP_TABLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='应用实体字段';

#
# Data for table "app_table_column"
#


#
# Source for table "area"
#

CREATE TABLE `area` (
  `AREA_ID` bigint(20) NOT NULL COMMENT '区域标识',
  `PARENT_ID` bigint(20) DEFAULT NULL COMMENT '区域标识',
  `AREA_SPEC_ID` bigint(20) NOT NULL COMMENT '区域规格',
  `CODE` varchar(128) COLLATE utf8_unicode_ci NOT NULL COMMENT '区域编码',
  `NAME` varchar(128) COLLATE utf8_unicode_ci NOT NULL COMMENT '区域名称',
  `ABBR` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '名称缩写 名称的首字母缩写',
  `SORT_POSITION` int(11) NOT NULL COMMENT '排序位置',
  `IS_CENTER` char(1) COLLATE utf8_unicode_ci NOT NULL COMMENT '是否中心区域 Y 是\r\n            N 否\r\n            \r\n            ',
  `LONGITUDE` decimal(24,16) DEFAULT NULL COMMENT '经度',
  `LATITUDE` decimal(24,16) DEFAULT NULL COMMENT '纬度',
  `GEO_AREA_ID` bigint(20) DEFAULT NULL,
  `FULL_NAME` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '全名 等于“上级区域全名->本节点名称”；例：河北省->石家庄',
  `REMARKS` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  `STS` char(1) COLLATE utf8_unicode_ci NOT NULL,
  `STS_DATE` datetime NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  PRIMARY KEY (`AREA_ID`),
  KEY `NAME` (`NAME`),
  KEY `FK_R_AREA_TREE` (`PARENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='区域 主要是地域资源中的管理区域，用于运营商基于此将所管辖区域分层、分级进行管理。根据区域的规格，区域可泛指省份、本地网';

#
# Data for table "area"
#


#
# Source for table "area_spec"
#

CREATE TABLE `area_spec` (
  `AREA_SPEC_ID` varchar(32) NOT NULL,
  `CODE` varchar(128) DEFAULT NULL COMMENT '规格编码',
  `NAME` varchar(128) NOT NULL COMMENT '规格名称',
  `PARENT_ID` varchar(32) NOT NULL COMMENT '上级规格标识',
  `SORT_POSITION` decimal(4,0) NOT NULL DEFAULT '0' COMMENT '排序位置',
  `STS` varchar(1) NOT NULL DEFAULT 'A' COMMENT '状态 A 在用\n            P 注销',
  `STS_DATE` datetime NOT NULL COMMENT '状态时间',
  `REMARKS` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`AREA_SPEC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='区域规格 用于定义将在系统中进行管理的区域的规格，便于通过区域规格，识别出不同类型的区域，如本地网、服务区等行政区域，如';

#
# Data for table "area_spec"
#


#
# Source for table "bulletin"
#

CREATE TABLE `bulletin` (
  `BULLETIN_ID` bigint(20) NOT NULL COMMENT '公告标识',
  `TITLE` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '标题',
  `TYPE` char(1) COLLATE utf8_unicode_ci NOT NULL COMMENT '消息类型 B 业务公告\r\n            P 产品公告',
  `AREA_ID` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '可见区域 预留，暂时不用',
  `CONTENT` varchar(4000) COLLATE utf8_unicode_ci NOT NULL COMMENT '内容',
  `CREATER` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '发布人',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  `RELEASE_DATE` datetime NOT NULL COMMENT '发布时间',
  `END_DATE` datetime NOT NULL COMMENT '截止时间',
  `STS` char(1) COLLATE utf8_unicode_ci NOT NULL COMMENT '状态 A 在用\r\n            P 注销',
  `STS_DATE` datetime NOT NULL COMMENT '状态时间',
  PRIMARY KEY (`BULLETIN_ID`),
  KEY `IDX_BULLETIN_AREA_ID` (`AREA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='系统公告';

#
# Data for table "bulletin"
#


#
# Source for table "bulletin_attachment"
#

CREATE TABLE `bulletin_attachment` (
  `BULLETIN_ATTACHMENT_ID` bigint(20) NOT NULL COMMENT '公告附件标识',
  `BULLETIN_ID` bigint(20) NOT NULL COMMENT '公告标识',
  `FILE_NAME` varchar(128) COLLATE utf8_unicode_ci NOT NULL COMMENT '文件名',
  `ATTACHMENT` longblob COMMENT '附件内容',
  `STS` char(1) COLLATE utf8_unicode_ci NOT NULL COMMENT '状态 A 在用\r\n            P 作废',
  `STS_DATE` datetime NOT NULL COMMENT '状态时间',
  `REMARKS` varchar(512) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`BULLETIN_ATTACHMENT_ID`),
  KEY `IDX_BUL_ATTACH_BUL_ID` (`BULLETIN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='系统公告附件';

#
# Data for table "bulletin_attachment"
#


#
# Source for table "com_type_operator"
#

CREATE TABLE `com_type_operator` (
  `COM_TYPE_OPERATOR_ID` int(9) NOT NULL,
  `COM_TYPE` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'URL：弹出一个单独界面；\r\n                        TEXT_INPUT_BT：文本范围输入框；\r\n                        DATE_INPUT_BT：时间范围输入框，需用时间控件；\r\n                        TEXT_INPUT:文本输入框\r\n                        CHECK_INPUT：复选选择框，可允许选择多个值；\r\n                        SELECT_INPUT：下拉框，只',
  `OPERATOR` varchar(4) COLLATE utf8_unicode_ci NOT NULL,
  `STS` char(1) COLLATE utf8_unicode_ci NOT NULL COMMENT 'A：可见\r\n                        P：不可见',
  `STS_DATE` datetime NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  PRIMARY KEY (`COM_TYPE_OPERATOR_ID`),
  KEY `IDX_OPERATOR` (`OPERATOR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='组件类型：固定的几种，在程序中写死；\r\n运算符：固定的几种，也是在程序中写死\r\n之间的';

#
# Data for table "com_type_operator"
#


#
# Source for table "data_cache_config"
#

CREATE TABLE `data_cache_config` (
  `DATA_CACHE_CONFIG_ID` int(6) NOT NULL,
  `TABLE_NAME` varchar(32) NOT NULL,
  `CACHE_ID` varchar(32) NOT NULL,
  `CACHE_VALUE` varchar(32) NOT NULL,
  `CONDITIONS` varchar(256) DEFAULT NULL,
  `CONDITION_VALUE` varchar(32) DEFAULT NULL,
  `ORDER_ID` varchar(32) DEFAULT NULL,
  `HASH_MAP` varchar(32) DEFAULT NULL,
  `PARENT_ID` int(6) DEFAULT NULL,
  `TREE_FLAG` varchar(1) DEFAULT 'N',
  `STS` varchar(1) NOT NULL DEFAULT 'A',
  `STS_DATE` date NOT NULL,
  `REMARKS` varchar(512) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "data_cache_config"
#


#
# Source for table "data_source"
#

CREATE TABLE `data_source` (
  `DATA_SOURCE_ID` int(9) NOT NULL,
  `DATA_SOURCE_TYPE` varchar(30) COLLATE utf8_unicode_ci NOT NULL COMMENT 'DataSource\r\n                        JNDI\r\n                        JDBC Url',
  `DATA_SOURCE_NAME` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `REMARKS` varchar(512) COLLATE utf8_unicode_ci NOT NULL,
  `DATABASE_TYPE` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'ORACLE\r\n                        SYSBASE\r\n                        DB2\r\n                        ......',
  `JDBCURL` varchar(512) COLLATE utf8_unicode_ci DEFAULT NULL,
  `JDBC_USERNAME` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `JDBC_PASSWORD` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STS` char(1) COLLATE utf8_unicode_ci NOT NULL COMMENT 'A：可见\r\n                        P：不可见',
  `STS_DATE` datetime NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  PRIMARY KEY (`DATA_SOURCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Data for table "data_source"
#


#
# Source for table "factor"
#

CREATE TABLE `factor` (
  `factor_id` int(11) NOT NULL,
  `NAME` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `COM_TYPE` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `DATA_TYPE` varchar(30) COLLATE utf8_unicode_ci NOT NULL COMMENT 'DATE：时间类型\r\n                        NUMBER：数字类型\r\n                        VARCHAR：字符/字符串类型',
  `TIPS_DESC` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `FACTOR_DESC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STS` char(1) COLLATE utf8_unicode_ci NOT NULL COMMENT 'A：可见\r\n                        P：不可见',
  `STS_DATE` datetime NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  PRIMARY KEY (`factor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='初始化界面展现组件类型说明：\r\nINPUT_TEXT        普通文本框\r\nIN';

#
# Data for table "factor"
#


#
# Source for table "factor_rel"
#

CREATE TABLE `factor_rel` (
  `REL_FACTOR_ID` int(11) NOT NULL,
  `REPORT_ID` bigint(19) DEFAULT NULL,
  `REPORT_FACTOR_ID` bigint(19) DEFAULT NULL,
  `REP_REPORT_FACTOR_ID` bigint(19) DEFAULT NULL,
  `REL_TYPE` char(1) COLLATE utf8_unicode_ci NOT NULL COMMENT 'D：依赖\r\n                        E：互斥\r\n                        M：映射\r\n                        B：捆绑',
  `REL_CONDITION` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STS` char(1) COLLATE utf8_unicode_ci NOT NULL COMMENT 'A：可见\r\n                        P：不可见',
  `STS_DATE` datetime NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  PRIMARY KEY (`REL_FACTOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Data for table "factor_rel"
#


#
# Source for table "handle_type"
#

CREATE TABLE `handle_type` (
  `handle_type_ID` int(11) NOT NULL,
  `NAME` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '名称',
  `STS` char(1) COLLATE utf8_unicode_ci NOT NULL COMMENT '状态 A 在用\r\n            P 注销',
  `STS_DATE` datetime NOT NULL COMMENT '状态时间',
  PRIMARY KEY (`handle_type_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='操作类型';

#
# Data for table "handle_type"
#


#
# Source for table "login_log"
#

CREATE TABLE `login_log` (
  `login_log_ID` int(11) NOT NULL,
  `SYS_USER_ID` bigint(20) NOT NULL COMMENT '系统用户标识',
  `LOGIN_CLIENT` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '登录的客户端系统',
  `IP_ADDR` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '来自IP 登录计算机IP地址',
  `MAC_ADDR` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'MAC地址 计算机的MAC地址',
  `LOGIN_TIME` datetime NOT NULL COMMENT '登录时间',
  `LOGOUT_TIME` datetime DEFAULT NULL COMMENT '登出时间',
  PRIMARY KEY (`login_log_ID`),
  KEY `IDX_LOGIN_LOG_SYS_USER_ID` (`SYS_USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户登录日志';

#
# Data for table "login_log"
#


#
# Source for table "menu"
#

CREATE TABLE `menu` (
  `menu_ID` int(11) NOT NULL,
  `MENU_CATALOG_ID` int(11) NOT NULL,
  `MENU_NAME` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `MENU_CODE` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `MENU_DESC` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MENU_URL` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `STS` char(1) COLLATE utf8_unicode_ci NOT NULL,
  `STS_DATE` datetime NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `ORDER_NO` int(11) DEFAULT NULL,
  PRIMARY KEY (`menu_ID`),
  KEY `FK_R_MENU_MENU_CATALOG` (`MENU_CATALOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Data for table "menu"
#


#
# Source for table "menu_catalog"
#

CREATE TABLE `menu_catalog` (
  `menu_catalog_ID` int(11) NOT NULL,
  `PARENT_CATALOG_ID` int(11) DEFAULT NULL,
  `CATALOG_NAME` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `STS` char(1) COLLATE utf8_unicode_ci NOT NULL,
  `STS_DATE` datetime NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `ORDER_NO` int(11) DEFAULT NULL,
  `CATALOG_CODE` varchar(8) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'PC' COMMENT '菜单分类编码',
  PRIMARY KEY (`menu_catalog_ID`),
  KEY `FK_R_MENU_CATALOG_TREE` (`PARENT_CATALOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Data for table "menu_catalog"
#


#
# Source for table "menu_operation"
#

CREATE TABLE `menu_operation` (
  `menu_operation_ID` int(11) NOT NULL,
  `OPERATION_ID` int(11) NOT NULL,
  `MENU_ID` int(11) NOT NULL,
  `DEFAULT_SELECTED` char(1) COLLATE utf8_unicode_ci NOT NULL,
  `STS` char(1) COLLATE utf8_unicode_ci NOT NULL,
  `STS_DATE` datetime NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  PRIMARY KEY (`menu_operation_ID`),
  KEY `FK_R_MENU_OPER_OPERATIONS` (`OPERATION_ID`),
  KEY `FK_R_MENU_OPER_MENU` (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Data for table "menu_operation"
#


#
# Source for table "message"
#

CREATE TABLE `message` (
  `message_ID` int(11) NOT NULL,
  `SYS_USER_ID` int(9) DEFAULT NULL COMMENT '用户标识',
  `CONTENT` varchar(4000) NOT NULL COMMENT '消息内容',
  `MSG_STS` varchar(1) NOT NULL COMMENT '消息状态 D 未查看，R已查看',
  `CREATE_DATE` date NOT NULL COMMENT '创建时间',
  `STS` char(1) NOT NULL DEFAULT 'A' COMMENT '消息状态',
  `STS_DATE` datetime NOT NULL COMMENT '状态时间',
  PRIMARY KEY (`message_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "message"
#


#
# Source for table "msg"
#

CREATE TABLE `msg` (
  `msg_ID` int(11) NOT NULL,
  `MSG_GROUP_ID` varchar(32) DEFAULT NULL COMMENT '消息组',
  `NOTIFY_OBJECT` varchar(32) NOT NULL COMMENT '接收消息对象',
  `TITLE` varchar(256) DEFAULT NULL COMMENT '消息标题',
  `CONTENT` varchar(1024) NOT NULL COMMENT '消息内容',
  `MSG_SCENE_ID` varchar(64) NOT NULL COMMENT '消息场景',
  `FROM_SYSTEM` varchar(32) NOT NULL COMMENT '消息来源',
  `BUSINESS_ID` varchar(64) NOT NULL COMMENT '业务标识',
  `BUSINESS_TYPE` varchar(32) NOT NULL COMMENT '业务类型',
  `ACT_TYPE` varchar(32) DEFAULT NULL COMMENT '动作类型',
  `ERR_CODE` varchar(64) DEFAULT NULL COMMENT '错误编码',
  `ERR_MSG` varchar(256) DEFAULT NULL COMMENT '错误信息',
  `STS` char(1) NOT NULL COMMENT '状态',
  `SEND_DATE` datetime DEFAULT NULL COMMENT '发送时间',
  `CALLBACK_DATE` datetime DEFAULT NULL COMMENT '回调时间',
  `SM_REPORT_DATE` datetime DEFAULT NULL COMMENT '短信报告时间',
  `SM_TRACE_DATE` datetime DEFAULT NULL COMMENT '短信跟踪时间',
  `CRAETE_DATE` datetime NOT NULL COMMENT '创建时间',
  `REMARKS` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`msg_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "msg"
#


#
# Source for table "msg_content"
#

CREATE TABLE `msg_content` (
  `msg_content_ID` int(11) NOT NULL,
  `NAME` varchar(64) NOT NULL COMMENT '名称',
  `TYPE` char(1) NOT NULL COMMENT '类型',
  `BEAN_NAME` varchar(128) DEFAULT NULL COMMENT 'BEAN名称',
  `TITLE` varchar(256) DEFAULT NULL COMMENT '标题',
  `TEXT` varchar(1024) DEFAULT NULL COMMENT '内容',
  `STS` char(1) NOT NULL DEFAULT 'A' COMMENT '状态',
  `STS_DATE` datetime NOT NULL COMMENT '状态时间',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  `REMARKS` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`msg_content_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "msg_content"
#


#
# Source for table "msg_rule"
#

CREATE TABLE `msg_rule` (
  `msg_rule_ID` int(11) NOT NULL,
  `NAME` varchar(32) NOT NULL COMMENT '策略名称',
  `TYPE` char(1) NOT NULL COMMENT '类型',
  `START_TIME` char(5) DEFAULT NULL COMMENT '开始时间',
  `END_TIME` char(5) DEFAULT NULL COMMENT '结束时间',
  `DELAY_TIME` int(11) DEFAULT NULL COMMENT '推迟时间',
  `TIME_INTERVAL` int(11) DEFAULT NULL COMMENT '重发时间间隔',
  `SEND_COUNT` int(11) DEFAULT NULL COMMENT '最大重发次数',
  `CALLBACK` char(1) NOT NULL DEFAULT 'N' COMMENT '是否回调',
  `STS` char(1) NOT NULL DEFAULT 'A' COMMENT '状态',
  `STS_DATE` datetime NOT NULL COMMENT '状态时间',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  `REMARKS` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`msg_rule_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "msg_rule"
#


#
# Source for table "msg_scene"
#

CREATE TABLE `msg_scene` (
  `msg_scene_ID` int(11) NOT NULL,
  `CODE` varchar(32) NOT NULL COMMENT '编码',
  `name` varchar(32) NOT NULL COMMENT '名称',
  `MSG_TYPE` varchar(32) NOT NULL COMMENT '消息方式编码',
  `MSG_RULE_ID` varchar(64) NOT NULL COMMENT '消息策略',
  `MSG_CONTENT_ID` varchar(64) NOT NULL COMMENT '消息内容',
  `STS` char(1) NOT NULL DEFAULT 'A' COMMENT '状态',
  `STS_DATE` datetime NOT NULL COMMENT '状态时间',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  `REMARKS` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`msg_scene_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "msg_scene"
#


#
# Source for table "msg_send_record"
#

CREATE TABLE `msg_send_record` (
  `msg_send_record_ID` int(11) NOT NULL,
  `MSG_ID` varchar(64) NOT NULL COMMENT '消息落地记录标识',
  `SEND_NUM` int(11) NOT NULL COMMENT '当前发送次数',
  `send_result` char(1) DEFAULT NULL COMMENT '发送结果',
  `STS` char(1) NOT NULL COMMENT '状态',
  `STS_DATE` datetime NOT NULL COMMENT '状态时间',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  `REMARKS` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`msg_send_record_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "msg_send_record"
#


#
# Source for table "operate_permission"
#

CREATE TABLE `operate_permission` (
  `operate_permission_ID` int(11) NOT NULL,
  `ROLE_ID` bigint(20) NOT NULL,
  `PERMISSION_ID` bigint(20) NOT NULL,
  `MENU_OPERATION_ID` bigint(20) DEFAULT NULL,
  `CATALOG_OPERATE_TYPE` char(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STS` char(1) COLLATE utf8_unicode_ci NOT NULL,
  `STS_DATE` datetime NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  PRIMARY KEY (`operate_permission_ID`),
  KEY `FK_R_OPER_PERM_ROLES` (`ROLE_ID`),
  KEY `FK_R_OPER_PERM_MENU_OPER` (`MENU_OPERATION_ID`),
  KEY `FK_R_OPER_PERM_PERMISSIONS` (`PERMISSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Data for table "operate_permission"
#


#
# Source for table "operation"
#

CREATE TABLE `operation` (
  `operation_ID` int(11) NOT NULL,
  `OPERATION_NAME` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `OPERATION_CODE` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `STS` char(1) COLLATE utf8_unicode_ci NOT NULL,
  `STS_DATE` datetime NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  PRIMARY KEY (`operation_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Data for table "operation"
#


#
# Source for table "org_type"
#

CREATE TABLE `org_type` (
  `org_type_ID` int(11) NOT NULL,
  `NAME` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '组织机构类型名称',
  `ACRONYM` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '首字母缩写',
  `TYPE` char(1) COLLATE utf8_unicode_ci NOT NULL COMMENT 'X 行政部门\r\n            S 生产部门\r\n            C 监管部门',
  `REMARKS` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  `STS` char(1) COLLATE utf8_unicode_ci NOT NULL,
  `STS_DATE` datetime NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  PRIMARY KEY (`org_type_ID`),
  KEY `IDX_ORG_NAME2` (`NAME`),
  KEY `IDX_ORG_ACRONYM2` (`ACRONYM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='组织机构类型';

#
# Data for table "org_type"
#


#
# Source for table "organization"
#

CREATE TABLE `organization` (
  `ORG_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '机构标识',
  `PARENT_ID` bigint(20) DEFAULT NULL COMMENT '上级机构标识',
  `ORG_TYPE_ID` int(11) NOT NULL COMMENT '组织机构类型标识',
  `AREA_ID` bigint(20) NOT NULL COMMENT '区域标识',
  `NAME` varchar(128) COLLATE utf8_unicode_ci NOT NULL COMMENT '机构名称',
  `ACRONYM` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '首字母缩写',
  `ADDRESS` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '机构地址',
  `POST_CODE` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮政编码',
  `REMARKS` varchar(512) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '机构描述',
  `SORT_POSITION` int(11) NOT NULL COMMENT '排序位置',
  `STS` char(1) COLLATE utf8_unicode_ci NOT NULL,
  `STS_DATE` datetime NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  PRIMARY KEY (`ORG_ID`),
  KEY `IDX_ORG_PARENT_ID` (`PARENT_ID`),
  KEY `IDX_ORG_NAME` (`NAME`),
  KEY `IDX_ORG_ACRONYM` (`ACRONYM`),
  KEY `FK_R_ORG_DEPT_ORG_TYPE` (`ORG_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='组织机构';

#
# Data for table "organization"
#


#
# Source for table "page_layout"
#

CREATE TABLE `page_layout` (
  `page_layout_ID` int(11) NOT NULL,
  `PAGE_LAYOUT_NAME` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '员工标识',
  `THUMBNAIL_ATTACH` longblob NOT NULL COMMENT '机构标识',
  `SETTING` longtext COLLATE utf8_unicode_ci NOT NULL COMMENT '姓名',
  `STS` char(1) COLLATE utf8_unicode_ci NOT NULL,
  `STS_DATE` datetime NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `DESCRIPTION` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`page_layout_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='页面布局的描述信息';

#
# Data for table "page_layout"
#


#
# Source for table "staff"
#

CREATE TABLE `staff` (
  `STAFF_ID` bigint(20) NOT NULL COMMENT '员工标识',
  `ORG_ID` bigint(20) NOT NULL COMMENT '机构标识',
  `NAME` varchar(56) NOT NULL COMMENT '姓名',
  `ACRONYM` varchar(8) DEFAULT NULL COMMENT '首字母缩写 名称的首字母缩写，大写',
  `BIRTHDAY` datetime DEFAULT NULL COMMENT '出生日期 采用YYYYMMDD格式记录出生日期，例如19820101',
  `SEX` char(1) DEFAULT NULL COMMENT '性别 M 男\r\n            W 女',
  `NATIVE_PLACE` varchar(128) DEFAULT NULL COMMENT '籍贯',
  `NATION` varchar(16) DEFAULT NULL COMMENT '民族',
  `ADDRESS` varchar(64) DEFAULT NULL COMMENT '住址',
  `POLITICAL_STATUS` varchar(16) DEFAULT NULL COMMENT '政治面貌',
  `COLLEGE` varchar(64) DEFAULT NULL COMMENT '毕业院校',
  `MAJOR` varchar(64) DEFAULT NULL COMMENT '所学专业',
  `JOB_TITLE` varchar(64) DEFAULT NULL COMMENT '职位',
  `TEL_NBR` varchar(32) DEFAULT NULL COMMENT '联系电话',
  `MAILBOX` varchar(32) DEFAULT NULL COMMENT '公司邮箱',
  `CONTRACT_TYPE` char(1) DEFAULT NULL COMMENT '合同类型 L 终身\r\n            T 临时',
  `WORK_DATE` datetime DEFAULT NULL COMMENT '入职时间',
  `REMARKS` varchar(512) DEFAULT NULL COMMENT '备注',
  `STS` char(1) NOT NULL,
  `STS_DATE` datetime NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `POSITION_NO` varchar(20) DEFAULT NULL COMMENT '员工次序',
  `EMPLOYEE_NO` varchar(20) NOT NULL COMMENT '员工编号',
  `EDUCATION` char(2) DEFAULT NULL COMMENT '教育水平 SS硕士 BK本科 DZ大专 GZ 高中 QT 其他',
  `GRADUATE_DATE` datetime DEFAULT NULL COMMENT '毕业日期',
  `ZIP_CODE` varchar(10) DEFAULT NULL COMMENT '邮政编码',
  `LINKMAN` varchar(20) DEFAULT NULL COMMENT '联系人',
  `MOBILE` varchar(32) DEFAULT NULL,
  `HOME_PHONE` varchar(20) DEFAULT NULL COMMENT '家庭电话',
  `IMEI` varchar(15) DEFAULT NULL COMMENT '手机IMEI码',
  PRIMARY KEY (`STAFF_ID`),
  UNIQUE KEY `IDX_STAFF_ENO` (`EMPLOYEE_NO`) USING BTREE,
  KEY `FK_R_STAFF_ORG` (`ORG_ID`) USING BTREE,
  KEY `IDX_STAFF_NAME` (`NAME`) USING BTREE,
  KEY `IDX_STAFF_ACRONYM` (`ACRONYM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工';

#
# Data for table "staff"
#


#
# Source for table "sys_user"
#

CREATE TABLE `sys_user` (
  `SYS_USER_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '系统用户标识',
  `STAFF_ID` bigint(20) NOT NULL COMMENT '员工标识',
  `LOGIN_NAME` varchar(32) NOT NULL COMMENT '用户登录名',
  `PASSWORD` varchar(128) NOT NULL COMMENT '用户密码 加密存储',
  `PWD_SET_TIME` datetime NOT NULL COMMENT '密码设置时间',
  `PWD_INACTIVE_TIME` datetime NOT NULL COMMENT '密码失效时间',
  `LAST_PWD` varchar(128) DEFAULT NULL COMMENT '前次密码',
  `INIT_PWD_FLAG` char(1) NOT NULL COMMENT '是否初始化密码 Y 是\r\n            N 否\r\n            ',
  `REMARKS` varchar(512) DEFAULT NULL COMMENT '备注',
  `STS` char(1) NOT NULL,
  `STS_DATE` datetime NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  PRIMARY KEY (`SYS_USER_ID`),
  KEY `IDX_SYS_USER_STAFF_ID` (`STAFF_ID`) USING BTREE,
  KEY `IDX_SYS_USER_LOGIN_NAME` (`LOGIN_NAME`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户';

#
# Data for table "sys_user"
#


#
# Source for table "tbl_ads"
#

CREATE TABLE `tbl_ads` (
  `ads_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT '' COMMENT '标题',
  `img_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '图片地址id',
  `order_no` int(11) DEFAULT NULL COMMENT '排序号',
  `state` int(1) NOT NULL DEFAULT '0' COMMENT '发布状态 0、草稿 1、已发布 2、停用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ads_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='广告表';

#
# Data for table "tbl_ads"
#

INSERT INTO `tbl_ads` VALUES (1,'图片1',1,1,1,NULL),(2,'图片2',2,2,1,NULL),(3,'图片3',3,3,1,NULL),(4,'图片4',4,4,1,NULL);

#
# Source for table "tbl_book_region"
#

CREATE TABLE `tbl_book_region` (
  `region_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL COMMENT '标题(配合图片显示)',
  `img_id` bigint(20) DEFAULT NULL COMMENT '图片id',
  `providers_id` bigint(20) DEFAULT NULL COMMENT '公司或团队id',
  PRIMARY KEY (`region_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='预约小区表';

#
# Data for table "tbl_book_region"
#

INSERT INTO `tbl_book_region` VALUES (1,'铭城',1,1),(2,'玫瑰公馆',2,1),(3,'洪福麒麟山',1,1),(4,'金地',2,1),(5,'绿地',1,1);

#
# Source for table "tbl_company_rank"
#

CREATE TABLE `tbl_company_rank` (
  `com_rank_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL COMMENT '标题(配合图片显示)',
  `img_id` bigint(20) DEFAULT NULL COMMENT '图片id',
  `providers_id` bigint(20) DEFAULT NULL COMMENT '公司或团队id',
  PRIMARY KEY (`com_rank_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='公司资质表';

#
# Data for table "tbl_company_rank"
#

INSERT INTO `tbl_company_rank` VALUES (1,NULL,1,1),(2,NULL,2,1),(3,NULL,1,1);

#
# Source for table "tbl_evaluation"
#

CREATE TABLE `tbl_evaluation` (
  `evaluation_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gainer` bigint(20) DEFAULT NULL COMMENT '被评价者',
  `content` varchar(512) DEFAULT NULL COMMENT '评价内容',
  `reviewer` bigint(20) DEFAULT NULL COMMENT '评价者',
  `level` char(1) DEFAULT NULL COMMENT '0 差 1 中 2 好',
  `review_time` datetime NOT NULL,
  PRIMARY KEY (`evaluation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COMMENT='评价表';

#
# Data for table "tbl_evaluation"
#

INSERT INTO `tbl_evaluation` VALUES (1,1,'做工精细，认真负责',1,'2','0000-00-00 00:00:00'),(2,1,'做工细 态度好',1,'2','2016-09-30 16:31:53'),(3,1,'做工细 态度好',1,'2','2016-09-30 16:31:55'),(4,1,'做工细 态度好',1,'2','2016-09-30 16:31:56'),(5,1,'做工细 态度好',1,'2','2016-09-30 16:31:56'),(6,1,'做工细 态度好',1,'2','2016-09-30 16:31:57'),(7,1,'做工细 态度好',1,'2','2016-09-30 16:31:58'),(8,1,'做工细 态度好',1,'2','2016-09-30 16:31:59'),(9,1,'做工细 态度好',1,'2','2016-09-30 16:32:00'),(10,1,'做工细 态度好',1,'2','2016-09-30 16:32:01'),(11,1,'做工细 态度好',1,'2','2016-09-30 16:32:02'),(12,1,'还可以',1,'1','2016-09-30 16:32:38'),(13,1,'还可以',1,'1','2016-09-30 16:32:39'),(14,1,'还可以',1,'1','2016-09-30 16:32:40'),(15,1,'还可以',1,'1','2016-09-30 16:32:40'),(16,1,'还可以',1,'1','2016-09-30 16:32:40'),(17,1,'还可以',1,'1','2016-09-30 16:32:40'),(18,1,'还可以',1,'1','2016-09-30 16:32:40'),(19,1,'还可以',1,'1','2016-09-30 16:32:41'),(20,1,'还可以',1,'1','2016-09-30 16:32:41'),(21,1,'还可以',1,'1','2016-09-30 16:32:41'),(22,1,'还可以',1,'1','2016-09-30 16:32:41'),(23,1,'还可以',1,'1','2016-09-30 16:32:41'),(24,1,'差劲的很',1,'0','2016-09-30 16:32:58'),(25,1,'差劲的很',1,'0','2016-09-30 16:32:59'),(26,1,'差劲的很',1,'0','2016-09-30 16:32:59'),(27,1,'差劲的很',1,'0','2016-09-30 16:32:59'),(28,1,'差劲的很',1,'0','2016-09-30 16:32:59'),(29,1,'差劲的很',1,'0','2016-09-30 16:33:00'),(30,1,'差劲的很',1,'0','2016-09-30 16:33:00'),(31,1,'差劲的很',1,'0','2016-09-30 16:33:00'),(32,1,'差劲的很',1,'0','2016-09-30 16:33:00'),(33,1,'差劲的很',1,'0','2016-09-30 16:33:00'),(34,1,'差劲的很',1,'0','2016-09-30 16:33:00'),(35,1,'差劲的很',1,'0','2016-09-30 16:33:01'),(36,1,'差劲的很',1,'0','2016-09-30 16:33:01'),(37,1,'差劲的很',1,'0','2016-09-30 16:33:01'),(38,1,'差劲的很',1,'0','2016-09-30 16:33:01'),(39,1,'差劲的很',1,'0','2016-09-30 16:33:01'),(40,1,'差劲的很',1,'0','2016-09-30 16:33:01'),(41,1,'还行吧，再看看。。。。',NULL,'1','2016-10-10 14:04:01'),(42,1,'非常好啊....',NULL,'2','2016-10-10 14:12:15'),(43,5,'干活很好 很认真',NULL,'2','2016-10-10 14:46:12');

#
# Source for table "tbl_file_info"
#

CREATE TABLE `tbl_file_info` (
  `file_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `orgin_name` varchar(255) DEFAULT NULL COMMENT '原始名称',
  `file_name` varchar(255) DEFAULT NULL COMMENT '存储名称',
  `file_path` varchar(255) DEFAULT NULL COMMENT '存储路径',
  `creator` int(11) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='文件表';

#
# Data for table "tbl_file_info"
#

INSERT INTO `tbl_file_info` VALUES (1,'banner.jpg','banner.jpg','d:\\temp\\banner.jpg',-1,NULL),(2,'banner2.jpg','banner2.jpg','d:\\temp\\banner2.jpg',-1,NULL),(3,'banner.jpg','banner.jpg','d:\\temp\\banner.jpg',-1,NULL),(4,'banner2.jpg','banner2.jpg','d:\\temp\\banner2.jpg',-1,NULL),(9,'pic8.jpg','pic8.jpg','d:\\temp\\pic8.jpg',-1,NULL),(10,'pic7.jpg','pic7.jpg','d:\\temp\\pic7.jpg',-1,NULL),(11,'mfj1.gif','mfj1.gif','d:\\temp\\mfj1.gif',-1,NULL),(12,'mfj2.gif','mfj2.gif','d:\\temp\\mfj2.gif',-1,NULL);

#
# Source for table "tbl_news"
#

CREATE TABLE `tbl_news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '新闻标题',
  `content` text COMMENT '新闻内容',
  `publish_state` int(1) DEFAULT '0' COMMENT '发布状态 0、草稿 1、已发布 2、过期不显示',
  `publish_time` datetime DEFAULT NULL COMMENT '发布时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='新闻表';

#
# Data for table "tbl_news"
#

INSERT INTO `tbl_news` VALUES (1,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:36','2016-09-14 15:57:36','2016-09-14 15:57:36'),(2,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:36','2016-09-14 15:57:36','2016-09-14 15:57:36'),(3,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:38','2016-09-14 15:57:38','2016-09-14 15:57:38'),(4,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:39','2016-09-14 15:57:39','2016-09-14 15:57:39'),(5,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:39','2016-09-14 15:57:39','2016-09-14 15:57:39'),(6,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:40','2016-09-14 15:57:40','2016-09-14 15:57:40'),(7,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:40','2016-09-14 15:57:40','2016-09-14 15:57:40'),(8,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:41','2016-09-14 15:57:41','2016-09-14 15:57:41'),(9,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:41','2016-09-14 15:57:41','2016-09-14 15:57:41'),(10,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:42','2016-09-14 15:57:42','2016-09-14 15:57:42'),(11,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:42','2016-09-14 15:57:42','2016-09-14 15:57:42'),(12,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:43','2016-09-14 15:57:43','2016-09-14 15:57:43'),(13,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:43','2016-09-14 15:57:43','2016-09-14 15:57:43'),(14,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:43','2016-09-14 15:57:43','2016-09-14 15:57:43'),(15,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:44','2016-09-14 15:57:44','2016-09-14 15:57:44'),(16,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:44','2016-09-14 15:57:44','2016-09-14 15:57:44'),(17,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:44','2016-09-14 15:57:44','2016-09-14 15:57:44'),(18,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:45','2016-09-14 15:57:45','2016-09-14 15:57:45'),(19,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:45','2016-09-14 15:57:45','2016-09-14 15:57:45'),(20,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:46','2016-09-14 15:57:46','2016-09-14 15:57:46'),(21,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:46','2016-09-14 15:57:46','2016-09-14 15:57:46'),(22,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:47','2016-09-14 15:57:47','2016-09-14 15:57:47'),(23,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:47','2016-09-14 15:57:47','2016-09-14 15:57:47'),(24,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:47','2016-09-14 15:57:47','2016-09-14 15:57:47'),(25,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:48','2016-09-14 15:57:48','2016-09-14 15:57:48'),(26,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:48','2016-09-14 15:57:48','2016-09-14 15:57:48'),(27,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:49','2016-09-14 15:57:49','2016-09-14 15:57:49'),(28,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:49','2016-09-14 15:57:49','2016-09-14 15:57:49'),(29,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:50','2016-09-14 15:57:50','2016-09-14 15:57:50'),(30,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:50','2016-09-14 15:57:50','2016-09-14 15:57:50'),(31,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:50','2016-09-14 15:57:50','2016-09-14 15:57:50');

#
# Source for table "tbl_product"
#

CREATE TABLE `tbl_product` (
  `prod_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(32) NOT NULL DEFAULT '' COMMENT '产品名称',
  `product_intro` text NOT NULL COMMENT '产品介绍',
  `product_pic` bigint(20) DEFAULT NULL COMMENT '产品图片id',
  `product_type` bigint(20) NOT NULL COMMENT '产品类别(外联tbl_product_class)',
  `file` varchar(128) DEFAULT NULL COMMENT '资料地址',
  `REMARKS` varchar(512) DEFAULT NULL COMMENT '备注',
  `providers_id` bigint(20) DEFAULT NULL COMMENT '提供商(公司)id',
  `order_no` int(11) DEFAULT NULL COMMENT '排序号',
  `STS` char(1) NOT NULL DEFAULT '' COMMENT '审批状态：默认0；0;没通过；1：通过 2删除',
  `CREATE_DATE` datetime NOT NULL,
  PRIMARY KEY (`prod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='产品信息表';

#
# Data for table "tbl_product"
#

INSERT INTO `tbl_product` VALUES (1,'林大美缝剂','',11,1,NULL,NULL,6,11,'1','0000-00-00 00:00:00'),(2,'林大美缝剂','',11,1,NULL,NULL,6,11,'1','0000-00-00 00:00:00'),(3,'林大美缝剂','',12,1,NULL,NULL,6,1,'1','0000-00-00 00:00:00'),(4,'林大美缝剂','',12,1,NULL,NULL,6,1,'1','0000-00-00 00:00:00'),(5,'卓高真瓷胶8','',11,2,NULL,NULL,6,1,'1','0000-00-00 00:00:00'),(6,'卓高真瓷胶7','',11,2,NULL,NULL,6,2,'1','0000-00-00 00:00:00'),(7,'卓高真瓷胶6','',12,2,NULL,NULL,6,3,'1','0000-00-00 00:00:00'),(8,'卓高真瓷胶5','',11,2,NULL,NULL,6,4,'1','0000-00-00 00:00:00'),(9,'卓高真瓷胶4','',12,2,NULL,NULL,6,5,'1','0000-00-00 00:00:00'),(10,'卓高真瓷胶3','',11,2,NULL,NULL,6,6,'1','0000-00-00 00:00:00'),(11,'卓高真瓷胶2','',12,2,NULL,NULL,6,7,'1','0000-00-00 00:00:00'),(12,'卓高真瓷胶1','',11,2,NULL,NULL,6,8,'1','0000-00-00 00:00:00'),(13,'青花瓷胶枪1','',12,3,NULL,NULL,6,7,'1','0000-00-00 00:00:00'),(14,'青花瓷胶枪2','',12,3,NULL,NULL,6,6,'1','0000-00-00 00:00:00'),(15,'青花瓷胶枪3','',12,3,NULL,NULL,6,2,'1','0000-00-00 00:00:00'),(16,'青花瓷胶枪4','',11,3,NULL,NULL,6,5,'1','0000-00-00 00:00:00'),(17,'青花瓷胶枪5','',11,3,NULL,NULL,6,1,'1','0000-00-00 00:00:00'),(18,'青花瓷胶枪6','',12,3,NULL,NULL,6,3,'1','0000-00-00 00:00:00'),(19,'青花瓷胶枪7','',11,3,NULL,NULL,6,4,'1','0000-00-00 00:00:00');

#
# Source for table "tbl_product_anti_fake"
#

CREATE TABLE `tbl_product_anti_fake` (
  `prod_anti_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL COMMENT '标题',
  `file_id` bigint(20) DEFAULT NULL COMMENT '图片id',
  `providers_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`prod_anti_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品防伪表';

#
# Data for table "tbl_product_anti_fake"
#


#
# Source for table "tbl_product_class"
#

CREATE TABLE `tbl_product_class` (
  `product_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '分类名称',
  `type` int(1) NOT NULL DEFAULT '0' COMMENT '类别类型 0工具 1材料',
  `REMARKS` varchar(512) DEFAULT NULL COMMENT '备注',
  `CREATE_DATE` datetime NOT NULL,
  PRIMARY KEY (`product_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='产品分类表';

#
# Data for table "tbl_product_class"
#

INSERT INTO `tbl_product_class` VALUES (1,'美缝剂',1,NULL,'0000-00-00 00:00:00'),(2,'真瓷胶',1,NULL,'0000-00-00 00:00:00'),(3,'胶枪',0,NULL,'0000-00-00 00:00:00'),(4,'美纹纸',0,NULL,'0000-00-00 00:00:00'),(5,'美工刀',0,NULL,'0000-00-00 00:00:00'),(6,'毛刷',0,NULL,'0000-00-00 00:00:00'),(7,'刮板',0,NULL,'0000-00-00 00:00:00');

#
# Source for table "tbl_providers_extend"
#

CREATE TABLE `tbl_providers_extend` (
  `providers_extend_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `providers_id` bigint(20) DEFAULT NULL,
  `extend_id` bigint(20) DEFAULT NULL,
  `providers_tpye` int(2) NOT NULL DEFAULT '0' COMMENT '扩展信息类型 0施工人员 1施工案例 2预约小区 3公司资质 4工具 5材料',
  `REMARKS` varchar(512) DEFAULT NULL COMMENT '备注',
  `STS` char(1) NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  PRIMARY KEY (`providers_extend_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='提供商扩展信息表';

#
# Data for table "tbl_providers_extend"
#

INSERT INTO `tbl_providers_extend` VALUES (1,6,1,5,NULL,'','0000-00-00 00:00:00'),(2,6,2,5,NULL,'','0000-00-00 00:00:00'),(3,6,3,4,NULL,'','0000-00-00 00:00:00'),(4,6,4,4,NULL,'','0000-00-00 00:00:00');

#
# Source for table "tbl_providers_info"
#

CREATE TABLE `tbl_providers_info` (
  `providers_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `provider_name` varchar(50) DEFAULT NULL COMMENT '提供商名称',
  `profile` varchar(1000) DEFAULT NULL COMMENT '简介',
  `phone_no` varchar(50) DEFAULT NULL COMMENT '电话号码',
  `address` varchar(100) DEFAULT NULL COMMENT '地址(公司是地址  团队或个人就是服务区域)',
  `logo` bigint(20) DEFAULT NULL COMMENT 'logo或者头像id',
  `sts` int(1) DEFAULT NULL COMMENT '状态0 正常 1删除',
  `sts_date` datetime DEFAULT NULL COMMENT '状态修改时间',
  `order_no` int(11) DEFAULT NULL COMMENT '排序号',
  `type` int(1) DEFAULT NULL COMMENT '类型 0公司 1团队 2个人',
  `head` int(11) DEFAULT NULL COMMENT '负责人id',
  `city` int(11) DEFAULT NULL COMMENT '所属城市',
  `serviceType` int(1) DEFAULT NULL COMMENT '提供服务类型 0 提供施工 1提供产品',
  PRIMARY KEY (`providers_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='提供商信息表（公司 团队 个人）';

#
# Data for table "tbl_providers_info"
#

INSERT INTO `tbl_providers_info` VALUES (1,'西安城市人家装修公司','陕西城市人家装饰（集团）有限公司是由国内大型房地产公司及金融投资机构投资的大型家居装饰企业。公司秉承集团总公司倡导的为客户营造“健康家居，健康生活”的服务宗旨，致力于环保、健康家装，并取得了丰硕成果，得到古城百姓的广泛信赖，被称为“健康家居使者”。','400-800-0011转12403','陕西省西安市雁塔区南三环朱雀路交叉口西北角',1,0,NULL,1,0,1,1,0),(2,'西安业之峰装饰公司','西安业之峰装饰公司咨询电话：17791881949 联系我时请说是在装一网上看到的，谢谢！ 业之','400-800-0011转12404','西安市高新科技一路59号（区科技一路与丈八北路丁字路...',2,0,NULL,2,0,2,1,0),(3,'广州潺智信息科技有限公司','政府开发多年开发经验，可人员驻场开发','400-800-0011转12403','陕西省西安市雁塔区南三环朱雀路交叉口西北角',1,0,NULL,3,0,1,1,0),(4,'卓越团队','政府开发多年开发经验，可人员驻场开发','400-800-0011转12404','西安市高新科技一路59号（区科技一路与丈八北路丁字路...',2,0,NULL,1,1,NULL,1,0),(5,'李泽','从事美缝多年，经验丰富','13211111111','西安市高新科技一路59号（区科技一路与丈八北路丁字路...',9,0,NULL,1,2,NULL,1,0),(6,'林大公司','西安林大公司公司咨询电话：17791881949 联系我时请说是在装一网上看到的，谢谢！ 业之','13211111111','西安市高新科技一路59号（区科技一路与丈八北路丁字路...',1,0,NULL,1,0,1,1,1);

#
# Source for table "tbl_work_case"
#

CREATE TABLE `tbl_work_case` (
  `case_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL COMMENT '标题(配合图片显示)',
  `img_id` bigint(20) DEFAULT NULL COMMENT '图片id',
  `providers_id` bigint(20) DEFAULT NULL COMMENT '公司或团队id',
  PRIMARY KEY (`case_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='施工案例表';

#
# Data for table "tbl_work_case"
#

INSERT INTO `tbl_work_case` VALUES (1,'赛高悦府',1,1),(2,'中华世纪城',2,1),(3,'玫瑰公馆',1,1),(4,'中航华府',2,1),(5,'赛高悦府',2,4),(6,'中华世纪城',1,4);

#
# Source for table "tbl_worker"
#

CREATE TABLE `tbl_worker` (
  `worker_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL COMMENT '存储名称',
  `avatar` bigint(20) DEFAULT NULL COMMENT '头像id',
  `providers_id` bigint(20) DEFAULT NULL COMMENT '公司或团队id',
  PRIMARY KEY (`worker_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='施工工人表';

#
# Data for table "tbl_worker"
#

INSERT INTO `tbl_worker` VALUES (1,'小张',9,1),(2,'小王',10,1),(3,'小李',9,1),(4,'小赵',10,1),(5,'果果',9,4),(6,'诺诺',10,4),(7,'糖糖',9,4);
