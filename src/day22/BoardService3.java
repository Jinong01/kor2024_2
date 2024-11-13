/*
- 활용분들 : BoardServiceTest1
- 내용[String타입] 과 작성자[String타입] 과 비밀번호[int타입] 로 구성된 게시물 클래스를 설계
- 게시물 객체 최대 100개 까지 저장하는 서비스 구축
- 조건 : main함수 1개 와 배열은 최대1까지 사용 하여 구현
- 구축 : 게시물 쓰기 와 게시물 출력 기능 구현

 - 클래스 : 객체 지향 프로그래밍에서 매우 중요한 문법
    객체 : 물리적 / 논리적으로 (특성,행위)정의가 가능한 형태물


    타입 : 데이터 형태를 분류
        대분류 : - 기본타입(byte~double + char, boolean) --> 기본값 : 정수0, 실수0.0, 논리 false
                - 참조타입(배열, 클래스, 인터페이스, 열거타입 등등) --> 기본값 : null
    클래스 : 멤버변수(필드) , 생성자 , 메소드(멤버함수)로 구성된 새로운 참조타입 만들기
    객체 :  참조 타입으로 생성된 메모리 공간, 객체(묶음)
    변수 : 기본/참조 타입으로 생선된 메모리 공간
    객체랑 변수의 차이점? 물리적 차이 - 메모리가 저장되는 위치가 다르다   (JVM 외우기)
                       논리적 차이 - 변수(스택)는 하나의 자료(실제값, 주소값)을 저장하는 메모리 공간,
                                   객체(힙)는 하나의 자료(여러개 자료들의 주소값)을 저장하는 메모리 공간

 */
package day22;

import java.util.Scanner;

public class BoardService3 { // 실행 클래스
    public static void main(String[] args) {
        // 입력 객체
        Scanner scan = new Scanner(System.in);
        // 배열 - 고정길이 , 컬랙션프레임워크 - 가변길이
        Board[] boardList = new Board[100];// Board 객체 100개를 저장할 수 있는 배열

        while (true) {
            System.out.println("1.글쓰기 2.글출력 : ");
            int choose = scan.nextInt();
            if (choose == 1) {
                // 사용자로부터 저장할 데이터 입력 받는다.
                scan.nextLine();
                System.out.println("내용 : ");
                String content = scan.nextLine();
                // .next() 는 띄어쓰기 x , .nextLine() 띄어쓰기 o
                // nextLine() 사용시 주의할점 : 앞에 또 다른 nextXX() 존재하면 의미없는 nextLine() 작성해준다.
                System.out.println("작성자 : ");
                String writer = scan.next();
                System.out.println("비밀번호 : ");
                int pwd = scan.nextInt();
                // [2] 내열 내 빈 공간을 찾아서 게시물 작성하기.
                for (int index = 0; index <= boardList.length - 1; index++) {
                    if (boardList[index] == null) { // 왜 null 을 쓰는지?는 위에, 만약에 index 번째 비어있으면
                        Board board = new Board(); // 게시물 객체 생성
                        // 생성된 게시물 객체 내 입력받은 값들을 대입
                        board.content = content;
                        board.writer = writer;
                        board.pwd = pwd;
                        // 배열내 index번째 위치에 생성한 객체를 저장/대입 한다.
                        boardList[index] = board;
                        break; // 반복문 종료
                    }
                }
            } else if (choose == 2) {
                // 배열 내 존재하는 게시물 모두 출력하기
                for (int index = 0; index <= boardList.length - 1; index++) {
                    if (boardList[index] != null) {
                        System.out.printf("작성자 : %s, 내용 : %s \n",
                                boardList[index].writer, boardList[index].content);
                    }
                }
            }
        }
    }
}
