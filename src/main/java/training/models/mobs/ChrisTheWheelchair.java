package training.models.mobs;

import training.models.character.Class;
import training.models.character.PrimaryResource;
import training.models.spellbook.SpellBook;
import training.models.spellbook.TacoThrow;
import training.utils.Utils;

public class ChrisTheWheelchair extends Class {
    int energyRegenPerRound = 15;
    public ChrisTheWheelchair(){
        this.primaryResource = new PrimaryResource();
        this.primaryResource.setPrimaryResourceType(Utils.primaryResourceType.RAGE);
        regeneratePrimaryResource();
        this.spellBook = new SpellBook();
        this.spellBook.add(new TacoThrow());
        this.baseHp = this.baseHp * 0.4;
        this.baseDamage = this.baseDamage * 0.4;
        this.className = "Chris the Wheelchair";
    }
    public void generatePrimaryResource() {
        if (this.primaryResource.getAmount() < (this.primaryResource.getMaxAmount() - this.energyRegenPerRound)) {
            this.primaryResource.setAmount(this.primaryResource.getAmount() + this.energyRegenPerRound);
        } else {
            this.primaryResource.setAmount(this.primaryResource.getMaxAmount());
        }
    }
}
