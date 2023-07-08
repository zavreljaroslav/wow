package training.models.items;

import lombok.Getter;

@Getter
public class BodyArmour extends Item{
    private int armourValue;
    public BodyArmour(int armourValue, int primaryAttribute, int stamina) {
        super(primaryAttribute, stamina);
        this.armourValue = armourValue;
    }
}
