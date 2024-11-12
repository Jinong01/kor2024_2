/*
    BoardService1
        - 내용 과 작성자로 구성된 게시물 100개 까지 저장하는 서비스 구축
        - 조건 : main  함수 1개와 배열 최대2개와 반목문 사용
        - 구축 : 게시물 쓰기 와 게시물 출력 기능 구현
 */

package day21;

import java.util.Scanner;

public class BoarService2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 여러개의 변수에 있는 데이터를 배열로 사용하면 관리가 편하다.
        // 배열이란? 여러개의 동일한 타입의 데이터들을 *하나의 변수*에 저장할 수 있는 참조 타입
        // 인덱스란? 배열내 저장된 데이터들의 저장 순서 번호, 0~ 최대길이
        // 반복문 활용 : 시작값부터 끝값까지 반복
        String[] contents = new String[100]; // 배열을 main 밖에다 적으면 변수명 같이 할 수 있음
        String[] writers = new String[100];

        while (true) {
            System.out.println("1. 게시물 쓰기 2. 게시물 출력 선택 : ");
            int choose = scan.nextInt();
            if (choose == 1) {
                System.out.println("새로운 게시물 내용 : "); String content = scan.next();
                System.out.println("새로운 게시물 작성자 : "); String writer = scan.next();
                // 스위치변수 = 상태 저장하는 변수
                boolean save = false;
                for (int i = 0; i <= contents.length-1; i++) {
                    if (contents[i] == null) {
                        contents[i] = content; writers[i] = writer;
                        save = true; // 만약에 저장 성공 했으면 save 변수에 true 값으로 변경
                        break; // 만약에 저장을 했으면 1개 저장해야 하므로 break 해서 반목문 종료
                    }
                } // for 종료 후에 save 변수 값이 false 이면 출력
                if (save) {
                    System.out.println("게시물 쓰기 성공");
                } else {
                    System.out.println("게시물 쓰기 실패 : 빈 공간이 없습니다.");
                }if (choose == 2) {
                    for (int index = 0; index <= contents.length-1; index++) {
                        if (contents[index] != null){ // 만약에 index번째 게시물이 존재하면
                            System.out.printf("작성자 : %s, 내용 : %s\n", writers[index], contents[index]);
                        }
                    }
                }
            }
        } // while end
    } // main end
} // class end
