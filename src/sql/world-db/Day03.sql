show databases;

drop database if exists Day03;
create database Day03;
use Day03;

create table dept(
	id int primary key auto_increment, # 튜플을 insert할 때 id 값이 자동으로 1부터 차례대로 증가하는 옵션
    name varchar(10) not null);
    

create table emp(
	id int primary key auto_increment,
    name varchar(10) not null,
    regdate date default (current_date), # 현재 시간을 자동으로 넣어주는 옵션
    dept_id int,
    foreign key(dept_id) references dept(id));

show tables;
desc dept;
desc emp;

# insert into dept values();
# 테이블 전체 입력

# insert into dept(name) values();
# 속성 지정 입력 --> name 속성만 지정해서 입력
# auto_increment 옵션을 사용하지 않으면 NULL 값이 들어가지만 해당 옵션 사용으로 인해 1부터 차례대로 id 값 부여

# insert into 테이블명(속성들 ..) values(값들 ..);
# insert into 테이블명 values(전체 속성 값들 ..);

# dept 테이블의 name 속성에만 '인사'라는 값을 넣어서 새로운 튜플 생성 및 삽입
insert into dept(name) values('인사');
select * from dept;

# dept 테이블의 전체 속성에 2, '총무'라는 값을 넣어 튜플 생성 및 삽입
insert into dept values(2, '총무');
select * from dept;

# 다수의 튜플을 생성 및 삽입
insert into dept(name) values('개발'),
							 ('교육'),
							 ('운영');

select * from dept;

# 사원 데이터 insert
# 각 부서(dept) 당 3명씩 튜플 삽입
# insert 필수 요소 --> name, dept_id
# 총 튜플 15개

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
									  ('Charles', 5);

select * from emp;


# 선택한 테이블에서 전체 속성과 전체 튜플을 검색
# select * from 테이블명;

# dept 테이블에서 전체 속성 및 튜플 검색
select * from dept;

# dept 테이블에서 전체 튜플 및 id 속성 검색
select id from dept; 

# dept 테이블에서 전체 튜플 및 name 속성 검색
select name from dept;

# emp 테이블에서 전체 속성 및 전체 튜플 검색
select * from emp;

# where이 안붙는 쿼리는 전체 튜플 검색
# emp 테이블에서 id 속성만 검색
select id from emp;
# emp 테이블에서 name, regdate 속성 검색
select name, regdate from emp;
# emp 테이블에서 id, name, dept_id 속성 검색
select id, name, dept_id from emp;

# emp 테이블에서 id가 1인 튜플을 검색
select * from emp where id = 1;

# emp 테이블에서 id가 1이 아닌 튜플을 검색
select * from emp where id != 1;
# ! --> not

# emp 테이블에서 id가 10보다 큰 튜플을 검색
select * from emp where id > 10;

# emp 테이블에서 id가 10 이상인 튜플 검색
select * from emp where id >= 10;

# emp 테이블에서 id가 10보다 작은 튜플 검색
select * from emp where id < 10;

# emp 테이블에서 id가 10 이하인 튜플 검색
select * from emp where id <= 10;

# emp 테이블에서 id가 1, 3, 5 내부에 존재하는 튜플 검색
select * from emp where id in (1, 3, 5);

# emp 테이블에서 id가 1, 3, 5인 튜플을 제외하고 검색
select * from emp where id not in (1, 3, 5);

# emp 테이블에서 name 속성이 'Aaron'인 튜플 검색
select * from emp where name = 'Aaron';

# emp 테이블에서 name 속성이 'Aaron'인 튜플을 제외하고 검색
select * from emp where name != 'Aaron';

# name 속성이 A로 시작하는 모든 튜플 검색
select * from emp where name like ('A%');

# name 속성이 A로 끝나는 모든 튜플 검색
select * from emp where name like ('%A');

# name 속성이 A를 포함하는 튜플 검색
select * from emp where name like ('%A%');

