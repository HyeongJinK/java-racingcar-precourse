package khj.input;

import khj.exception.CarNameLengthOverException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingGameInputTest {
    RacingGameInput input = new RacingGameInput();

    @DisplayName(value = "파라미터로 넘긴 값을 ,로 구분하여 배열을 만들어 리턴한다.")
    @Test
    void inputCarNames() {
        ByteArrayInputStream stream = new ByteArrayInputStream("qwe,asd,zxc".getBytes());
        System.setIn(stream);

        String[] carNames = input.inputCarNames();

        Assertions.assertEquals(3, carNames.length);
        Assertions.assertEquals("qwe", carNames[0]);
        Assertions.assertEquals("asd", carNames[1]);
        Assertions.assertEquals("zxc", carNames[2]);
    }

    @DisplayName(value = "자동차 이름이 5자를 넘어가면 예외를 리턴한다.")
    @Test
    void inputCarNamesLengthCheck() {
        ByteArrayInputStream stream = new ByteArrayInputStream("qwerty,asd,zxc".getBytes());
        System.setIn(stream);

        assertThrows(CarNameLengthOverException.class, () -> {
            input.inputCarNames();
        });
    }

    @DisplayName(value = "자동차 전진 시도 횟수를 입력받는 다.")
    @Test
    void inputRound() {
        ByteArrayInputStream stream = new ByteArrayInputStream("5".getBytes());
        System.setIn(stream);

        int roundNumber = input.inputRound();

        assertEquals(5, roundNumber);
    }

    @DisplayName(value = "전진 시도 횟수를 입력 받는 데 숫자가 아닌 값이 오면 예외를 리턴한다.")
    @Test
    void inputRoundTypeCheck() {
        ByteArrayInputStream stream = new ByteArrayInputStream("a".getBytes());
        System.setIn(stream);

        assertThrows(InputMismatchException.class, () -> {
            input.inputRound();
        });
    }
}
