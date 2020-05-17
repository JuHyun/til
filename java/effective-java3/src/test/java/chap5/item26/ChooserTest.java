package chap5.item26;

import org.junit.jupiter.api.Test;

import java.util.List;

class ChooserTest {

    @Test
    void choose() {
        Chooser chooser = new Chooser(List.of(1, 2, 3, 4, 5));
        Integer choose = (Integer) chooser.choose();
        System.out.println(choose);
    }
}
