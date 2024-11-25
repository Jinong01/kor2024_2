drop database if exists Day03;
create database Day03;
use Day03;

create table dept(
    id int primary key auto_increment,
    name varchar(10) not null);

create table emp(
    id int primary key auto_increment,
    name varchar(10) not null,
    regdate date default (current_date),
    dept_id int,
    foreign key(dept_id) references dept(id) on update cascade on delete cascade);

insert into dept(name) values('인사'),
                             ('총무'),
                             ('개발'),
                             ('교육'),
                             ('운영'),
                             ('계획'),
                             ('회계'),
                             ('전산'),
                             ('영업'),
                             ('생산');
                             

insert into emp(name, dept_id) values ('Aaron', 1),
                                      ('Abraham', 1),
                                      ('Adam', 1),
                                     
                                      ('Alan', 2),
                                      ('Albert', 2),
                                      ('Alfred', 2),
                                     
                                      ('Alexander', 3),
                                      ('Andrew', 3),
                                      ('Antony', 3),
                                     
                                      ('Arnold', 4),
                                      ('Arthur', 4),
                                      ('Benedict', 4),
                                     
                                      ('Benjamin', 5),
                                      ('Cecil', 5),
                                      ('Charles', 5),
                                     
                                      ('Claude', 6),
                                      ('Conrad', 6),
                                      ('Daniel', 6),
                               
                                      ('David', 7),
                                      ('Donald', 7),
                                      ('Douglas', 7),
                                     
                                      ('Duncan', 8),
                                      ('Edgar', 8),
                                      ('Edmund', 8),
                                     
                                      ('Edward', 9),
                                      ('Edwin', 9),
                                      ('Enoch', 9),
                                     
                                      ('Eugene', 10),
                                      ('Evelyn', 10),
                                      ('Ferdianand', 10);

# as
# 별칭, 결과 속성에 별칭을 달아서 조회                                      
select id as '사원번호' , name as '사원이름' from emp;    
                                  
# IF
# 조건에 의한 값(속성)을 출력 --> 새로운 결과 속성을 생성해 내가 원하는 형태로 출력
# id가 16 이상이면 T, 아니라면 F
# id = [1~30]
# for(int i = 0; i<=30,i++){
#	if(i>16) printf("T");
#   else printf("F");
#   }
select id , if(id>=16, 'T' , 'F') as Result from emp;

# % : 나머지 연산자, 10 % 2 --> 0 ( 10을 2로 나눈 나머지)
# id가 짝수라면 EVEN , 아니라면 ODD
select id , if((id % 2)=0, 'EVEN' , 'ODD') as tmp from emp;

# between : 첫번째 값과 두번째 값 사이에 존재하는 튜플을 반환
select * from emp where id between 10 and 20;

# case : 조건을 여러개 활용할 수 있는 함수
select id,
case
when ( id between 1 and 3) then 'A' # id가 1부터 3 사이에 있으면 A로 출력
when ( id between 4 and 6) then 'B' # id가 4부터 6 사이에 있으면 B로 출력
else 'F' # 위에 있는 조건에 모두 해당하지 않으면 F로 출력
end as tmp
from emp;

select id, name,
case
when (name like ('A%')) then 'A%'
when (name like ('B%')) then 'B%'
when (name like ('C%')) then 'C%'
else 'F'
end as tmp
from emp;

# ifnull
# 데이터가 null이면 대체로 출력할 문자 지정
use world;
select indepyear from country;
select indepyear, ifnull(indepyear, 'No Record') as tmp from country;
select indepyear, ifnull(indepyear, 0) as tmp from country;
select indepyear, ifnull(indepyear, null) as tmp from country;

# nullif
# 비교하는 두 개의 값이 동일하면 NULL 출력, 동일하지 않으면 첫 번째 값을 출력
select nullif(1,1);
select nullif(1,2);
select nullif(1,null);

# isnull --> Oracle 제공 함수 , ifnull과 동일한 함수
# nvl --> Oracle 제공 함수 , ifnull과 동일한 함수
# isnull(null,1); --> 1 출력
# nvl(null,1); --> 1 출력alter

# nvl2 --> Oracle 제공 함수
# nvl2(AGE, AGE, 'NO Age'); --> AGE 속성에 값이 있으면 AGE를 그대로 출력, 없으면 NO Age 출력
# select nvl2(indepyear, indepyear, 'No Record' as tmp from country;
# indepyear 값이 존재하면 indepyear 그대로 출력 , 없으면 No Record 출력

# 함수의 매개변수
# 괄호() 안에 들어있는 값
# nvl2(AGE, AGE2 , 'NO') --> 매개변수 : AGE AGE2 'NO'

# coalesce
# 매개변수 중에 NULL이 아닌 최초의 매개변수를 반환
select coalesce(null , 1, null) as temp;
select coalesce(null , null , 1) as temp;
select coalesce(null , null , null) as temp;

# CONCAT : 문자열 붙히기 함수
select concat('NAME','-','KJH') as tmp;
# CONCAT_WS : 문자열 구분자와 붙히기 함수
select concat_ws('-','2024','09','27') as tmp;

# LCASE , LOWER : 문자열을 소문자로 변환
select lcase('ABC'), lower('ABC');

# UCASE , UPPER : 문자열을 대문자로 변환
select ucase('abc'), upper('abc');

# ltrim : 문자열 좌측에서 공백이나 특정 문자열을 제거
select ltrim('     MySQL');
# select ltrim('xxxMySQL','x'); --> 'x'가 전부 제거된다(좌측에서) --> MySQL

# rtrim : 문자열 우측에서 공백이나 특정 문자열을 제거
select ltrim('MySQL     ');
# select ltrim('MySQLxxx','x');

# trim : 양쪽에서 공백이나 특정 문자열 제거

# abs : 절대값
select abs(-15);

# ceil / ceiling : 소수의 올림
select ceil(3.12), ceiling(3.12);

# floor : 소수의 내림
select floor (3.99);

# round : 소수의 반올림
select round(3.5), round(3.4);

# sqrt : 숫자의 제곱근(루트) 값 반환
select sqrt(16);

# truncate , trunc(Oracle 버전) : 소주점 자르기(2번째 매개변수 위치까지)
select truncate(1.12345 , 1);
select truncate(1.12345 , 2);
select truncate(1.12345 , 3);
# select truncate(1.12345); --> 2번째 매개변수가 없으면 전부 자르기

# curdate : 현재 날짜 반환
select curdate();

# curtime : 현재 시간 반환
select curtime();

# database , schema : 현재 사용중인 데이터베이스 반환
select database(), schema();
