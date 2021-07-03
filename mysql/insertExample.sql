#插入语句（添加）
#insert into into 表名([字段名1,字段名2,字段名3])values('值1','值2','值3',...)
#自增无需插入

#由于主键自增我们可以忽略（如果不写表的字段，它会一一匹配）
#一般写插入语句，数据和字段一定要一一对应！

INSERT INTO `grade`(`gradename`) VALUES('大四');

#插入多个字段(主键自增)
INSERT INTO `grade`(`gradename`) 
VALUES('大一'),('大二'),('大三');

#insert into into 表名([字段名1,字段名2,字段名3])values('值1','值2','值3',...)
INSERT INTO `student`(`name`) VALUES('张三');#和教程讲的有区别，要设置默认值
INSERT INTO `student`(`name`,`password`,`gender`,`gradeid`)VALUES('沐沐','1234567','未知',1);
INSERT INTO `student`(`name`,`password`,`gender`,`gradeid`)VALUES('李四','aaa','男',2),('老王','bbb','男',3);

INSERT INTO `student`
VALUES(2,'ccc','渣渣','男','2020-01-01',1,'西安','000@qq.com');