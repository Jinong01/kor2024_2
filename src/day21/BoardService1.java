/*
    BoardService1
        - 내용 과 작성자로 구성된 게시물 3개 까지 저장하는 서비스 구축
        - 조건 : main  함수 1개와 변수 6개와 반목문 사용
        - 구축 : 게시물 쓰기 와 게시물 출력 기능 구현
 */
package day21;


import java.util.Scanner;

public class BoardService1 {
    public static void main(String[] args) { // main : 번역된 코드들을 실행하는 기능(main 스레드) 포함
        Scanner scan = new Scanner(System.in);

        // - 저장소 설계, 게시물 1개당 내용과 작성자(내용2개) , 게시물 3개면 내용 총 6개
            // 변수란? 하나를 데이터/주소값을 저장하는 공간/메모리
            // 타입이란? 변수의 저장될 데이터/주소의 타입, 데이터 분류, 기본타입(int~double) vs 참조타입(클래스,인터페이스,배열)
        String content1 = null; String writer1 = null; // 첫번째 게시물 내용물들
        String content2 = null; String writer2 = null; // 첫번째 게시물 내용물들
        String content3 = null; String writer3 = null; // 세번째 게시물 내용물들

        while( true ) { // 무한루프
            System.out.println("1. 게시물 쓰기 2. 게시물 출력 선택 : "); // 출력
            int choose = scan.nextInt();
            if (choose == 1) { // 만약에 입력한 값이 1이면 게시물 쓰기 구현
                // 게시물 저장할 내용 입력 받기
                System.out.println("새로운 게시물 내용 : "); String content = scan.next();
                System.out.println("새로운 게시물 작성자 : "); String writer = scan.next();
                // 게시물을 작성할 공간이 있는지 체크, 임의로 게시물이 존재하지 않는 뜻, null 또는 ""
                if (content1 == null) { // 만약에 첫번째 게시물의 정보가 비어있으면
                    // 입력 받은 값들을 첫번째 게시물 변수에 저장
                    content1 = content; writer1 = writer;
                } else if (content2 == null) { // 만약에 두번째 게시물의 정보가 비어 있으면
                    content2 = content; writer2 = writer;
                } else if (content3 == null) {
                    content3 = content; writer3 = writer;
                } else {
                    System.out.println("게시물 쓰기 실패 : 빈 공간이 없습니다.");
                }

            } // if end
            if ( choose == 2) { // 만약에 입력한 값이 2이면 게시물 출력 구현

            } // if end
        } // while end


    }
}
