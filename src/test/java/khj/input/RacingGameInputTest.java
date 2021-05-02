package khj.input;

import khj.exception.CarNameLengthOverException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

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
}
