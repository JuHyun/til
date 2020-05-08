package item3.staticfactory;

/**
 * 장점: (마음이 바뀌면) API를 바꾸지 않고도 싱글턴이 아니게 변경할 수 있다.
 * 정적 팩터리를 제네릭 싱글턴 팩터리로 만들 수 있다.
 * 정적 팩터리의 메서드 참조를 Supplier로 사용할 수 있다.
 * ex) Elvis.getInstance 를 Supplier<Elvis> 로 사용할 수 있다.
 *
 * 주의!
 * 직렬화하려면 Serializable을 구현한다고 선언하는 것만으로는 부족하다.
 * 모든 인스턴스 필드를 transient라고 선언하고, readResolve 메서드를 제공해야 한다.
 * 이렇게 하지 않으면 직렬화된 인스턴스를 역직력화할 때마다 새로운 인스턴스가 만들어진다.
 */
public class Elvis {

    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
    }
}
