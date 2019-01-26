package design.pattern.builder;

public enum PetType {
    Dog(1000), Cat(2000), Bird(3000);

    private int value;

    PetType(int value) {
        this.value = value;
    }
}
