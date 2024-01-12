package thenothing.characters;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.red.Strike_Red;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import extendedui.utilities.EUIColors;
import pinacolada.cards.base.PCLCustomCardSlot;
import pinacolada.characters.PCLCharacter;
import pinacolada.characters.PCLCharacterSpineAnimation;
import pinacolada.ui.PCLEnergyOrb;
import pinacolada.utilities.GameUtilities;
import thenothing.The;
import thenothing.resources.the.TheEnum;
import thenothing.resources.the.ThePlayerData;
import thenothing.resources.the.TheResources;

public class TheCharacter extends PCLCharacter {
    public static final Color MAIN_COLOR = Color.GRAY.cpy();

    public TheCharacter() {
        super(TheResources.the.data, TheResources.the.images.createSpriterAnimation());
    }

    // Due to the constructor for CustomPlayer, you will need to define your card color here manually, as this gets called before the playerData can be set to the character
    @Override
    public AbstractCard.CardColor getCardColor() {
        return TheResources.the.cardColor;
    }

    @Override
    public Color getCardRenderColor() {
        return MAIN_COLOR;
    }

    @Override
    public AbstractCard getStartCardForEvent() {
        for (PCLCustomCardSlot slot : PCLCustomCardSlot.getCards(getCardColor())) {
            if (slot.getBuilder(0).cardRarity == AbstractCard.CardRarity.BASIC) {
                return slot.make();
            }
        }
        return new Strike_Red();
    }

    @Override
    public Color getCardTrailColor() {
        return MAIN_COLOR;
    }
}
