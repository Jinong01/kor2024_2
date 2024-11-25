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

insert into dept(name) values('인사');
insert into dept values(2, '총무');

insert into dept(name) values('개발'),
                             ('교육'),
                             ('운영');

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

# 제약사항 확인
# dept테이블의 id를 emp 테이블의 dept_id로 외래키 옵션
# 상위 테이블 --> dept
# 하위 테이블 --> emp

# 수정에 제약사항
# dept 테이블의 id가 1인 튜플이 가지고 있는 자식 튜플이 3개가 존재
# dept 테이블의 id가 1인 튜플이 연관되어 있는 튜플이 3개 있기 때문에 수정 혹은 삭제 불가능
# update dept set id = 6 where id = 1;
# delete from dept where id = 1;

# 상위 테이블의 기본키 값 중에 6은 존재하지 않음
# insert into emp(name, dept_id) values('Sample', 6);

# 제약사항을 해결하는 방법
# CASCADE --> 연쇄작용
# 수정 제약사항 해결 --> on update cascade
# 삭제 제약사항 해결 --> on delete cascade

-- create table emp(
--     id int primary key auto_increment,
--     name varchar(10) not null,
--     regdate date default (current_date),
--     dept_id int,
--     foreign key(dept_id) references dept(id) on update cascade on delete cascade);

delete from dept where id = 1;
select * from dept;
select * from emp;

update dept set id = 10 where id = 2;
select * from dept;
select * from emp;

# delete from table
-- 연산속도가 느림, 백업 가능, 튜플 삭제
# truncate table
-- 연산속도가 빠름, 백업 X, 튜플 삭제
# drop table
-- 테이블 삭제 --> 튜플 삭제 X