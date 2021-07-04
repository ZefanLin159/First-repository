
#指定表（一定要加条件，不然就跑路了）
UPDATE `student` SET `name`='狂神' WHERE id = 1;

# update `student` set `name`='跑路',会改动所有名字

# 修改多个属性

UPDATE `student` SET `name` ='狂神',`email`= '22222222@qq.com' WHERE id =1;

#删除数据(避免这样写）
DELETE FROM `student` WHERE id = 8;

CREATE TABLE IF NOT EXISTS`test`(
 `id` INT NOT NULL AUTO_INCREMENT COMMENT '测试id',
 `coll` VARCHAR(20) NOT NULL,
 PRIMARY KEY(`id`)
)ENGINE = INNODB DEFAULT CHARSET = utf8mb4;

INSERT INTO `test`(`coll`) VALUES('123'),('456'),('789');
DELETE FROM `test`; #清空表不影响自增
TRUNCATE TABLE `test`;#清空表影响自增,自增归0
INSERT INTO `test`(`coll`) VALUES('123'),('456'),('789');
