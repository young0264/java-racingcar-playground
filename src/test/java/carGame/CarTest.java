package carGame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_이름길이_검증() {
        boolean validCarName = Car.isValidCarName("pobi");
        Assertions.assertThat(validCarName).isTrue();
    }

    @Test //랜덤 테스트는 좀
    void _0_9_전진조건() {
        int num = Car.isValidNum();
        System.out.println(num);
        Assertions.assertThat(0 <= num && num <= 9).isTrue();
    }


}
