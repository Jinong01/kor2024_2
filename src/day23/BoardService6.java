package day23;

import day22.NewBoard;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardService6 {
    public static void main(String[] args) {
        // 입력 객체
        Scanner scan = new Scanner(System.in);
        // 배열 - 고정길이 , 컬랙션프레임워크 - 가변길이
        ArrayList<Board> boardList = new ArrayList<>();
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
                Board board = new Board(content,writer,pwd); // 게시물 객체 생성

                // [3] 컬렉션 프레임워크인 리스트 객체에 게시물 저장한다.
                boardList.add(board);

            } else if (choose == 2) {
                // 배열 내 존재하는 게시물 모두 출력하기
                for (int index = 0; index <= boardList.size()-1; index++) {
                    System.out.printf("작성자 : %s , 내용 : %s\n",
                            boardList.get(index).getContent(),
                            boardList.get(index).getWriter());
                }


            }
        }
    }
}
