# 1. 데이터베이스 생성 -> 데이터(자료)들의 모임, 데이터를 저장하기 위해서 사용
create database mydb1122;
# 2. 모든 데이터베이스 목록 확인
show databases;
# 3. 데이터베이스 활성화
use mydb1122;
# 4. 활성화된 데이터베이스에 테이블 생성
create table board( 
bno int unsigned auto_increment ,
# unsigned 부호가 없다. int : +-21억 -> 42억
bcontent text not null,
# longtext는 글자수가 더 많이 들어가지만 용량이 크다.
# not null : 글이 무조건 들어가야한다. 글이 없어도 되면 안써도 됨.
bwriter varchar(100) not null,
bpwd int not null,
primary key board (bno)
# primary key? 기본(식별)키 , 여러개의 필드 중에서 식별 가능한 필드, 중복x
# 내용, 작성자, 비밀번호는 중복이 될 수 있으므로 게시물 번호만 가능
# 관례적(무조건x일반적o)으로 테이블마다 1개 이상의 pk(기본키) 필수, (주민등록번호o-사람이름x)/(학번o-학생이름x)/(제품번호o-제품이름x)
);
select * from board;

# 5. DML : 데이터 조작 어
# (1) insert : 레코드 삽입/추가
# insert into 테이블명 values (값1 , 값2 , 값3 , 값4); - 내가 정의 필드 순서대로
# insert into 테이블명 (필드명1, 필드명2 , 필드명3) values (값1 , 값2 , 값3); - 전체 필드의 값 삽입시 삽입할 필드명을 생략해도 된다. 그게 위 주석
insert into board values (1, '안녕하세요','유재석',1234);
insert into board (bcontent , bwriter , bpwd) values('그래 안녕' , '강호동' , 4567); #데이터의 갯수와 필드의 갯수가 일치해야한다.
# (2) select : 레코드 조회
# select 필드명 from 테이블명; - 필드명에 * 적으면 전체
select * from board;
select bcontent , bwriter from board;
# (3) update : 특정 레코드의 필드값 수정
# update 테이블명 set 수정할필드명 = 새로운값 where 조건필드 = 조건값;
update board set bwriter = '신동엽' where bno = 1;
# board 라는 테이블에서 bno가 1번의 bwriter의 값을 '신동엽'으로 바꾼다.
# where 조건이 없으면 board 테이블의 전체 bwriter 값이 '신동엽'으로 바뀐다.
# (4) delete : 특정 레코드 삭제 (한줄 삭제)
delete from board where bno = 1;

# [실습]
/*
create table products (
product_id int not null, 
product_name varchar(30), 
category varchar(30) , 
price float , 
stock_quantity int);

(1) insert into employees values (201, 'Wireless Mouse' , 'Electronics' , 29.99 , 150);
(2) insert into products (product_id , product_name , category , price , stock_quantity)
				values (201, 'Wireless Mouse' , 'Electronics' , 29.99 , 150);
*/

select first_name , email from employees;
select product_name , price from products where price = 1000;
update employees set email = 'john.doe@company.com' where employee_id = 101;
update products set price = 24.99 where product_id = 201;
delete from employees where employee_id = 101;
delete from products where product_id = 201;