import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Game {
    Pet pet;
    volatile boolean gameOver;

    public void start() {
//        for (int i = 0; i < 50; i++) {
//            System.out.println("");
//        }
        System.out.print("\033[H\033[2J");
        System.out.println("============반려동물 키우기 시뮬레이터============");
        System.out.println("||            반려동물을 선택하세요!            || ");
        System.out.println("||              1. 고양이                   ||");
        System.out.println("||              2. 강아지                   ||");
        System.out.println("=============================================");
        System.out.print("선택 (1 or 2): ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

//         Clear screen
        for (int i = 0; i < 50; i++) {
            System.out.println(" ");
        }


        if (choice == 1) {
            System.out.println("반려묘의 이름을 지어주세요!");
            pet = new Cat();
            pet.name = scanner.next();
            pet.hunger = 100;
            pet.sleepiness = 100;
            pet.stress = 100;

            // 5초 마다 pet.tick()실행
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            scheduler.scheduleAtFixedRate(() -> {
                pet.tick();
//                System.out.println(pet.hunger + " " + pet.sleepiness + " " + pet.stress);
            }, 5, 5, TimeUnit.SECONDS);
            int cmd = -1;
            while (!gameOver) {
                System.out.println("============반려동물 키우기 시뮬레이터============");
                System.out.println("메뉴");
                System.out.println("1. 밥주기");
                System.out.println("2. 재우기");
                System.out.println("3. 쓰다듬기");
                System.out.println("0을 누르면 게임이 종료됩니다");
                cmd = scanner.nextInt();
                viewStats(pet);

                switch (cmd) {
                    case 1:
                        pet.feed();
                        break;

                    case 2:
                        pet.lullaby();
                        break;

                    case 3:
                        ((Cat) pet).groom();
                        break;

                    case 0:
                        gameOver = true;
                        break;
                }
                checkGameOver(pet);
                if (gameOver) {
                    scheduler.shutdown();                           // 백그라운드 실행 중인 작업 종료
                    System.out.println("플레이해주셔서 감사합니다");
                }
            }
        } else if (choice == 2) {

            System.out.println("강아지를 선택하셨군요!");
            System.out.println("반려견의 이름을 지어주세요!");
            pet = new Dog();
            pet.name = scanner.next();
            pet.hunger = 100;
            pet.sleepiness = 100;
            pet.stress = 100;

            // 5초 마다 pet.tick()실행
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            scheduler.scheduleAtFixedRate(() -> {
                pet.tick();
//                System.out.println(pet.hunger + " " + pet.sleepiness + " " + pet.stress);
            }, 5, 5, TimeUnit.SECONDS);
            int cmd = -1;
            while (!gameOver) {
                System.out.println("============반려동물 키우기 시뮬레이터============");
                System.out.println("메뉴");
                System.out.println("1. 밥주기");
                System.out.println("2. 재우기");
                System.out.println("3. 산책가기");
                System.out.println("0을 누르면 게임이 종료됩니다");
                cmd = scanner.nextInt();
                viewStats(pet);

                switch (cmd) {
                    case 1:
                        pet.feed();
                        break;

                    case 2:
                        pet.lullaby();
                        break;

                    case 3:
                        ((Dog) pet).walk();
                        break;

                    case 0:
                        gameOver = true;
                        break;
                }
                checkGameOver(pet);
                if (gameOver) {
                    scheduler.shutdown();                           // 백그라운드 실행 중인 작업 종료
                    System.out.println("플레이해주셔서 감사합니다");
                }
            }
        }
    }


    public void checkGameOver(Pet pet) {
        if (!pet.isAlive()) {
            gameOver = true;
            System.out.println(pet.name + "이 죽었습니다");
            if (pet.sleepiness <= 0) {
                System.out.println("사인: 과로사");
            }
            if (pet.hunger <= 0) {
                System.out.println("사인: 아사");
            }
            if (pet.stress <= 0) {
                System.out.println("사인: 스트레스사");
            }
        }
    }

    public void viewStats(Pet pet) {
        // 현재 동물의 상태를 출력
        System.out.println("==============================================================================================================================");
        System.out.println(pet.name + "의 현제 상태:");
        System.out.print("Hunger:\t\t");
        for (int i = 0; i < pet.hunger; i++) {
            System.out.print("|");
        }
        System.out.println("");
        System.out.print("Sleepiness:\t");
        for (int i = 0; i < pet.sleepiness; i++) {
            System.out.print("|");
        }
        System.out.println("");
        System.out.print("Stress:\t\t");
        for (int i = 0; i < pet.stress; i++) {
            System.out.print("|");
        }
        System.out.println();
        System.out.println("==============================================================================================================================");

    }
}