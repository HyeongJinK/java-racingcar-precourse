package khj.input;

import khj.exception.CarNameLengthOverException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RacingGameInput {
    private final int CAR_NAME_LENGTH_MAX = 5;
    private final String DELIMITER = ",";

    public String[] inputCarNames() throws CarNameLengthOverException {
        Scanner scanner = new Scanner(System.in);
        String carNames = scanner.nextLine();

        String[] carNameArray = carNames.split(DELIMITER);

        for (String carName: carNameArray) {
            carNameLengthCheck(carName);
        }

        return carNameArray;
    }

    private void carNameLengthCheck(String carName) {
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
