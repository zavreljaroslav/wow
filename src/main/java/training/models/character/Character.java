package training.models.character;

import lombok.Getter;
import lombok.Setter;
import training.models.items.Item;
import training.utils.Utils;

import java.util.List;

@Setter
@Getter
public class Character {
    private String name;
    private Class aClass;
    private int level;
    private List<Item> inventory;

    public Character(String name, Class aClass) {
        this.name = name;
        this.aClass = aClass;
        this.level = 1;
        this.aClass.setClassName(name);
    }

    @Override
    public String toString() {
        if (aClass.getPrimaryResource().getPrimaryResourceType() == Utils.primaryResourceType.ENERGY) {
            return name + " the " + aClass.getClassNameTag() +
                    "\nHP: " + aClass.getCurrentHp() +
                    "\nEnergy: " + aClass.getPrimaryResource().getAmount();
        } else if (aClass.getPrimaryResource().getPrimaryResourceType() == Utils.primaryResourceType.MANA) {
            return name + " the " + aClass.getClassNameTag() +
                    "\nHP: " + aClass.getCurrentHp() +
                    "Mana: " + aClass.getPrimaryResource().getAmount();
        } else {
            return name + " the " + aClass.getClassNameTag() +
                    "\nHP: " + aClass.getCurrentHp() +
                    "Rage: " + aClass.getPrimaryResource().getAmount();
        }

    }
}
