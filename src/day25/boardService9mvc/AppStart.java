package day25.boardService9mvc;

import day25.boardService9mvc.view.BoardView;

import java.io.FileOutputStream;

public class AppStart {
    public static void main(String[] args) {
        // 메인 뷰 요청
        // - 다른 클래스에 존재하는 함수를 호출하는 방법
        // -- 1. 객체를 생선한 후 객체명.메소드명()
        // 단, 패키지가 다르면 public 함수로 선언한다.

        /* 싱글톤 사용하기 전
        BoardView view = new BoardView();
        view.mainPage();
         */

        // 싱글톤 사용한 후
        BoardView.getInstance().mainPage();
    }
}
