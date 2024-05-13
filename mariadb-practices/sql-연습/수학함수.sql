--
-- 수학함수
--

-- abs
SELECT ABS(1), ABS(-1) FROM dual;

-- ceil
SELECT CEIL(3.14), CEILING(3.14) FROM dual;

-- FLOOR
SELECT FLOOR(3.14) FROM dual;

-- mod
SELECT MOD(10, 3), 10 % 3 FROM dual;

-- round(x) : x에 가장 근접한 정수
SELECT ROUND(1.498), ROUND(1.511) FROM dual;

-- round(x, d) : x값 중에 소수점 d 자리에 가장 근접한 실수
SELECT ROUND(1.498, 1) FROM dual;

-- power(x, y) : pow(x, y) : x의 y제곱
SELECT POWER(2, 10), POW(2, 10) FROM dual;

-- sign(x)
SELECT SIGN(20), SIGN(0) FROM dual;

-- greatest(x, y, ...), least(x, y, ...) 
SELECT GREATEST(10, 20, 30, 40), LEAST(10, 20, 30, 40) FROM dual;
SELECT GREATEST('b', 'A', 'C', 'D') FROM dual;
