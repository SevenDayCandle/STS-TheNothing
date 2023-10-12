package thenothing.relics.the;

import pinacolada.actions.PCLActions;
import pinacolada.annotations.VisibleRelic;
import pinacolada.dungeon.PCLUseInfo;
import pinacolada.relics.PCLPointerRelic;
import pinacolada.relics.PCLRelicData;
import pinacolada.skills.PCond;
import pinacolada.skills.PMove;
import pinacolada.skills.skills.PSpecialSkill;
import pinacolada.skills.skills.PTrigger;
import pinacolada.skills.skills.special.primary.PRoot;
import thenothing.resources.the.TheResources;

@VisibleRelic
public class ARelic extends PCLPointerRelic {
    public static final PCLRelicData DATA = register(ARelic.class, TheResources.the)
            .setProps(RelicTier.STARTER, LandingSound.MAGICAL);

    public ARelic() {
        super(DATA);
    }

    public void action(PSpecialSkill move, PCLUseInfo info, PCLActions order) {
    }

    public void setup() {
        addUseMove(new PRoot(), getSpecialMove(0, this::action));
    }
}