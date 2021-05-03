package khj.input;

import khj.exception.CarNameLengthOverException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RacingGameInput {

    public String[] inputCarNames() throws CarNameLengthOverException {
        String carNames = inputStr();
        String[] carNameArray = splitCarName(carNames);

        for (String carName: carNameArray) {
            carNameLengthCheck(carName);
        }

        return carNameArray;
    }

    private String inputStr() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private String[] splitCarName(String carNames) {
        final String DELIMITER = ",";
        return carNames.split(DELIMITER);
    }

    private void carNameLengthCheck(String carName) {
        final int CAR_NAME_LENGTH_MAX = 5;

        if (carName.length() > CAR_NAME_LENGTH_MAX) {
            throw new CarNameLengthOverException();
        }
    }

    public int inputRound() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        int roundNumber = scanner.nextInt();
        return roundNumber;
    }
}
