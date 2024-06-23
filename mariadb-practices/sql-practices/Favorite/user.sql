desc user;

-- JOIN
INSERT into user VALUES(null, '관리자', 'admin@mysite.com', PASSWORD(1234), 'male', CURRENT_DATE());
INSERT into user VALUES(null, '관리자', 'admin@mysite.com', PASSWORD(1234), 'male', CURRENT_DATE());

-- test
SELECT * from user;

-- login
SELECT no, name from user where email = 'admin@mysite.com' and PASSWORD=PASSWORD(1234);

-- find
select name, email, gender from user WHERE no = 4;

-- update
UPDATE name, email, gender, password from user WHERE no = 4;

UPDATE user SET name = 'test3', gender = 'male', password = PASSWORD(4321) WHERE no = 4;

SELECT name, title, contents, hit, reg_date, g_no, o_no, depth, user_no from board b join user u on b.user_no = u.no ORDER BY g_no DESC, o_no ASC LIMIT 0, 5;

UPDATE board set g_no = g_no + 1;
INSERT INTO board VALUES(NULL, 'title', 'content', 0, CURRENT_DATE(), 0, 0, 0, 1);

DELETE from board where no = 2;

UPDATE board SET title = 'wwwwwwww', contents='wwwwwwwz', reg_date=NOW() WHERE no = 3;

INSERT INTO board VALUES(NULL, 'title', 'content', 0, CURRENT_DATE(), g_no, o_no, depth=depth + 1, authUser);

INSERT INTO site VALUES(NULL, 'title', 'welcome', 'profile', 'description');