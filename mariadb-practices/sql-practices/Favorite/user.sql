desc user;

-- JOIN
INSERT into user VALUES(null, '관리자', 'admin@mysite.com', PASSWORD(1234), 'male', CURRENT_DATE());

-- test
SELECT * from user;

-- login
SELECT no, name from user where email = 'admin@mysite.com' and PASSWORD=PASSWORD(1234);