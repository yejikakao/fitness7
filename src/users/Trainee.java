package users;

public class Trainee extends User { // Trainee 클래스 정의
    private int height; // 키 필드
    private int weight; // 몸무게 필드

    public Trainee(String name, int role, int category, int height, int weight) { // 생성자
        super(name,role, category); // 부모 클래스 생성자 호출
        this.height=height;
        this.weight=weight;
    }

    @Override
    public void displayInfo() { // 정보 출력 메서드
        super.displayInfo();
        System.out.println("키: " + height + "cm"); // 키 출력
        System.out.println("몸무게: " + weight + "kg"); // 몸무게 출력}
    }
}