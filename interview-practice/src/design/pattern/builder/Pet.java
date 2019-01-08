package design.pattern.builder;

public class Pet {

    private String petName;
    private String ownerName;
    private PetType petType;

    private Pet(String petName, String ownerName) {
        this.petName = petName;
        this.ownerName = ownerName;
    }

    public Pet(String petName, String ownerName, PetType petType) {
        this.petName = petName;
        this.ownerName = ownerName;
        this.petType = petType;
    }

    public String getPetName() {
        return this.petName;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public PetType getPetType() {
        return this.petType;
    }

    public static class Builder {
        private String petName;
        private String ownerName;
        private PetType petType = PetType.Dog;

        public Builder withPetName(String petName) {
            this.petName = petName;
            return this;
        }

        public Builder withOwnerName(String ownerName) {
            this.ownerName = ownerName;
            return this;
        }

        public Builder withPetType(PetType petType) {
            this.petType = petType;
            return this;
        }

        public Pet build() {
            if (petName != null && ownerName != null) {
                return new Pet(petName, ownerName, petType);
            }

            throw new IllegalStateException("Cannot create Pet");
        }
    }
}
