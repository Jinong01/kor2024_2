package day25.boardService9mvc.model;



import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class BoardDao {
    private static BoardDao boardDao = new BoardDao();
    private BoardDao(){

        // 만약에 파일을 로드하는데 파일이 존재하지 않으면, 만들기
        File file = new File("./src/day25/boardService9mvc/data.txt");
        if (!file.exists()){fileLoad();}
        else {try {
            file.createNewFile();}
        catch (IOException e){e.printStackTrace();}}
        // - 싱글톤(static)이 생성될 때 = 프로그램이 실행될 때
        //fileLoad();
    }
    public static BoardDao getInstance(){
        return boardDao;
    }

     /* [생각해보기]
        1. txt 메모장은 문자열만 저장되는 윈도우 프로그램의 확장자
        2. 게시물들(ArrayList<BoardDto>)을 저장하기 위해서는 변환이 필요하다. java 는 객체지향
        문제점 발견 : 서로 다른 언어/프로그램들 간의 데이터를 주고 받을려면 형식/타입이 같으면 좋을텐데.
        - 관례적으로 사용되는 타입 : CSV, JSON, XML 파일 타입 주로 사용한다.
        --> 서로 다른 언어/프로그램들 간의 공통된 형식/타입을 사용해서 데이터를 통신하자.

        [ CSV ]
        1. 쉼표(,)로 구분된 문자열로 구성된 파일 형식
        2. \n 이용한 줄바꿈 처리
        3. .csv 확장자를 가짐

        [ 게시물 객체를 CSV 형식으로 변환 ] , [ CSV 형식을 자바 객체로 변환 ]
        1. boardDto( content="안녕하세요", writer="유재석", pwd=1234 ) : 자바 객체를 임의로 시각화
        2. 하나의 문자열로 필드명을 제외한 필드 값들을 쉼표로 구분하여 문자열로 변환 : "안녕하세요,유재석,1234"

        [ 여러개 게시물 객체가 존재 했을 때 ]
        point1 : 필드 간의 구분을 쉼표로 한다.
        point2 : 객체 간의 구분을 \n으로 한다.
     */

    ArrayList<BoardDto> boardDB = new ArrayList<>();

    // 1. 게시물 등록 접근 함수
    public boolean boardWrite(BoardDto boardDto) {
        boardDB.add(boardDto);
        fileSave();
        return true;
    }

    // 2. 게시물 출력 접근 함수
    public ArrayList<BoardDto> boardPrint(){
        return boardDB;
    }

    // ================= 영구저장을 위한 게시물들을 파일에 저장하는 기능 ================//
    public void fileSave(){ // 게시물 등록을 성공했을 때 호출
        String outStr = ""; // 임의의 문자열 선언
        for (int index = 0; index <= boardDB.size()-1; index++){
            BoardDto boardDto = boardDB.get(index);
            outStr += boardDto.getContent()+","+boardDto.getWriter()+","+boardDto.getPwd();
            // += 복합대입연산자 : 오른쪽 값을 왼쪽 변수값과 더한 후에 결과를 왼쪽 변수에 대입한다
            outStr += "\n";
        }
        System.out.println(outStr);
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("./src/day25/boardService9mvc/data.txt");
            outputStream.write(outStr.getBytes());
            System.out.println("[파일 저장 성공]");

        } catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
    }

    // ================= 영구저장 된 파일의 게시물들을 가져오는 기능 ================//
    public void fileLoad(){ // 프로그램이 실행 되었을때 한번만(Dao 객체(싱글톤) 생성될때)
        try {
            FileInputStream inputStream =
                    new FileInputStream("./src/day25/boardService9mvc/data.txt");
            File file = new File("./src/day25/boardService9mvc/data.txt");
            byte[] bytes = new byte[(int)file.length()];
            inputStream.read(bytes);
            String inStr = new String(bytes);
            // 활용 과제 : 파일로 부터 읽어온 문자열의 게시물 정보들을 boarDd에 저장하시오.
            // [1] 문자열 분해, "문자열.split("기준문자")
            // 객체구분문자(inStr.split("\n")) , 필드구분문자(inStr.split(",")
            String[] objStr = inStr.split("\n");
            for (int i = 0; i <= objStr.length-1; i++){
                String obj = objStr[i]; // 1개의 객체 필드 값들 가져오기
                // objStr = ["안녕하세요,유재석,1234" "..."]
                // objStr[0] = "안녕하세요,유재석,1234"
                // objStr[0].split(",") --> ["안녕하세요","유재석","1234"]
                // field = ["안녕하세요","유재석","1234"]
                // field[0] = "안녕하세요"
                String[] field = obj.split(",");
                String content = field[0];
                String writer = field[1];
                int pwd = Integer.parseInt(field[2]);
                BoardDto boardDto = new BoardDto(content,writer,pwd);
                boardDB.add(boardDto);
            }

        } catch (FileNotFoundException e) {e.printStackTrace();
        } catch (IOException e) {e.printStackTrace();}
    }

}
