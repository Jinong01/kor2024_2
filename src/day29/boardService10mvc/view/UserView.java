package day29.boardService10mvc.view;

import day29.boardService10mvc.controller.UserController;

import java.util.Scanner;

public class UserView {

    static Scanner scan =  new Scanner(System.in);

    public void mainPage(){
        while (true) {
            System.out.println("---- 메뉴 ----");
            System.out.println("1.회원가입 2.로그인");
            int choose = 0;
            try {
                choose = scan.nextInt();
            } catch (Exception e) {
                System.out.println("숫자만 입력하세요.");
                scan.nextLine();
                continue;
            }
            switch (choose) {
                case 1:
                    signUP();
                    break;

                case 2:
                    logIn();
                    break;

                default:
                    return;
            }
        }
    }

    private static UserView userView = new UserView();
    private UserView(){}
    public static UserView getInstance(){
        return userView;
    }

    public void signUP() {
        while (true) {

            System.out.println("등록할 ID: ");
            String id = scan.next();

            if (UserController.getInstance().checkId(id)) {
                System.out.println("이미 등록된 ID 입니다.");
                continue;
            }

            System.out.println("등록할 PWD: ");
            String pwd = scan.next();
            System.out.println("등록할 Name: ");
            String name = scan.next();
            UserController.getInstance().signUp(id, pwd, name);
            System.out.println("회원가입이 완료 되었습니다.");
            return;
        }
    }
    public void logIn(){
        System.out.println("ID: "); String id = scan.next();
        System.out.println("PWD: "); String pwd = scan.next();
        UserController.getInstance().logIn(id,pwd);
    }
}
