package carGame;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

//반복구현을 전제로 일단 막구현 했습니다..
public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String cars = scanner.nextLine();
        System.out.println("시도할 회수는 몇회인가요?");
        int num = scanner.nextInt();
        System.out.println("실행결과");
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        int maxLength = 0;

        String[] car_arr = cars.split(",");
        for (String car : car_arr) {
            myMap.put(car, 0);
        }

        for (int i = 0; i < num; i++) {
            for (String car : car_arr) {
                int dist = (int) ((Math.random() * 10000) % 9);
                myMap.put(car, myMap.get(car) + dist);
                Integer cardist = myMap.get(car);
                maxLength = Math.max(maxLength, cardist);
                System.out.println(car + " : " + Collections.nCopies(cardist,"-").stream().map(String::valueOf).collect(Collectors.joining("")));
            }
            System.out.println();
        }
        ArrayList winners = new ArrayList();
        for (String key : myMap.keySet()) {
            if (myMap.get(key) == maxLength) {
                winners.add(key);
            }
        }
        String str_winners = (String) winners.stream().collect(Collectors.joining(","));
        System.out.println(str_winners+"가 최종 우승했습니다.");
    }
}