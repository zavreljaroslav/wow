package training.models.spellbook;


import lombok.Getter;
import training.utils.Utils;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SpellBook {
    private List<Spell> spellList;

    public SpellBook(Utils.classes className) {
        spellList = new ArrayList<>();
        if (className.equals(Utils.classes.ROGUE)){
            spellList.add(new SinisterStrike());
        }
    }
}
