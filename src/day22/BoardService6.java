package day22;
/*
추가 조건 : NewBoard 클래스 객체들을 캡슐화(접근제한자) 하시오.
    - 1. NewBoard 는 앞전 Board 와 동일하게 내용, 작성자, 비밀번호로 구성된 게시물 클래스
    - 2. NewBoard 의 모든 필드(멤버변수)는 private 로 선언
    - 3. 외부에서 객체 생성시 생성자를 사용한다.
    - 4. getter(필드값 호출함수) , setter(필드값대입함수) , toString(객체정보함수) 함수들을 이용하여
         모든 필드의 데이터를 간접 접근한다.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class BoardService6 {
    public static void main(String[] args) {
        // 입력 객체
        Scanner scan = new Scanner(System.in);
        // 배열 - 고정길이 , 컬랙션프레임워크 - 가변길이
        ArrayList<NewBoard> boardList = new ArrayList<>();
        // <제네릭타입> : 리스트 객체에 저장할 여러개 데이터들의 타입

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

                // [2] 입력받은 데이터로 게시물 객체 생성
                NewBoard board = new NewBoard(); // 게시물 객체 생성
                board.setContent(content); board.setWriter(writer); board.setPwd(pwd);

                // [3] 컬렉션 프레임워크인 리스트 객체에 게시물 저장한다.
                boardList.add(board);

            } else if (choose == 2) {
                // 배열 내 존재하는 게시물 모두 출력하기
                for (int index = 0; index <= boardList.size() - 1; index++) {
                    System.out.printf("작성자 : %s, 내용 : %s \n",
                            boardList.get(index).Writer, boardList.get(index).content);

                }
            }
        }
    }
}
