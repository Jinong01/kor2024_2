package day25;

import java.io.*;
import java.util.Scanner;

public class FileExample3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 생각해보기: 키보드로 부터 입력받은 문자열을 'day25' 폴더 내 test2.txt 에 저장하시오
        // 'day25' 폴더 내 test.txt 에 저장된 문자열을 읽어 콘솔에 출력하시오

        try {
            FileOutputStream fileOutput = new FileOutputStream("./src/day25/test2.txt");
            System.out.println("저장할 내용 입력 : ");
            String outStr = sc.next();
            fileOutput.write(outStr.getBytes());
            System.out.println("저장 성공");

            FileInputStream fileInput = new FileInputStream("./src/day25/test2.txt");
            // byte[] bytes = new byte[1000]; 임의로 1000 정함

            // 읽어올 파일을 용량/바이트 개수를 확인 후 파일의 용량만큼 배열 선언
            File file = new File("./src/day25/test2.txt");
            System.out.println(file.isFile()); // true
            System.out.println(file.getName()); // test.txt
            System.out.println(file.length()); // 반환타입 long
            byte[] bytes = new byte[(int)file.length()];
                // (캐스팅) : 강제 타입 변환. long -> int
                // 배열 내 [] 안에 들어가는 배열크기는 타입이 정수(int)만 가능하다.

            fileInput.read(bytes);
            String inStr = new String(bytes);
            System.out.println("불러오기 성공");
            System.out.println(inStr);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
