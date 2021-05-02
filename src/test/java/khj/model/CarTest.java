package khj.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @ParameterizedTest(name = "랜덤값이 4이상이면 앞으로 이동한다. 파라미터: {0}, 결과: {1}")
    @CsvSource({"3,0", "4,1"})
    void moveAndStop(int value, int move) {
        Car car = new Car("test");

        car.moveAndStop(value);

        assertEquals(move, car.getMove());
    }
}
