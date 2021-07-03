/*
目标：创建一个school数据库
创建学生表（列，子段） 使用SQL创建
学生int 登陆密码varchar（20）姓名，性别varchar（2），出生日期（datetime），家庭住址，email
*/

/*表的名称和字段尽量使用``
   字符串使用单引号括起来
*/
CREATE TABLE IF NOT EXISTS `grade`(
`gradeid` INT NOT NULL AUTO_INCREMENT COMMENT '年级id',
`gradename` VARCHAR(50) NOT NULL COMMENT '年级名称',
PRIMARY KEY (`gradeid`)
)ENGINE = INNODB DEFAULT CHARSET = utf8mb4;

CREATE TABLE IF NOT EXISTS `student`(
 `id` INT NOT NULL AUTO_INCREMENT COMMENT '学号',
 `password` VARCHAR(20) NOT NULL DEFAULT '123456' COMMENT '密码',
 `name` VARCHAR(20) NOT NULL DEFAULT '匿名' COMMENT '姓名',
 `gender` VARCHAR(2) NOT NULL DEFAULT '男' COMMENT '性别',
 `birthday` DATETIME DEFAULT NULL COMMENT '出生日期',
 `gradeid` INT NOT NULL COMMENT '学生年级',
 `address` VARCHAR(100) DEFAULT NULL COMMENT '家庭住址',
 `email` VARCHAR(30) DEFAULT NULL COMMENT '邮箱',
 
 /*设置主键 primary key:一般一个表只有一个唯一的主键*/
 PRIMARY KEY(`id`)
 
)ENGINE = INNODB DEFAULT CHARSET = utf8mb4;


# alter table 表 add constraint 约束名 foreign key（作为外键的列） references 那个表（哪个字段）;
ALTER TABLE `student`
ADD CONSTRAINT `FK_gradeid` FOREIGN KEY(`gradeid`) REFERENCES `grade`(`gradeid`);

SHOW CREATE DATABASE school; /*查看创建数据库的语句*/
SHOW CREATE TABLE student; /*查看创建数据表的定义语句*/
DESC student; /*查看表的结构*/





