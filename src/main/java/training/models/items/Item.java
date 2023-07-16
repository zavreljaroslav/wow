package training.models.items;

public abstract class Item {
    protected int primaryAttribute;
    protected int stamina;
    boolean equipped;
    boolean consumable;

    public Item(int primaryAttribute, int stamina) {
        this.primaryAttribute = primaryAttribute;
        this.stamina = stamina;
        this.equipped = false;
        this.consumable = false;
    }
}
