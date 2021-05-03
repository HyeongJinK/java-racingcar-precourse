package khj.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

public class Cars {
    private List<Car> carList;

    public Cars(String[] carNameArray)  {
        carList = new ArrayList<>();
        for (String carName: carNameArray) {
            carList.add(new Car(carName));
        }
    }

    public void roundStart() {
        Random random = new Random();
        final int RANDOM_BOUND = 10;

        for (Car car: carList) {
            car.moveAndStop(random.nextInt(RANDOM_BOUND));
            car.print();
        }
        System.out.println("");
    }

    public String finishAndResult() {
        int top = getTopMove();
        return getWinnersStr(top);
    }

    private int getTopMove() {
        int top = 0;
        for (Car car: carList) {
            top = getLarge(top, car);
        }
        return top;
    }

    private int getLarge(int top, Car car) {
        if (top < car.getMove()) {
            return car.getMove();
        }
        return top;
    }

    private String getWinnersStr(int top) {
        StringJoiner joiner = new StringJoiner(",");

        for (Car car: carList) {
            addWinner(top, joiner, car);
        }

        return joiner.toString();
    }

    private void addWinner(int top, StringJoiner joiner, Car car) {
        if (top == car.getMove()) {
            joiner.add(car.getName());
        }
    }
}
