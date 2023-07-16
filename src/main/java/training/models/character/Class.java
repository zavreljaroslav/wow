package training.models.character;

import lombok.Getter;
import lombok.Setter;
import training.models.spellbook.SpellBook;
import training.utils.Utils;

@Getter
@Setter
public class Class {
    protected String className;
    protected double baseHp = 100;
    protected double baseDamage = 5;
    protected PrimaryResource primaryResource;
    protected SpellBook spellBook;

    public void regeneratePrimaryResource() {
        if (this.primaryResource.getPrimaryResourceType().equals(Utils.primaryResourceType.RAGE)) {
            this.primaryResource.setAmount(0);
        } else {
            this.primaryResource.setAmount(100); //this is for both energy and mana atm
        }
    }
    public void generatePrimaryResource(int energyRegenPerRound) {
        if (this.primaryResource.getAmount() < (this.primaryResource.getMaxAmount() - energyRegenPerRound)) {
            this.primaryResource.setAmount(this.primaryResource.getAmount() + energyRegenPerRound);
        } else {
            this.primaryResource.setAmount(this.primaryResource.getMaxAmount());
        }
    }

}