# name 속성이 A로 시작하는 2글자 문자열 검색
select * from emp where name like ('A_');

use world;

# country 테이블의 code 속성이 A로 시작하는 3글자 문자열이라면 검색
select code from country where code like ('A__');


# country 테이블의 code 속성의 중간 글자가 O인 3글자 문자열이라면 검색
select code from country where code like ('_O_');

use Day03;

select * from emp;

# name 속성의 글자 수가 4개인 튜플만 검색
select * from emp where name like('____');

# LIKE 구문
# 글자 수를 제한해서 검색을 할 때 --> 언더바 사용(_)
# 글자 수 제한 없이 검색을 할 때 --> 퍼센트(%)

# 조건을 여러 개 활용
# AND, OR
# 두 개의 조건이 참일 때 검색 --> AND
# 둘 중 하나만 참이여도 검색 --> OR

# name이 A로 시작하면서 id가 5이하인 것
select * from emp where name like('A%') and id <= 5;

# name이 A로 시작하거나 id가 5이하인 것
select * from emp where name like('A%') or id <= 5;

# dept_id가 1이고 이름 끝 글자가 M인 튜플 검색
select * from emp where dept_id = 1 and name like('%M');

use world;
# 1. city 테이블에서 전체 튜플 및 속성 검색
select * from city;
# 2. city 테이블에서 name 속성 검색
select name from city;
# 3. city 테이블에서 id, population 속성 검색
select id, population from city;
# 4. city 테이블에서 countrycode가 'KOR'인 튜플 검색
select * from city where countrycode = 'KOR';
# 5. city 테이블에서 population이 1000000 이상인 튜플 검색
select * from city where population >= 1000000;
# 6. city 테이블에서 name 속성이 A를 포함하는 튜플 검색
select * from city where name like ('%A%');
# 7. city 테이블에서 countrycode 속성이 'KOR'을 포함하고 name 속성이 'S'로 시작하는 튜플 검색
select * from city where countrycode like ('%KOR%') and name like ('S%');
# 8. city 테이블에서 countrycode 속성이 'USA'이거나 countrycode 속성이 'KOR'인 것을 검색
select * from city where countrycode = 'USA' or countrycode = 'KOR';


use Day03;

set SQL_SAFE_UPDATES = 0; # 안전모드 해제
set SQL_SAFE_UPDATES = 1; # 안전모드 설정

# update emp set name = 'A'; 실수 방지
# 조건 없이 update 혹은 delete 사용시 대참사 일어날 수 있으니 항상 안전모드 체크 및 조건 사용 필수

# update 테이블명 set 변경할 속성 = 변경할 값 where 조건;

# emp 테이블의 id가 1인 튜플의 name 속성 값을 AAA로 변경
update emp set name = 'AAA' where id = 1;

select * from emp;

# 주의사항(update 및 delete)
# 1. 조건을 사용할 때는 기본키(Primary Key)에 사용할 것
# 2. 조건 없이 사용하지 말 것
# 3. 다수의 데이터를 변경 및 삭제해야하는 경우에는 안전모드 해제를 우선적으로 진행할 것 --> 작업한 뒤
# 다시 안전모드 설정 필수

# 다중 속성 변경 가능
update emp set name = 'ABC', regdate = '2023-12-30' where id = 2;
select * from emp;

update emp set name = '인사팀직원' where dept_id = 1;
update emp set name = '총무팀직원' where dept_id = 2;
select * from emp;

# delete from 테이블명 where 조건
set SQL_SAFE_UPDATES = 0;
delete from emp; # 삭제 --> 저장공간 및 실제 데이터는 남아있음(복원 가능)

select * from emp;
insert into emp(name, dept_id) values('A', 1);
select * from emp;

truncate table emp; # 초기화 --> 전체 초기화 --> 복구 불가능
insert into emp(name, dept_id) values('A', 1);
select * from emp;