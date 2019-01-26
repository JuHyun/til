package design.pattern.template.method;

public class IronHouse extends HouseTemplate {

    @Override
    protected void buildWalls() {
        System.out.println("Build Walls with Iron.");
    }

    @Override
    protected void buildPillars() {
        System.out.println("Build Pillars with Iron.");
    }
}
