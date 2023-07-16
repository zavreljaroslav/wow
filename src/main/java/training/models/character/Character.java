package training.models.character;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Character {
    private String name;
    private Class aClass;
    private int level;

    public Character(String name, Class aClass) {
        this.name = name;
        this.aClass = aClass;
        this.level = 1;
    }
    @Override
    public String toString(){
        return name + " the " + aClass.getClassName().toLowerCase();
    }
}
