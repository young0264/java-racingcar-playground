package Calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    void 공백시_0반환() {
        Integer sumNum = Calculator.stringSplitSum("");
        assertThat(sumNum).isEqualTo(0);
    }
    @Test
    void 한개입력시_숫자반환() {
        Integer sumNum = Calculator.stringSplitSum("2");
        assertThat(sumNum).isEqualTo(2);
    }
    @Test
    void 쉼표_구분자() {
        Integer sumNum = Calculator.stringSplitSum("2,4");
        assertThat(sumNum).isEqualTo(6);
    }
    @Test
    void 쉼표와콜론_구분자() {
        Integer sumNum = Calculator.stringSplitSum("2,4,6");
        assertThat(sumNum).isEqualTo(12);
    }
    @Test
    void split_custom_구분자() {
        Integer sumNum = Calculator.stringSplitSum("//;\n1;2;3");
        assertThat(sumNum).isEqualTo(6);
    }
    @Test
    void split_minus_value() {
        assertThatThrownBy(() -> Calculator.stringSplitSum("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
