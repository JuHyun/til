package design.pattern.template.method;

public class WoodenHouse extends HouseTemplate {
    @Override
    protected void buildWalls() {
        System.out.println("Build Walls with Wood.");
    }

    @Override
    protected void buildPillars() {
        System.out.println("Build Pillars with Wood.");
    }
}
