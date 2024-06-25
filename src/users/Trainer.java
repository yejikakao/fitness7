package users;

//User클래스를 상속받겠다.
public class Trainer extends User { // 추상 클래스 Trainer 정의
    private String gender; // 성별 필드
    private String career; // 이력 필드
    private int lessonFee; // 수업료 필드
    private String availableTime; // 수업 가능 시간 필드
    private String availableArea; // 수업 가능 지역 필드

    //main에서 넘겨받은 요소들이 괄호 안 매개변수로 들어감
    public Trainer(String name,int role, int category,String gender,String career,int lessonFee,String availableTime,String availableArea) { // 생성자
        super(name,role, category); // 부모 클래스 생성자 호출
        this.gender=gender;
        this.career=career;
        this.lessonFee=lessonFee;
        this.availableTime=availableTime;
        this.availableArea=availableArea;
    }

    @Override
    public void displayInfo() { // 정보 출력 메서드
        super.displayInfo();
        System.out.println("성별: " + gender); // 성별 출력
        System.out.println("이력: " + career); // 이력 출력
        System.out.println("수업료: " + lessonFee); // 수업료 출력
        System.out.println("수업가능시간: " + availableTime); // 수업 가능 시간 출력
        System.out.println("수업가능지역: " + availableArea); // 수업 가능 지역 출력
    }
}