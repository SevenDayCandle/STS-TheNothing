package thenothing.resources.the;

import basemod.BaseMod;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.helpers.CardHelper;
import extendedui.EUIUtils;
import pinacolada.cards.base.PCLCard;
import pinacolada.cards.base.PCLCardData;
import pinacolada.cards.base.fields.PCLAffinity;
import pinacolada.cards.pcl.curse.Curse_AscendersBane;
import pinacolada.dungeon.CombatManager;
import pinacolada.resources.PCLResources;
import thenothing.characters.TheCharacter;

public class TheResources extends PCLResources<ThePlayerData, TheImages, TheTooltips, TheStrings>
{
    public static final String ID = "the";
    public static final TheResources the = new TheResources();

    public TheResources()
    {
        super(ID, TheEnum.Cards.THE, TheEnum.Characters.THE, new TheImages(ID), false);
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
    public ThePlayerData getData()
    {
        return new ThePlayerData(this);
    }

    @Override
    public TheTooltips getTooltips()
    {
        return new TheTooltips();
    }

    @Override
    public TheStrings getStrings()
    {
        return new TheStrings(this);
    }

    @Override
    protected void postInitialize()
    {
        super.postInitialize();
    }

    @Override
    public boolean containsColorless(AbstractCard card)
    {
        return card instanceof PCLCard;
    }

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

}
