package thenothing.resources.the;

import basemod.BaseMod;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.helpers.CardHelper;
import extendedui.EUIUtils;
import pinacolada.cards.base.PCLCard;
import pinacolada.cards.base.PCLCardData;
import pinacolada.cards.base.TemplateCardData;
import pinacolada.cards.base.fields.PCLAffinity;
import pinacolada.cards.pcl.curse.Curse_AscendersBane;
import pinacolada.dungeon.CombatManager;
import pinacolada.resources.PCLResources;
import pinacolada.resources.PGR;
import pinacolada.resources.loadout.PCLLoadout;
import thenothing.characters.TheCharacter;

public class TheResources extends PCLResources<ThePlayerData, TheImages, TheTooltips, TheStrings>
{
    public static final String ID = "the";
    public static final TheResources the = new TheResources();

    public TheResources()
    {
        super(ID, TheEnum.Cards.THE, TheEnum.Characters.THE, new TheImages(ID), false);
    }

    // The colorless pool is filled with ALL colorless cards by default. This will determine whether a colorless card is allowed when playing as this character
    // In this example, we filter out any colorless cards exclusive to other Fabricate characters
    @Override
    public boolean containsColorless(AbstractCard card)
    {
        if (card instanceof PCLCard) {
            return ((PCLCard) card).cardData.resources == PGR.core || ((PCLCard) card).cardData.resources == this;
        }
        return true;
    }

    // The colorless pool is filled with ALL colorless cards by default. This will determine whether a colorless card is allowed when NOT playing as this character
    @Override
    public boolean filterColorless(AbstractCard card)
    {
        return card instanceof PCLCard && ((PCLCard) card).cardData.resources == this;
    }

    @Override
    public PCLCardData getAscendersBane()
    {
        return Curse_AscendersBane.DATA;
    }

    @Override
    public ThePlayerData getData()
    {
        return new ThePlayerData(this);
    }

    @Override
    public TheStrings getStrings()
    {
        return new TheStrings(this);
    }

    @Override
    public TheTooltips getTooltips()
    {
        return new TheTooltips();
    }

    @Override
    public void initializeColor()
    {
        Color color = CardHelper.getColor(100, 100, 100);
        BaseMod.addColor(cardColor, color, color, color, color, color, color, color,
                images.attack, images.skill, images.power,
                images.orbA, images.attackL, images.skillL,
                images.powerL, images.orbB, images.orbC);
    }

    @Override
    protected void postInitialize()
    {
        super.postInitialize();
    }

}
