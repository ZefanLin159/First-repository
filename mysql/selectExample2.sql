-- ===================模糊查询==================================

-- 查询姓林的同学
-- like 结合 （%代表0到任意个字符 _ 代表一个字符）只能在like中使用
SELECT `studentno`,`studentname` FROM`student`
WHERE `studentname` LIKE '林%';
-- 查询名字中间有嘉的同学 %嘉%

-- ================in==============================
-- 查询 1 2 3 号学员

SELECT `studentno`,`studentname`FROM `student`
WHERE `studentno` IN (1,2,3);

-- 查询地名

SELECT `studentno`,`studentname` FROM `student`
WHERE `address` IN ('广东汕头');

-- ======null not null========
-- 查询地址为空的学生 null ''
SELECT `studentno`,`studentname`FROM `student`
WHERE address = '' OR address IS NULL;

-- 查询出生日期不为空
SELECT `studentno`,`studentname`FROM `student`
WHERE `borndate` IS NULL;

