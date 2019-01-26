package design.pattern.template.method;

import org.junit.jupiter.api.Test;

public class HouseTemplateTest {

    @Test
    public void usingTemplateMethod() {
        HouseTemplate woodenHouseType = new WoodenHouse();
        woodenHouseType.buildHouse();

        HouseTemplate ironHouseType = new IronHouse();
        ironHouseType.buildHouse();
    }
}