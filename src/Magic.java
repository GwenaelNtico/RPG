import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Magic {

    private List<Spell> spells;

    public List<Spell> giveMeMagic(Job job){
        switch (job){
            case wizard:
                spells.add(Spell.fire);
                spells.add(Spell.ice);
                spells.add(Spell.thunder);
                break;
            case priest:
                spells.add(Spell.heal);
                spells.add(Spell.defenseUp);
                spells.add(Spell.attackUp);
                break;
            case warrior:
                spells.add(Spell.doubleAttack);
                break;
            case rogue:
                spells.add(Spell.doubleArrow);
                break;
            default:
                break;
        }
        return spells;
    }

    public List<Spell> giveMeMoreSpells(Character character, int level) {

        return spells;
    }

    static enum Spell {
        fire(Job.wizard, 1),
        ice(Job.wizard, 1),
        thunder(Job.wizard, 1),
        poison(Job.wizard, 2),
        heal(Job.priest, 1),
        defenseUp(Job.priest, 1),
        attackUp(Job.priest, 1),
        cure(Job.priest, 2),
        doubleAttack(Job.warrior, 1),
        doubleArrow(Job.rogue, 1)
        ;

        Spell(Job job, int spellLevel) {
        }
    }

}