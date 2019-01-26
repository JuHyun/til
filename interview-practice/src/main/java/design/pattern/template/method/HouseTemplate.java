package design.pattern.template.method;

public abstract class HouseTemplate {

    public final void buildHouse() {
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
    }

    private void buildWindows() {
        System.out.println("Building Glass Windows.");
    }

    protected abstract void buildWalls();

    protected abstract void buildPillars();

    private void buildFoundation() {
        System.out.println("Build foundation...");
    }
}
