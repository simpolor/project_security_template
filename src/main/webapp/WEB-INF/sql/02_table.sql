CREATE TABLE `demo` (
  `seq` INT(11) NOT NULL AUTO_INCREMENT COMMENT '번호',
  `name` VARCHAR(50) NOT NULL COMMENT '이름',
  `age` INT(11) NULL DEFAULT NULL COMMENT '나이',
  `hobby` VARCHAR(50) NULL DEFAULT NULL COMMENT '취미',
  PRIMARY KEY (`seq`)
);

CREATE TABLE `member` (
	`member_id` VARCHAR(20) NOT NULL,
	`member_pw` VARCHAR(500) NOT NULL,
	`member_name` VARCHAR(20) NULL DEFAULT NULL,
	`member_email` VARCHAR(50) NULL DEFAULT NULL,
	`regi_date` DATETIME NULL DEFAULT NULL,
	`modi_date` DATETIME NULL DEFAULT NULL,
	`del_yn` CHAR(1) NULL DEFAULT 'N',
	PRIMARY KEY (`member_id`)
);

CREATE TABLE `member_role` (
	`member_id` VARCHAR(20) NOT NULL,
	`member_role` VARCHAR(50) NOT NULL,
	`regi_id` VARCHAR(20) NULL DEFAULT NULL,
	`regi_name` VARCHAR(50) NULL DEFAULT NULL,
	`regi_date` DATETIME NULL DEFAULT NULL,
	`modi_id` VARCHAR(20) NULL DEFAULT NULL,
	`modi_name` VARCHAR(50) NULL DEFAULT NULL,
	`modi_date` DATETIME NULL DEFAULT NULL,
	`del_yn` CHAR(1) NULL DEFAULT 'N',
	PRIMARY KEY (`member_id`)
);

CREATE TABLE `role` (
	`role_seq` INT(11) NOT NULL AUTO_INCREMENT,
	`role_code` CHAR(10) NOT NULL,
	`role_name` VARCHAR(20) NOT NULL,
	`regi_id` VARCHAR(20) NULL DEFAULT NULL,
	`regi_name` VARCHAR(50) NULL DEFAULT NULL,
	`regi_date` DATETIME NULL DEFAULT NULL,
	`modi_id` VARCHAR(20) NULL DEFAULT NULL,
	`modi_name` VARCHAR(50) NULL DEFAULT NULL,
	`modi_date` DATETIME NULL DEFAULT NULL,
	`del_yn` CHAR(50) NULL DEFAULT 'N',
	PRIMARY KEY (`role_seq`),
	UNIQUE INDEX `UNIQUE KEY` (`role_code`)
);


CREATE TABLE `access` (
	`access_seq` INT(11) NOT NULL AUTO_INCREMENT,
	`access_url` VARCHAR(50) NOT NULL,
	`access_role` VARCHAR(50) NOT NULL,
	`regi_id` VARCHAR(20) NULL DEFAULT NULL,
	`regi_name` VARCHAR(50) NULL DEFAULT NULL,
	`regi_date` DATETIME NULL DEFAULT NULL,
	`modo_id` VARCHAR(20) NULL DEFAULT NULL,
	`modi_name` VARCHAR(50) NULL DEFAULT NULL,
	`modi_date` DATETIME NULL DEFAULT NULL,
	`del_yn` CHAR(50) NULL DEFAULT 'N',
	PRIMARY KEY (`access_seq`),
	UNIQUE INDEX `UNIQUE KEY` (`access_url`)
);


CREATE TABLE `persistent_logins` (
  `username` varchar(64) DEFAULT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) DEFAULT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
);