/* 여러줄 주석 */
# 한줄 주석
-- 한줄 주석

/*
	[SQL 작성 또는 실행 하는 방법]
    1. SQL 문법을 작성한다. show batabases;
    2. SQL 문장이 끝나면 ; 으로 마친다.
    3. 실행할 명령어 줄에 커서를 두고 ctrl + enter
		- ctrl+enter (상단의 번개모양의 I있는) : 명령어 단위 실행
        - ctrl+shift+enter(I없는 번개모양) : 현재 sql 파일의 모든 sql 실행
    4. 실행 결과는 하단에 [Result Grid] 창에서 확인 가능
*/    

# [1] db server 내 모든 테이블 확인 # 데이터베이스란? 표/테이블, 기본테이블 4개의 테이블명이 출력된다.
show databases;
# [2] db server local path 확인
show variables like 'datadir';
# [3]db server 데이터베이스 생성
create database myDBtest1;

