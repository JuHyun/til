package item3.staticfinalfield;

/**
 * 장점: 싱글턴임이 API에 명백히 드러난다. 간결하다.
 *
 * 주의!
 * 직렬화하려면 Serializable을 구현한다고 선언하는 것만으로는 부족하다.
 * 모든 인스턴스 필드를 transient라고 선언하고, readResolve 메서드를 제공해야 한다.
 * 이렇게 하지 않으면 직렬화된 인스턴스를 역직력화할 때마다 새로운 인스턴스가 만들어진다.
 */
public class Elvis {

    public static final Elvis INSTANCE = new Elvis();

    public Elvis() {
    }

    public void leaveTheBuilding() {
    }
}
