-- 예제3: 남자직원의 이름, 성별, 입사일을 입사일순(선임순)으로 출력
SELECT first_name, gender, hire_date FROM employees WHERE gender='M' ORDER BY hire_date ASC;