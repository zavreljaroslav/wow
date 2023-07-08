package training.models.items;

public abstract class Item {
    protected int primaryAttribute;
    protected int stamina;

    public Item(int primaryAttribute, int stamina) {
        this.primaryAttribute = primaryAttribute;
        this.stamina = stamina;
    }
}
