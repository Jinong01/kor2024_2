create database kiosk;
use kiosk;
create table cafe(카테고리 varchar(10), 제품명 varchar(20), 가격 int, 주문수량 int, 날짜 date);
select * from cafe;
insert into cafe (카테고리, 제품명 , 가격) values ('커피','아메리카노',2000);
insert into cafe (카테고리, 제품명 , 가격) values ('커피','카페라떼',3000);
insert into cafe (카테고리, 제품명 , 가격) values ('커피','카페모카',3000);
insert into cafe (카테고리, 제품명 , 가격) values ('커피','카라멜마키야또',3500);
insert into cafe (카테고리, 제품명 , 가격) values ('논커피','아이스티',2000);
insert into cafe (카테고리, 제품명 , 가격) values ('논커피','레몬에이드',2500);
insert into cafe (카테고리, 제품명 , 가격) values ('논커피','초코라떼',2000);
insert into cafe (카테고리, 제품명 , 가격) values ('논커피','스무디',3000);
insert into cafe (카테고리, 제품명 , 가격) values ('디저트','소금빵',2000);
insert into cafe (카테고리, 제품명 , 가격) values ('디저트','초코쿠키',1500);
insert into cafe (카테고리, 제품명 , 가격) values ('디저트','감자빵',2000);
insert into cafe (카테고리, 제품명 , 가격) values ('디저트','와플',2000);
select * from cafe;
select * from cafe where 카테고리 = '커피';
select * from cafe where 카테고리 = '논커피';
select * from cafe where 카테고리 = '디저트';



