package training.models.spellbook;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import training.utils.Utils;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SpellBook {
    private List<Spell> spellList = new ArrayList<>();

    public SpellBook(Utils.classes className) {

        if (className.equals(Utils.classes.ROGUE)) {
            spellList.add(new SinisterStrike());
        }
    }

    public void add(Spell spell) {
        spellList.add(spell);
    }
    @Override
    public String toString(){
        System.out.println("Spellbook:");
        int counter = 0;
        for (Spell spell: spellList) {
            counter++;
            System.out.println(counter + ". " + spell);
        }
        return "";
    }
}
