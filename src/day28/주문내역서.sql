/*
[ SQL 과제2 ] 회원들만 구매 할 수 있는 '라면' 쇼핑몰 , 데이터베이스 구축하기
	- 요구사항
		1. 회원은 회원가입을 진행한다. (임의)
        2. 로그인된 상황에서 카테고리를 선택한다.
        3. 지정된 카테고리에서 제품을 선택한다.
        4. 지정한 제품을 장바구니에 담는다.
		--> 여러번 장바구니에 담았을 때,
        5. 만약에 장바구니에 담긴 '불닭볶음면' 2개 , 짜파게티 1개를 주문했다.
        6. 하나의 주문번호를 발급 받았고 주문내역에서 지정한 주문상세를 클릭시 주문상세내역(정보) 나왔다.
	- 조건
		1. 서로 다른 테이블간의 pk와 fk를 적용하여 관계형 테이블을 만드시오.
        2. 적절한 필드명과 타입을 사용하시오.
        3. 적절한 제약조건을 사용하시오.
*/

create database mydb1121_1;
use mydb1121_1;
create table user(id int primary key auto_increment , pwd varchar(30) not null);

create table category( id int primary key auto_increment, name varchar(30) );

create table menu(id int primary key auto_increment , menu varchar(30) , price int, categoryid int ,
constraint category_menu foreign key (categoryid) references category(id) on update cascade);

create table bills(id int primary key auto_increment , userid int , menuid int , menuname varchar(30) , count int,
 constraint user_bills foreign key (userid) references user(id) on update cascade ,
 constraint menu_bills foreign key (menuid) references menu(id) on update cascade);

insert into category (name) value ('라면') , ('음료');
select * from category;

insert into menu (menu,price,categoryid) value ('불닭',1500,1) , ('짜파게티',2000,1) ,('콜라',1000,2) ,('사이다',1500,2);
select * from menu;

select * from menu m,category c;