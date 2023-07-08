package training.models.items;

import lombok.Getter;

@Getter
public class Weapon extends Item {
    private int minWeaponDamage;
    private int maxWeaponDamage;

    public Weapon(int minWeaponDamage, int maxWeaponDamage, int primaryAttribute, int stamina) {
        super(primaryAttribute, stamina);
        this.minWeaponDamage = minWeaponDamage;
        this.maxWeaponDamage = maxWeaponDamage;
    }
}
