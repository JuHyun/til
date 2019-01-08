package design.pattern.builder;

import design.pattern.builder.Pet;
import design.pattern.builder.PetType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PetTest {

    @Test
    public void legalBuild() {
        Pet.Builder builder = new Pet.Builder();
        Pet pet = builder.withPetName("KUKU")
                .withOwnerName("Yonghee")
                .build();

        assertEquals("KUKU", pet.getPetName());
        assertEquals("Yonghee", pet.getOwnerName());
        assertEquals(PetType.Dog, pet.getPetType());
    }

    @Test
    public void illegalBuild() {
        Pet.Builder builder = new Pet.Builder();
        assertThrows(IllegalStateException.class, () -> builder.withPetName("KUKU").withPetType(PetType.Bird).build());
    }
}