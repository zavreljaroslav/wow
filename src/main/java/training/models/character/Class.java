package training.models.character;

import lombok.Getter;
import lombok.Setter;
import training.models.spellbook.SpellBook;
import training.utils.Utils;

@Getter
@Setter
public class Class{
    protected String className;
    protected String classNameTag;
    protected double baseHp = 100;
    protected double currentHp;
    protected double baseDamage = 5;
    protected double baseArmor = 0;
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
            int gain;
            if(primaryResource.getPrimaryResourceType().equals(Utils.primaryResourceType.RAGE)){
                gain = this.primaryResource.getMaxAmount() + (this.primaryResource.getMaxAmount() - this.getPrimaryResource().getAmount());
            } else {
                gain = this.primaryResource.getMaxAmount() - (this.primaryResource.getMaxAmount() - this.getPrimaryResource().getAmount());
            }

            if (gain >= energyRegenPerRound){
                System.out.println(getClassName() + " has gained " + energyRegenPerRound + " " + primaryResource.getPrimaryResourceType());
            } else {
                System.out.println(getClassName() + " has gained " + gain + " " + primaryResource.getPrimaryResourceType());
            }

            this.primaryResource.setAmount(this.primaryResource.getAmount() + energyRegenPerRound);
        } else {
            this.primaryResource.setAmount(this.primaryResource.getMaxAmount());
        }

    }
    @Override
    public String toString (){
        if (primaryResource.getPrimaryResourceType().equals(Utils.primaryResourceType.ENERGY)){
            return className +
                    "\nHP: " + currentHp +
                    "\nEnergy: " + this.primaryResource.getAmount();
        } else if (primaryResource.getPrimaryResourceType().equals(Utils.primaryResourceType.RAGE)) {
            return className +
                    "\nHP: " + currentHp +
                    "\nRage: " + this.primaryResource.getAmount();
        } else {
            return  className +
                    "\nHP: " + currentHp +
                    "\nMana: " + this.primaryResource.getAmount();
        }
    }

}
