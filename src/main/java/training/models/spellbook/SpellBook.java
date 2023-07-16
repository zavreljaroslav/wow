package training.models.spellbook;


import lombok.Getter;
import lombok.NoArgsConstructor;
import training.utils.Utils;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class SpellBook {
    private List<Spell> spellList = spellList = new ArrayList<>();
    ;

    public SpellBook(Utils.classes className) {

        if (className.equals(Utils.classes.ROGUE)) {
            spellList.add(new SinisterStrike());
        }
    }

    public void add(Spell spell) {
        spellList.add(spell);
    }
}
