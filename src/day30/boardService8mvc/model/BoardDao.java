package day30.boardService8mvc.model;


import java.sql.*;
import java.util.ArrayList;

public class BoardDao {

    private Connection conn ;
    private static BoardDao boardDao = new BoardDao();
    private BoardDao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1122","root", "1234");
            System.out.println("[ BoardDB Connection OK ]");
        }catch ( ClassNotFoundException e ){
            e.getMessage(); System.out.println("[ BoardDB Connection fail ]");
            // 실패이유 : 1. 프로젝트내 JDBC 라이브러리 등록 2. 오타(클래스경로,DB서버경로) 체크 3. MYSQL 워크벤치에서 DB 존재 체크
        }catch( SQLException e ){
            e.getMessage(); System.out.println("[ BoardDB Connection fail ]");
        }
    }
    public static BoardDao getInstance(){
        return boardDao;
    }

    // ArrayList<BoardDto> boardDB = new ArrayList<>();
    /*
    // 1. 게시물 등록 접근 함수
    public boolean boardWrite(BoardDto boardDto) {

        boardDB.add(boardDto);
        return true;
    }
        */
    // 2. 게시물 출력 접근 함수
    public ArrayList<BoardDto> boardPrint() throws SQLException {
        // 1. SQL 작성
        String sql = "select * from board";
        // 2. SQL 기재
        PreparedStatement ps = conn.prepareStatement(sql);
        // 3. SQL 조작 : executeQuery(); : sql 실행 후 조회된 SQL 결과를 조작하는 resultSet 객체 변환

        // 4. SQL 실행 : executeQuery(); : sql 실행 후 조회된 SQL 결과를 조작하는 resultSet 객체 변환
        ResultSet rs = ps.executeQuery();
        // 5. SQL 결과
        ArrayList<BoardDto> boardDB = new ArrayList<>();
        while (rs.next()){ // rs.next() : 조회 결과에서 다음 레코드 이동 함수 다음 레코드가 없을때까지 , 결과 레코드가 3개면 3번 실행
            // 마지막 레코드까지 하나씩 레코드 이동
            // 레코드를 읽어서 각 필드별 데이터 호출 : rs.getString();
            int num = rs.getInt("num");
            String content = rs.getString("content");
            String writer = rs.getString("writer");
            int pwd = rs.getInt("pwd");

            BoardDto boardDto = new BoardDto(content , writer, pwd);
            boardDB.add(boardDto);
        }
        return boardDB;
    }




    public boolean boardWrite(BoardDto boardDto) throws SQLException {
        String sql = "insert into board (content , writer , pwd) values (?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, boardDto.getContent());
        ps.setString(2, boardDto.getWriter());
        ps.setInt(3, boardDto.getPwd());
        ps.execute();
        return true;
    }


}
