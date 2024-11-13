package day22;
/*
조건 : 고정길이가 아닌 가변길이 형식으로 무한개 저장 가능한 배열 만들기
이유 : 가변길이의 여러개 데이터를 관리할 때는
    - 컬렉션프레임워크(ArrayList) = 실무
    - 가변배열 = 시험/코테 , C언어는 컬렉션프레임워크가  없다
*/
import java.util.ArrayList;
import java.util.Scanner;


import java.util.Scanner;

public class BoardService4 {
    public static void main(String[] args) {
        // 입력 객체
        Scanner scan = new Scanner(System.in);
        // 배열 - 고정길이 , 컬랙션프레임워크 - 가변길이
        Board[] boardList = null;
        int count = 0; // 현재 게시물의 수를 저장하는 변수

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
                Board board = new Board(); // 게시물 객체 생성
                board.content = content; board.writer = writer; board.pwd = pwd;

                // [3]
                count++; // 게시물 수 1증가
                Board[] newBoardList = new Board[count]; // 새로운 배열 생성
                // 기존 배열내 게시물을 새로운 배열에 이동하기 / 배열 복사
                if (count != 1){ // 만약에 기존 배열내 게시물이 존재하면

                    for (int index = 0; index <= boardList.length-1; index++){
                     newBoardList[index] = boardList[index]; // 기존 배열내 게시물을 새로운 배열에 대입/카피
                    }
                }

                // 배열내 마지막 인덱스(배열명.length-1)에 새로운 객체 등록 .add()
                newBoardList[count-1] = board;
                // ** 새로운 배열을 기존배열에 대입한다.
                boardList = newBoardList;

            } else if (choose == 2) {
                // 배열 내 존재하는 게시물 모두 출력하기
                for (int index = 0; index <= boardList.length - 1; index++) {

                        System.out.printf("작성자 : %s, 내용 : %s \n",
                                boardList[index].writer, boardList[index].content);

                }
            }
        }
    }
}
