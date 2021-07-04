-- 查询全部学生 select 字段 from 表 * 通配符 ，这里的例子代表所有字段
SELECT * FROM student;

-- 查询指定字段
SELECT `studentno`,`studentname` FROM student;

-- 别名，给结果起一个名字 AS 给字段起别名，也可以给表起别名

SELECT `studentno` AS 学号,`studentname` AS 学生姓名 FROM `student`;

-- 函数 concat(a,b)

SELECT CONCAT('姓名：',`studentname`) AS 新名字 FROM student;

-- 查询一下哪些同学参加了考试，成绩
SELECT * FROM `result`;

-- 查询有哪些同学参加了考试,同时用 DISTINCT 去重

SELECT DISTINCT `studentno` FROM `result`;

SELECT VERSION(); -- 函数
SELECT 100-1 AS 计算结果 ; -- 用来计算 （表达式）
SELECT @@auto_increment_increment; -- 自增步长 （变量）

-- 学院考试+1分查看
SELECT `studentno`,`studentresult`+1 AS '提分后' FROM result;
SELECT `studentno`,`studentresult`-1 AS '减分后' FROM result;

-- ========================where 子句=================================
SELECT `studentno`,`studentresult` FROM `result`;
-- 查询考试成绩在95-100分之间的
SELECT `studentno`,`studentresult` FROM `result` 
WHERE `studentresult`>=95 AND `studentresult`<=100;

-- 模糊查询（区间）
SELECT `studentno`,`studentresult` FROM `result` 
WHERE `studentresult` BETWEEN 85 AND 100;

-- 除了1号学生之外的成绩
SELECT `studentno`,`studentresult` FROM `result` 
-- where `studentno` != 1;
WHERE NOT `studentno` = 1 AND `studentresult` BETWEEN 90 AND 100;



