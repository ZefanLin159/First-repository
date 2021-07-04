-- ==============联表查询===================
-- 查询参加了考试的同学（学号，姓名，科目编号，分数）

SELECT *FROM `student`;
SELECT * FROM `result`;

/*思路
1.分析需求，分析查询的字段来自哪些表
2.确定使用哪种连接查询 7种
确定交叉点（这两个表中哪个数据是相同的）
判断的条件；学生表中的 `studentno` = 成绩表 `studentno`
*/

SELECT s.`studentno`,`studentname`,`subjectno`,`studentresult` 
FROM `student` AS s
INNER JOIN `result` AS r
WHERE s.`studentno` = r.`studentno` AND r.`studentresult` BETWEEN 90 AND 100;


-- right join
SELECT s.`studentno`,`studentname`,`subjectno`,`studentresult` 
FROM `student` AS s
RIGHT JOIN `result` AS r
ON s.`studentno` = r.`studentno`;

-- left join
SELECT s.`studentno`,`studentname`,`subjectno`,`studentresult` 
FROM `student` AS s
LEFT JOIN `result` AS r
ON s.`studentno` = r.`studentno`;


-- 查询缺考的同学
SELECT s.`studentno`,`studentname`,`subjectno`,`studentresult` 
FROM `student` AS s
LEFT JOIN `result` AS r
ON s.`studentno` = r.`studentno`
WHERE r.`studentresult` IS NULL;

-- 思考题（查询参加了考试的二年级同学信息：学号、学生姓名、科目名称、分数）
/*思路
1.分析需求，分析查询的字段来自哪些表
2.确定使用哪种连接查询 7种
确定交叉点（这两个表中哪个数据是相同的）
判断的条件；学生表中的 `studentno` = 成绩表 `studentno`
*/
SELECT s.`studentno`,`studentname`,`subjectname`,`studentresult`
FROM `student` AS s
RIGHT JOIN `result` AS r ON 
s.`studentno` = r.`studentno`
INNER JOIN `subject` AS sub ON 
r.`subjectno` = sub.`subjectno`
WHERE sub.`subjectno` = 2;

-- 我要查询哪些数据 select...
-- 从哪几个表中查from 表 xxx join 表 on 连接条件
-- 多个表 join on 叠加

-- from a left join b on xxx
-- from a right join b on xxx






