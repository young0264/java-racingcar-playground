package carGame;

public class Car {

    String carName;

    public static boolean isValidCarName(String name) {
        return name.length() <= 5;
    }

    public static int randomNumber() {
        return (int) ((Math.random() * 10000) % 9);
    }
}
