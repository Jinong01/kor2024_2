use world;

# 단일행 서브쿼리 : 서브쿼리의 결과값 (투플)이 1개
select * from city where countrycode = (
select countrycode from city where name = 'seoul');

select * from city where countrycode = 'KOR';

# 다중행 서브쿼리 : 서브쿼리의 결과 튜플이 여러개
# any --> 조건 집합 중 하나라도 만족할 시 참
select * from city where population> any (
select population from city where district = 'New York');

# all --> 조건 집합 전체를 만족해야 참
select * from city where population> all (
select population from city where district = 'New York');

# in             
select * from city where name in(
select name from city where countrycode = 'KOR');

# exists
select * from city where exists(
select * from city where countrycode = 'KOR');

# 스칼라
# 1. 나라 이름과 인구수와 (스칼라 서브쿼리를 활용한 대한민국의 인구수) 조회
select name , population, (
select population from country where name = 'South Korea') as KOR_POP
from country;
# 2. 도시 이름과 인구수와 (스칼라 서브쿼리를 활용한 서울의 인구수) 조회
select name, population,(
select population from city where name = 'seoul') as SEOUL_POP
from city;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    

# 중첩(where)
# 1. 아시아의 평균 인구수보다 인구수가 많은 나라를 조회
select * from country where population > (
select avg(population) from country where continent = 'ASIA');

# 2. 대한민국에 속한 도시들보다 인구수가 많은 도시를 조회
select * from city where population > all(
select population from city where countrycode = 'KOR');

# 3. 대한민국과 governmentform이 동일한 나라들 조회(=)
select * from country where governmentform = (
select governmentform from country where code = 'KOR');

# 다중 조건 (if 여러개)
select if(percentage > 5, 'BIG 5' , 'SMALL 5') as tmp from countrylanguage;

