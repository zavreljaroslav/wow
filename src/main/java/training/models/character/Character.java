package training.models.character;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Character {
    private String name;
    private Class aClass;

    public Character(String name, Class aClass) {
        this.name = name;
        this.aClass = aClass;
    }
}
