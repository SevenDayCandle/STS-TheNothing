package thenothing.cards.the;

import pinacolada.actions.PCLActions;
import pinacolada.annotations.VisibleCard;
import pinacolada.cards.base.PCLCard;
import pinacolada.cards.base.PCLCardData;
import pinacolada.cards.base.fields.PCLCardTarget;
import pinacolada.dungeon.PCLUseInfo;
import pinacolada.skills.PMove;
import pinacolada.skills.skills.PSpecialSkill;
import thenothing.resources.the.TheResources;

@VisibleCard
public class ACard extends PCLCard {
    public static final PCLCardData DATA = register(ACard.class, TheResources.the)
            .setSkill(1, CardRarity.SPECIAL, PCLCardTarget.Self)
            .setBlock(1, 1)
            .setCore();

    public ACard() {
        super(DATA);
    }

    public void action(PSpecialSkill move, PCLUseInfo info, PCLActions order) {
    }

    public void setup(Object input) {
        addBlockMove();
        addUseMove(PMove.draw(1));
        addSpecialMove(0, this::action, 1);
    }
}