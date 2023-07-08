package training.models.character;

import lombok.Getter;
import lombok.Setter;
import training.models.spellbook.SpellBook;
import training.utils.Utils;

@Getter
@Setter
public class Rogue extends Class {
    private final int energyRegenPerRound = 20;
    private final int maxEnergy = 100;
    private final int hpModifier = 1;
    private final int damageModifier = 2;

    public Rogue() {
        this.primaryResource = new PrimaryResource();
        this.primaryResource.setPrimaryResourceType(Utils.primaryResourceType.ENERGY);
        this.primaryResource.setAmount(maxEnergy);
        this.spellBook = new SpellBook(Utils.classes.ROGUE);
        this.baseHp = this.baseHp * hpModifier;
        this.baseDamage = this.baseDamage * damageModifier;
    }

    @Override
    public void regeneratePrimaryResource() {
        if (this.primaryResource.getAmount() < (this.maxEnergy - this.energyRegenPerRound)) {
            this.primaryResource.setAmount(this.primaryResource.getAmount() + this.energyRegenPerRound);
        } else {
            this.primaryResource.setAmount(100);
        }
    }
}
