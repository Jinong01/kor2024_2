package day25;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileExample {
    public static void main(String[] args) {

        // 1. 파일 출력 (쓰기)
        // - 자바에서 사용되는 데이터를 자바 외부(C:/java) 메모장으로 저장
        try { // 예외가 발생할 것 같은 코드 try{} 안에 작성한다.
            // D 드라이브에 java 라는 폴더를 생성하고 실행
            // FileOutputStream fileOutput = new FileOutputStream("d:/java/test1.txt");

            // - 현재 프로젝트 내 'src -> day25 -> test1.txt' 파일 생성한다.
            FileOutputStream fileOutput = new FileOutputStream("./src/day25/test1.txt");
            fileOutput.write("Hello Java".getBytes());

        } catch (FileNotFoundException e){ // [특정]예외가 발생 했을 때 실행되는 코드 작성한다.
            e.printStackTrace();

        } catch (Exception e) {
            // [모든]예외가 발생 했을 때 실행되는 코드 작성한다.
            // Exception : 예외클래스의 최상위 클래스
            e.printStackTrace();

        } finally {
            // 예외가 있던 없던 실행되는 코드 작성한다.
        }

    }
}
