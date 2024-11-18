package day25.boardService9mvc.model;

public class BoardDto {
    private String content;
    private String writer;
    private int pwd;
    BoardDto( ){ }
    public BoardDto(String content) {this.content = content;}
    public BoardDto(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }
    public BoardDto(String content, String writer, int pwd) {
        this.content = content;
        this.writer = writer;
        this.pwd = pwd;
    }
    public String getContent() {return content;}
    public String getWriter() {return writer;}
    public int getPwd() {return pwd;}
    public void setContent(String content) {this.content = content;}
    public void setWriter(String writer) {this.writer = writer;}
    public void setPwd(int pwd) {this.pwd = pwd;}
    @Override
    public String toString() {
        return "게시판{" +
                "내용 ='" + content + '\'' +
                ", 작성자='" + writer + '\'' +
                ", 비밀번호=" + pwd +
                '}';
    }
}
