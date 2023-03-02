import lombok.*;

@Getter
@AllArgsConstructor
public class Magic {


    public Magic giveMeMagic(Character character){

    }

    static enum MagicType{
        wizardMagic(Job.wizard),
        priestMagic(Job.priest),
        warriorSkill(Job.warrior),
        rogueSkill(Job.rogue)
        ;

        MagicType(Job magicType) {

        }
    }

    static enum Spell {
        fire(MagicType.wizardMagic, 1),
        ice(MagicType.wizardMagic, 1),
        thunder(MagicType.wizardMagic, 1),
        poison(MagicType.wizardMagic, 2),
        heal(MagicType.priestMagic, 1),
        defenseUp(MagicType.priestMagic, 1),
        attackUp(MagicType.priestMagic, 1),
        cure(MagicType.priestMagic, 2),
        doubleAttack(MagicType.warriorSkill, 1),
        doubleArrow(MagicType.rogueSkill, 1)
        ;

        Spell(MagicType magicType, int spellLevel) {

        }
    }

}