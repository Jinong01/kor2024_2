package day26.view;

import day26.controller.TodoController;
import day26.model.TodoDao;
import day26.model.TodoDto;

import java.util.List;
import java.util.Scanner;

public class TodoView {

    Scanner scan = new Scanner(System.in);

    public void mainPage() {
        while (true) {

            System.out.println("1.할일 등록  2.할일 출력 3.수행여부 변경");
            int choose = 0;

            try {
                choose = scan.nextInt();
            } catch (Exception e) {
                System.out.println("숫자를 입력하세요.");
                scan.nextLine();
                continue;
            }

            switch (choose) {
                case 1:
                    todoWrite();
                    break;

                case 2:
                    todoPrint();
                    break;

                case 3:
                    todoChange();
                    break;

                default:
                    return;
            }
        }
    }

    public void todoWrite() {
        System.out.println("할일 : "); String todo = scan.next();
        System.out.println("마감기한 : "); String todoDate = scan.next();
        boolean complete = false;
        TodoController.getInstance().todoWrite(todo, todoDate, complete);
        System.out.println("[할일 등록 성공]");
    }

    public void todoPrint() {
        TodoController.getInstance().todoPrint();
        for (int index = 0; index <= TodoDao.getInstance().todoDb.size()-1; index++){
            System.out.printf("할일 : %s , 마감기한 : %s , 수행여부 : %b\n",
                    TodoDao.getInstance().todoDb.get(index).getTodo(),
                    TodoDao.getInstance().todoDb.get(index).getTodoDate(),
                    TodoDao.getInstance().todoDb.get(index).isComplete());
        }
    }

    public void todoChange(){
        System.out.println("할일 선택"); int ch = scan.nextInt();
        TodoController.getInstance().todoChange(ch);
    }
}
