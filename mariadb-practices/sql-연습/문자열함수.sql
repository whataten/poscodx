--
-- 문자열 함수
--

-- upper
SELECT UPPER('seoul'), UCASE('seoul') FROM dual;
SELECT UPPER(first_name) FROM employees;

-- lower
SELECT LOWER('SEOUL'), LCASE('SEOUL') FROM dual;
SELECT LOWER(first_name) FROM employees;

-- substring(문자열, index, length)
SELECT SUBSTRING('hello world', 3, 2);

-- 예제: 1989년에 입사한 직원들의 이름, 입사일을 출력
SELECT first_name, SUBSTRING(hire_date, 9, 2) FROM employees WHERE hire_date LIKE '1989%';

-- lpad(오른쪽 정렬, 왼쪽 채움), rpad(왼쪽 정렬, 오른쪽 채움)
SELECT LPAD('1234', 10, ' '), RPAD('1234', 10, ' ') FROM dual;

-- 예제) 직원들의 월급을 오른쪽 정렬 (빈공간은 *)
SELECT LPAD(salary, 10, '*') FROM salaries;

-- trim, ltrim, rtrim 
SELECT concat('---', LTRIM('   hello   '), '---') FROM dual;
SELECT concat('---', RTRIM('   hello   '), '---') FROM dual;
SELECT concat('---', TRIM(LEADING 'x' FROM 'xxxhelloxxx'), '---') FROM dual;
SELECT concat('---', TRIM(TRAILING 'x' FROM 'xxxhelloxxx'), '---') FROM dual;
SELECT concat('---', TRIM(BOTH 'x' FROM 'xxxhelloxxx'), '---') FROM dual;

-- length
SELECT LENGTH('hello world') FROM dual;