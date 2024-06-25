
import users.Shop;
import users.Trainee;
import users.Trainer;
import java.util.Scanner; // 입력받기 위해

//비동기 시간 스레드 추가
import java.util.concurrent.CompletableFuture; // 비동기 작업 처리를 위해
import java.util.concurrent.ExecutorService; // 스레드 풀을 관리하기 위해
import java.util.concurrent.Executors; // 스레드 풀 생성을 위해
import java.util.concurrent.ScheduledExecutorService; // 주기적인 작업 처리를 위해
import java.util.concurrent.TimeUnit; // 시간 단위를 지정하기 위해
import java.time.LocalDateTime; // 현재 시간을 처리하기 위해

public class Main {
    public static void main(String[] args) { // 프로그램 실행 시 가장 먼저 실행되는 main 메서드
        Scanner scanner = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
        System.out.println("기본 정보를 입력해주세요.");

        //비동기 시간 스레드 추가
        // ExecutorService를 사용하여 비동기 작업을 처리할 스레드 풀 생성
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 주기적으로 현재 시간을 출력하는 스레드 풀 생성
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        // 주기적으로 현재 시간을 출력하는 작업을 5초 간격으로 실행

        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Current time: " + LocalDateTime.now()); // 현재 시간을 출력
        }, 0, 5, TimeUnit.SECONDS);

        // 입력 작업을 비동기로 처리
        CompletableFuture<Void> inputFuture = CompletableFuture.runAsync(() -> {
            System.out.println("이름: ");
            String name = scanner.nextLine(); // 이름 입력받기
            System.out.println("역할 (1: 트레이너, 2: 트레이니, 3: 샵): ");
            int role = scanner.nextInt(); // 역할 입력받기
            System.out.println("종목 (1: 헬스, 2: 필라테스): ");
            int category = scanner.nextInt(); // 종목 입력받기
            // 입력 후 남아있는 개행 문자 제거
            scanner.nextLine();

            // 역할에 따라 다른 질문을 하고 질문에 대답한 내용 출력
            System.out.println("세부 정보를 입력해주세요.");
            switch (role) { // 조건
                case 1: // 트레이너
                    System.out.println("성별(M/W): ");
                    String gender = scanner.nextLine(); // 성별 입력받기
                    System.out.println("이력: ");
                    String career = scanner.nextLine(); // 이력 입력받기
                    System.out.println("수업료: ");
                    String input = scanner.nextLine(); // 수업료 입력받기
                    int lessonFee = Integer.parseInt(input); // 문자열을 정수로 변환
                    System.out.println("수업가능시간: ");

                    String availableTime = scanner.nextLine(); // 수업 가능 시간 입력받기
                    System.out.println("수업가능지역: ");
                    String availableArea = scanner.nextLine(); // 수업 가능 지역 입력받기
                    // 입력받은 값 trainer class에 넘겨주기
                    Trainer trainer = new Trainer(name, role, category, gender, career, lessonFee, availableTime, availableArea);
                    System.out.println("입력하신 트레이너 정보입니다.");
                    trainer.displayInfo(); // 트레이너 정보 출력
                    break;
                case 2: // 트레이니
                    System.out.print("키(cm): ");
                    int height = scanner.nextInt(); // 키 입력받기
                    System.out.print("몸무게(kg): ");
                    int weight = scanner.nextInt(); // 몸무게 입력받기
                    // 입력받은 값 trainee class에 넘겨주기
                    Trainee trainee = new Trainee(name, role, category, height, weight);
                    System.out.println("입력하신 트레이니 정보입니다.");
                    trainee.displayInfo(); // 트레이니 정보 출력
                    break;
                case 3: // 샵
                    System.out.print("샵 위치: ");
                    String location = scanner.nextLine(); // 샵 위치 입력받기
                    System.out.print("대관료: ");
                    int rentalFee = scanner.nextInt(); // 대관료 입력받기
                    System.out.print("사용 가능한 시간대: ");
                    scanner.nextLine(); // 개행 문자 제거
                    String availableShopTime = scanner.nextLine(); // 사용 가능한 시간대 입력받기
                    // 입력받은 값 shop class에 넘겨주기
                    Shop shop = new Shop(location, rentalFee, availableShopTime);
                    System.out.println("입력하신 샵 정보입니다.");
                    System.out.println("샵이름: " + name); // 이름 출력
                    System.out.println("샵 종목(1: 헬스, 2: 필라테스): " + category); // 종목 출력
                    shop.shopInfo(); // 샵 정보 출력
                    break;
                default:
                    System.out.println("역할을 선택해주세요.(1: 트레이너, 2: 트레이니, 3: 샵)");
            }
        }, executorService);

        // 입력 작업이 완료될 때까지 대기
        inputFuture.join();
        // 입력이 완료된 후의 시간을 기록하고 출력
        LocalDateTime registrationTime = LocalDateTime.now(); // 현재 시간을 기록
        System.out.println("Information registered at: " + registrationTime); // 입력 완료 시간을 출력

        // ExecutorService 종료
        executorService.shutdown();
        // ScheduledExecutorService 종료
        scheduler.shutdown();
    }
}