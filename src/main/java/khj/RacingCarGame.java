package khj;

import khj.exception.CarNameLengthOverException;
import khj.model.Cars;
import khj.input.RacingGameInput;

import java.util.InputMismatchException;

public class RacingCarGame {
    private final RacingGameInput input = new RacingGameInput();
    Cars cars;

    public void start() {
        String[] carNames = inputCarNames();
        int roundNumber = inputRoundNumber();
        cars = new Cars(carNames);

        gameRoundProgress(roundNumber);
        String winner = cars.finishAndResult();

        System.out.println(winner + "가 최종 우승했습니다.");
    }

    private String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");

        String[] carNames;

        do {
            carNames = inputCarNameTryProcess();
        } while (carNames == null);

        return carNames;
    }

    private String[] inputCarNameTryProcess() {
        try {
            return input.inputCarNames();
        } catch (CarNameLengthOverException e) {
            System.out.println("자동차 이름은 5글자 이하입니다.");
            return null;
        }
    }

    private int inputRoundNumber() {
        System.out.println("시도할 회수는 몇회인가요?");

        int roundNumber;

        do {
            roundNumber = inputRoundNumberTryProcess();
        } while (roundNumber == 0);

        return roundNumber;
    }

    private int inputRoundNumberTryProcess() {
        try {
            return input.inputRound();
        } catch (InputMismatchException e) {
            System.out.println("숫자가 아닌 값이 입력되었습니다.");
            return 0;
        }
    }

    private void gameRoundProgress(int roundNumber) {
        for (int round = 0; round < roundNumber; round++) {
            cars.roundStart();
        }
    }
}
