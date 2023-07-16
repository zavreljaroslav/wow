package training.models.mobs;

import lombok.Getter;
import lombok.Setter;
import training.models.character.Class;
import training.models.character.PrimaryResource;
import training.models.spellbook.SpellBook;
import training.models.spellbook.TacoThrow;
import training.utils.Utils;

@Getter
@Setter
public class ChrisTheWheelchair extends Class {
    private final int energyRegenPerRound = 15;
    public ChrisTheWheelchair(){
        this.primaryResource = new PrimaryResource();
        this.primaryResource.setPrimaryResourceType(Utils.primaryResourceType.RAGE);
        regeneratePrimaryResource();
        this.spellBook = new SpellBook();
        this.spellBook.add(new TacoThrow());
        this.currentHp = this.baseHp * 0.8;
        this.baseDamage = this.baseDamage * 1;
        this.className = "Chris the Wheelchair";
        this.baseArmor = 1;
        this.primaryResource.setRegenPerRound(energyRegenPerRound);
    }
    public void generatePrimaryResource() {
        if (this.primaryResource.getAmount() < (this.primaryResource.getMaxAmount() - this.energyRegenPerRound)) {
            this.primaryResource.setAmount(this.primaryResource.getAmount() + this.energyRegenPerRound);
        } else {
            this.primaryResource.setAmount(this.primaryResource.getMaxAmount());
        }
    }
}
