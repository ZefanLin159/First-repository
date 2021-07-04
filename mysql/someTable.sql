CREATE DATABASE IF NOT EXISTS `school`;
-- 创建一个school数据库
USE `school`;-- 创建学生表
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`(
    `studentno` INT NOT NULL AUTO_INCREMENT COMMENT '学号',
    `loginpwd` VARCHAR(20) DEFAULT NULL COMMENT '密码',
    `studentname` VARCHAR(20) DEFAULT NULL COMMENT '学生姓名',
    `sex` TINYINT DEFAULT NULL COMMENT '性别，0或1',
    `gradeid` INT DEFAULT NULL COMMENT '年级编号',
    `phone` VARCHAR(50) NOT NULL COMMENT '联系电话，允许为空',
    `address` VARCHAR(255) NOT NULL COMMENT '地址，允许为空',
    `borndate` DATETIME DEFAULT NULL COMMENT '出生时间',
    `email` VARCHAR (50) NOT NULL COMMENT '邮箱账号允许为空',
    `identitycard` VARCHAR(18) DEFAULT NULL COMMENT '身份证号',
    PRIMARY KEY (`studentno`),
    UNIQUE KEY `identitycard`(`identitycard`),
    KEY `email` (`email`)
)ENGINE=MYISAM DEFAULT CHARSET=utf8mb4;

-- 创建年级表
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`(
  `gradeid` INT NOT NULL AUTO_INCREMENT COMMENT '年级编号',
  `gradename` VARCHAR(50) NOT NULL COMMENT '年级名称',
    PRIMARY KEY (`gradeid`)
) ENGINE=INNODB AUTO_INCREMENT = 6 DEFAULT CHARSET = utf8mb4;

-- 创建科目表
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject`(
`subjectno`int not null auto_increment comment '课程编号',
`subjectname` varchar(50) default null comment '课程名称',
`classhour` int default null comment '学时',
`gradeid` int default null comment '年级编号',
 primary key (`subjectno`)
)engine = innodb auto_increment = 19 default charset = utf8mb4;

-- 创建成绩表
drop table if exists `result`;
create table `result`(
`borndate`    `subjectno` int not null comment '课程编号',
    `examdate` datetime not null comment '考试日期',
    `studentresult` int  not null comment '考试成绩',
    key `subjectno` (`subjectno`)
)engine = innodb default charset = utf8mb4;


-- 插入学生数据 其余自行添加 这里只添加了2行
insert into `student` (`loginpwd`,`studentname`,`sex`,`gradeid`,`phone`,`address`,`borndate`,`email`,`identitycard`)
values
('123456','张伟',0,2,'13800001234','北京朝阳','1980-1-1', 'text123@qq.com','123456198001011234'),
('123456','赵强',1,3,'13800002222','广东深圳','1995-1-2', 'text111@qq.com','123456199001011233'),
('123456','张三',1,4,'13800002223','广东汕头','1990-1-30','text132@qq.com','156756199001301233'),
('456999','李四',1,3,'13800002223','安徽合肥','1992-2-28','text000@qq.com','156756199202281233'),
('346546','王五',1,2,'13800002223','广东汕尾','1993-4-11','text567@qq.com','156756199304111233'),
('564645','赵六',1,3,'13800002223','广西南宁','1996-5-22','text134@qq.com','156756199605221233'),
('766523','林奚',0,2,'13800002223','广东普宁','1995-6-16','text456@qq.com','156756199506161233'),
('654313','王八',1,2,'13800002223','广东揭阳','1991-7-3', 'text146@qq.com','156756199107031233');

update `student` set address = '' where `studentno` = 11;
update `student` set `borndate`=null where `studentno` =11;
update  `student` SET `gradeid`=2 WHERE `studentno` =11;

DELETE FROM `school`.`student` WHERE `studentno` = '9'; 
DELETE FROM `school`.`student` WHERE `studentno` = '10'; 

truncate table `result`;
-- 插入成绩数据  这里仅插入了一组，其余自行添加
insert into `result`(`studentno`,`subjectno`,`examdate`,`studentresult`)
values
(1,2,'2013-11-11 16:00:00',85),
(1,6,'2013-11-12 16:00:00',70),
(1,10,'2013-11-11 09:00:00',68),
(1,14,'2013-11-13 16:00:00',98);

INSERT INTO `result`(`studentno`,`subjectno`,`examdate`,`studentresult`)
VALUES
(2,3,'2013-11-11 16:00:00',78),
(2,7,'2013-11-12 16:00:00',88),
(2,11,'2013-11-11 09:00:00',88),
(2,15,'2013-11-13 16:00:00',81);

INSERT INTO `result`(`studentno`,`subjectno`,`examdate`,`studentresult`)
VALUES
(3,4,'2013-11-11 16:00:00',78),
(3,8,'2013-11-12 16:00:00',88),
(3,12,'2013-11-11 09:00:00',68),
(3,16,'2013-11-13 16:00:00',81);

INSERT INTO `result`(`studentno`,`subjectno`,`examdate`,`studentresult`)
VALUES
(4,3,'2013-11-11 16:00:00',78),
(4,7,'2013-11-12 16:00:00',88),
(4,11,'2013-11-11 09:00:00',68),
(4,15,'2013-11-13 16:00:00',81);

INSERT INTO `result`(`studentno`,`subjectno`,`examdate`,`studentresult`)
VALUES
(5,2,'2013-11-11 16:00:00',85),
(5,6,'2013-11-12 16:00:00',70),
(5,10,'2013-11-11 09:00:00',68),
(5,14,'2013-11-13 16:00:00',98);

INSERT INTO `result`(`studentno`,`subjectno`,`examdate`,`studentresult`)
VALUES
(6,3,'2013-11-11 16:00:00',88),
(6,7,'2013-11-12 16:00:00',99),
(6,11,'2013-11-11 09:00:00',98),
(6,15,'2013-11-13 16:00:00',81);

INSERT INTO `result`(`studentno`,`subjectno`,`examdate`,`studentresult`)
VALUES
(7,2,'2013-11-11 16:00:00',100),
(7,6,'2013-11-12 16:00:00',76),
(7,10,'2013-11-11 09:00:00',98),
(7,14,'2013-11-13 16:00:00',98);
INSERT INTO `result`(`studentno`,`subjectno`,`examdate`,`studentresult`)
VALUES
(8,2,'2013-11-11 16:00:00',85),
(8,6,'2013-11-12 16:00:00',70),
(8,10,'2013-11-11 09:00:00',68),
(8,14,'2013-11-13 16:00:00',98);


-- 插入年级数据
insert into `grade` (`gradeid`,`gradename`) values(1,'大一'),(2,'大二'),(3,'大三'),(4,'大四'),(5,'预科班');

-- 插入科目数据
insert into `subject`(`subjectno`,`subjectname`,`classhour`,`gradeid`)values
(1,'高等数学-1',110,1),
(2,'高等数学-2',110,2),
(3,'高等数学-3',100,3),
(4,'高等数学-4',130,4),
(5,'C语言-1',110,1),
(6,'C语言-2',110,2),
(7,'C语言-3',100,3),
(8,'C语言-4',130,4),
(9,'Java程序设计-1',110,1),
(10,'Java程序设计-2',110,2),
(11,'Java程序设计-3',100,3),
(12,'Java程序设计-4',130,4),
(13,'数据库结构-1',110,1),
(14,'数据库结构-2',110,2),
(15,'数据库结构-3',100,3),
(16,'数据库结构-4',130,4),
(17,'C#基础',130,1)



