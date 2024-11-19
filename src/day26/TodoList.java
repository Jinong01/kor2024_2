package day26;

import day26.view.TodoView;

/*
[ JAVACONSOLE ] TODOLIST 구축하기
    - 조건1 : boardService9mvc 활용하여 MVC 패턴과 싱글톤패턴과 파일처리 기능을 사용하시오.
    - 조건2 : 할일 관리(TODO) 기능은 할일 등록 과 할일전체출력 기능을 구현하시오.
    - 조건3 : 할일(TODO) 객체의 필드는 할일 내용 , 할일 마감날짜 , 할일 상태(T/F) 3개필드 필수 , 추가 가능

     - 활용조건1 : 할일 삭제 기능을 구현하시오.
     - 활용조건2 : 할일 상태 수정 기능을 구현하시오. 완료-->미완료 , 미완료-->완료
 */
public class TodoList {
    public static void main(String[] args) {
        TodoView todoView = new TodoView();

        todoView.mainPage();
    }
}

