package day23;

public class Board {
    /*
       public : 공개용
       private : 비공개용, 다른 클래스에서 접근을 차단하는 키워드
        - 이유 : 외부로부터 직접접근 차단. 객체의 자료는 중요하기 때문에 쉽게 저장/변경 하면 안된다.
            (유효성검사 - 1. 원하는 데이터인지 2. 안전한 데이터인지)
        - 객체를 통해 필드 직접 접근을 차단하고 간접접근을 이용한 유효성검사를 시행한다.
        protected : 동일한 패키지 내에서 접근 가능, 상속관계이면 다른 패키지도 가능
        default : 동일한 패키지 내에서 접근 가능, 위 3가지를 작성 안했을때 기본적으로 적용되는 접근제한자
     */

    // 1. 멤버변수(필드)
    private String content;
    private String writer;
    private int pwd;

    // 2. 생성자 : 객체 생성시 new 뒤로 오는 함수
    // 생성자는 매개변수(함수안으로 들어오는 값을 저장하는 변수)가 있지만 반환값(함수가 종료될때 반환값)이 없다
    // 오버로딩 : 동일한 함수명/생성자명으로 선언은 불가능 하지만 매개변수의 타입,개수,순서에 따라 식별 가능한 함수를 선언하는 방법
    Board() {
    }

    Board(String content) {
        this.content = content;
    }

    Board(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }

    Board(String content, String writer, int pwd) {
        this.content = content;
        this.writer = writer;
        this.pwd = pwd;
    }

    //3. 메소드
    // getter 함수(필드값 호출함수) : private 선언된 필드를 public 함수로 외부 클래스부터 간접접근 허용한다.
    // setter 함수(필드값 저장함수) : private 선언된 필드를 public 함수로 외부 클래스부터 간전접근 허용
    public String getContent() {
        return this.content;
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

    @Override // 재정의
    public String toString() {
        return "작성자 : " + writer + " 내용 : " + content + " 비밀번호 : " + pwd + "\n";
    }


}
