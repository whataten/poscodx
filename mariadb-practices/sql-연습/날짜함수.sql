--
-- 날짜 함수
--

-- curdate(), current_date
SELECT CURDATE(), CURRENT_DATE FROM dual;

-- curtime(), current_time
SELECT CURTIME(), CURRENT_TIME FROM dual;

-- now() vs sysdate()
SELECT NOW(), SYSDATE() FROM dual;
SELECT NOW(), SLEEP(2), NOW() FROM dual;
SELECT SYSDATE(), SLEEP(2), SYSDATE() FROM dual;

-- data_format
-- default format: %Y년%m월%d일 %h시%i분%s초
SELECT DATE_FORMAT(NOW(), '%Y-%m-%d %h:%i:%s') FROM dual;
SELECT DATE_FORMAT(NOW(), '%d %b \ %y %h:%i:%s') FROM dual;

-- period_diff
-- 근무 개월
-- 포맷팅: YYMM, YYYYMM 
SELECT first_name, hire_date, PERIOD_DIFF(date_format(CURDATE(), '%y%m'), date_format(hire_date, '%y%m')) FROM employees;

-- date_add(=adddate), data_sub(=subdate)
-- 날짜를 date 타입의 칼럼이나 값에 type(year, month, day)의 표현식으로 더하거나 뺄 수 있다. 
-- 각 사원의 근속 연수가 5년이 되는 날에 휴가를 보내준다면 각 사원의 5년 근속 휴가 날짜는?
SELECT first_name, hire_date, DATE_ADD(hire_date, INTERVAL 5 year) FROM employees;

-- cast: varchar로 된 날짜를 date형으로 캐스팅 
SELECT '12345' + 10, CAST('12345' AS INT) + 10 FROM dual;
SELECT DATE_FORMAT(CAST('2013-01-09' AS DATE), '%Y년 %m월 %d일') FROM employees;
SELECT CAST(CAST(1-2 AS unsigned) as signed) FROM dual;
SELECT CAST(CAST(1-2 AS unsigned) as int) FROM dual;
SELECT CAST(CAST(1-2 AS unsigned) as integer) FROM dual;