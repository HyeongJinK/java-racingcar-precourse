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

        for (Car car: carList) {
            car.moveAndStop(random.nextInt(10));
            car.print();
        }
        System.out.println("");
    }

    public String finishAndResult() {
        int max = getMaxMove();
        return getWinnersStr(max);
    }

    private int getMaxMove() {
        int max = 0;
        for (Car car: carList) {
            max = getLarge(max, car);
        }
        return max;
    }

    private int getLarge(int max, Car car) {
        if (max < car.getMove()) {
            return car.getMove();
        }
        return max;
    }

    private String getWinnersStr(int max) {
        StringJoiner joiner = new StringJoiner(",");

        for (Car car: carList) {
            addWinner(max, joiner, car);
        }

        return joiner.toString();
    }

    private void addWinner(int max, StringJoiner joiner, Car car) {
        if (max == car.getMove()) {
            joiner.add(car.getName());
        }
    }
}
