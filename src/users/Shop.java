package users;

//shop은 user를 상속받지 않는다.
public class Shop{ // Shop 클래스 정의
    private String location; // 샵 위치
    private int rentalFee; // 대관료
    private String availableShopTime; // 사용 가능한 시간대

    public Shop( String location, int rentalFee,  String availableShopTime) { // 생성자
        this.location=location;
        this.rentalFee=rentalFee;
        this.availableShopTime=availableShopTime;
    }

    public void shopInfo() { // 정보 출력 메서드
        System.out.println("위치: " + location); // 샵 위치 출력
        System.out.println("대관료: " + rentalFee); // 대관료 출력
        System.out.println("사용 가능한 시간대: " + availableShopTime); // 사용 가능한 시간대 출력
    }
}
