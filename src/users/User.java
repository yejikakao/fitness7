package users;

//User 클래스는 사용자에 대한 공통 속성과 메서드를 정의하는 상위 클래스
public class User {
    //User 상태(속성) 정의
    private String name; // 이름
    private int role; // 역할 (1: 트레이너, 2: 트레이니, 3: 샵)
    private int category; // 종목 (1: 헬스, 2: 필라테스)

    public User(String name,int role, int category) { // 기본 생성자
        this.name=name; //초기화
        this.role=role;
        this.category=category;
    }

    public void displayInfo() { // 정보 출력 메서드
        System.out.println("이름: " + name); // 이름 출력
        System.out.println("역할: " + role); // 역할 출력
        System.out.println("종목: " + category); // 종목 출력
    }
}
