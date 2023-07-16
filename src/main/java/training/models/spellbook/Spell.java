package training.models.spellbook;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Spell {
    protected int cost;
    protected int damage;
    protected String name;

    public Spell(int cost, int damage) {
        this.cost = cost;
        this.damage = damage;
    }
    @Override
    public String toString(){
        return "Name: " + this.name + "\n   Damage: " + this.damage + "\n   Cost: " + this.cost;
    }
}
