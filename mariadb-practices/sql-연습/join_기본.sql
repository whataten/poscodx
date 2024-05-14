--
-- inner join
--

-- 현재, 근무하고 있는 직원의 이름과 직책을 모두 출력
SELECT
	employees.first_name, titles.title
FROM
	employees,
	titles
WHERE
	employees.emp_no = titles.emp_no 	-- join 조건(n-1)
	AND titles.to_date = '9999-01-01'; 	-- row 선택 조건
	
-- 현재, 근무하고 있는 직원의 이름과 직책을 모두 출력하되, 여성 에니지어만 출력
SELECT
	employees.first_name,
	titles.title
FROM
	employees,
	titles
WHERE
	employees.emp_no = titles.emp_no 	-- join 조건(n-1)
	AND titles.to_date = '9999-01-01' 	-- row 선택 조건1
	AND employees.gender = 'F' 			-- row 선택 조건2
	AND titles.title = 'Engineer'; 		-- row 선택 조건3
	
--
-- ANSI/ISO SQL1999 Join 표준문법
--

-- 현재, 직원별 근무 부서를 출력
-- 사번, first name, 부서명 순으로 출력
SELECT employees.emp_no, employees.first_name, departments.dept_name FROM employees, departments, dept_emp WHERE employees.emp_no = dept_emp.emp_no and departments.dept_no = dept_emp.dept_no and to_date='9999-01-01';

-- 현재, 지급되고 있는 급여를 출력
-- 사번, 이름, 급여 순으로 출력
SELECT employees.emp_no, employees.first_name, salaries.salary FROM employees, salaries WHERE employees.emp_no = salaries.emp_no AND salaries.to_date LIKE '9999%';

-- Natural Join
-- 조인 대상이 되는 두 테이블에 이름이 같은 공통 칼럼이 있는 경우
SELECT employees.first_name,titles.title FROM employees NATURAL JOIN titles WHERE titles.to_date LIKE '9999%';

-- join ~ using
-- natural join 문제점 : 같은 칼럼 여러 개가 모두 조인됨
SELECT count(*) FROM salaries as a natural join titles as b where a.to_date LIKE '9999%' and b.to_date LIKE '9999%';
SELECT count(*) FROM salaries as a join titles as b using(emp_no) where a.to_date LIKE '9999%' and b.to_date LIKE '9999%';

-- join ~ on
-- 현재, 직책별 평균 연봉을 큰 순서대로 출력
SELECT a.title, AVG(b.salary) FROM titles a JOIN salaries b on a.emp_no = b.emp_no WHERE a.to_date LIKE '9999%' and b.to_date LIKE '9999%' GROUP BY a.title ORDER BY AVG(b.salary) DESC;

-- 현재, 직책별 평균연봉과 직원수를 구하되 직원수가 100명 이상인 직책만 출력
-- 직책, 평균연봉, 직원수
SELECT a.title, AVG(b.salary), COUNT(*) FROM titles a JOIN salaries b ON a.emp_no = b.emp_no WHERE a.to_date LIKE '9999%' and b.to_date LIKE '9999%' GROUP BY a.title HAVING COUNT(*) >= 100;

-- 현재, 부서별로 직책이 Engineer인 직원들에 대해서만 평균 연봉을 출력
-- 부서이름, 평균급여

SELECT
	a.dept_name,
	AVG(d.salary)
FROM
	departments a,
	dept_emp b,
	titles c,
	salaries d
WHERE
	a.dept_no = b.dept_no
	AND b.emp_no = c.emp_no
	AND c.emp_no = d.emp_no
	AND b.to_date LIKE '9999%'
	AND c.to_date LIKE '9999%'
	AND d.to_date LIKE '9999%'
	AND c.title = 'Engineer'
GROUP BY
	a.dept_name
ORDER BY
	AVG(d.salary)
	DESC; 

--
-- outer join
--

-- insert into dept values(null, '기획');
-- insert into dept values(null, '총무');
-- insert into dept values(null, '영업');
-- insert into dept values(null, '개발');

SELECT * FROM dept;

INSERT INTO emp VALUES(null, '둘리', 1);
INSERT INTO emp VALUES(null, '마이콜', 1);
INSERT INTO emp VALUES(null, '또치', 1);
INSERT INTO emp VALUES(null, '길동', null);

-- inner join
SELECT a.name, b.name FROM emp a join dept b on a.dept_no = b.no;

-- left (outer) join
SELECT a.name as '이름', IFNULL(b.name, '없음') as '부서' FROM emp a left join dept b on a.dept_no = b.no;

-- left (outer) join
SELECT ifnull(a.name, '없음') as '이름', b.name as '부서' FROM emp a right join dept b on a.dept_no = b.no;

-- full (outer) join
-- mariadb 지원 안함
