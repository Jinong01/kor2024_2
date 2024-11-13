package day22;

public class NewBoard {
    /* public : 공개용
       private : 비공개용
        - 이유 : 객체의 자료는 중요하기 때문에 쉽게 저장/변경 하면 안된다.
            (유효성검사 - 1. 원하는 데이터인지 2. 안전한 데이터인지)
        - 객체를 통해 필드 직접 접근을 차단하고 간접접근을 이용한 유효성검사를 시행한다.
        protected : 동일한 패키지 내에서 접근 가능, 상속관계이면 다른 패키지도 가능
        default : 동일한 패키지 내에서 접근 가능, 위 3가지를 작성 안했을때 기본적으로 적용되는 접근제한자
     */
    private String content;
    private String writer;
    private int pwd;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getPwd() {
        return pwd;
    }

    public void setPwd(int pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "NewBoard{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", pwd=" + pwd +
                '}';
    }
}
