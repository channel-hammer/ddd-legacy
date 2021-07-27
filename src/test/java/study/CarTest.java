package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {

    @DisplayName("자동차 이름은 5자를 넘을 수 없다.")
    @Test
    void constructor() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Car("name-over-5-char"));
    }

    @DisplayName("값이 4 이상인 경우 자동차가 이동한다.")
    @Test
    void move() {
        final Car car = new Car("hak");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("값이 4 미만인 경우 자동차가 정지한다.")
    @Test
    void not_move() {
        final Car car = new Car("hak");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void go() {
        final Car car = new Car("hak");
        car.move(new GoStrategy());
        assertThat(car.getPosition()).isEqualTo(1);

    }

    @Test
    void stop() {
        final Car car = new Car("hak");
        car.move(new StopStrategy());
        assertThat(car.getPosition()).isEqualTo(0);

    }

}
