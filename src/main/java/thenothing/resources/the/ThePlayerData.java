package thenothing.resources.the;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.relics.*;
import extendedui.EUIUtils;
import pinacolada.blights.PCLCustomBlightSlot;
import pinacolada.cards.base.PCLCustomCardSlot;
import pinacolada.potions.PCLCustomPotionSlot;
import pinacolada.relics.PCLCustomRelicSlot;
import pinacolada.resources.*;
import pinacolada.resources.loadout.PCLLoadout;
import pinacolada.resources.loadout.PCLLoadoutDataInfo;
import thenothing.characters.TheCharacter;

import java.util.Collections;
import java.util.List;

public class ThePlayerData extends PCLPlayerData<TheResources, TheConfig, TheCharacter>
{
    public static TheLoadout core = PCLLoadout.register(new TheLoadout());

    public ThePlayerData(TheResources resources)
    {
        super(resources, 75, 99, 5, 3, 0, true, false);
    }

    @Override
    public String[] getAdditionalBlightIDs(boolean customEnabled) {
        return !customEnabled ? EUIUtils.arrayMap(PCLCustomBlightSlot.getBlights(resources.cardColor, AbstractCard.CardColor.COLORLESS),
                String.class, slot -> slot.ID
        ) : super.getAdditionalBlightIDs(customEnabled);
    }

    @Override
    public String[] getAdditionalCardIDs(boolean customEnabled) {
        return !customEnabled ? EUIUtils.arrayMap(PCLCustomCardSlot.getCards(resources.cardColor, AbstractCard.CardColor.COLORLESS),
                String.class, slot -> slot.ID
        ) : super.getAdditionalCardIDs(customEnabled);
    }

    @Override
    public String[] getAdditionalPotionIDs(boolean customEnabled) {
        return !customEnabled ? EUIUtils.arrayMap(PCLCustomPotionSlot.getPotions(resources.cardColor, AbstractCard.CardColor.COLORLESS),
                String.class, slot -> slot.ID
        ) : super.getAdditionalPotionIDs(customEnabled);
    }

    @Override
    public String[] getAdditionalRelicIDs(boolean customEnabled) {
        return !customEnabled ? EUIUtils.arrayMap(PCLCustomRelicSlot.getRelics(resources.cardColor, AbstractCard.CardColor.COLORLESS),
                String.class, slot -> slot.ID
        ) : super.getAdditionalRelicIDs(customEnabled);
    }

    @Override
    public List<PCLLoadout> getAvailableLoadouts()
    {
        return Collections.emptyList();
    }

    @Override
    public Class<TheCharacter> getCharacterClass() {
        return TheCharacter.class;
    }

    @Override
    public TheCharacter createCharacter() {
        return new TheCharacter();
    }

    @Override
    public TheConfig getConfig()
    {
        return new TheConfig();
    }

    @Override
    public PCLLoadout getCoreLoadout()
    {
        return core;
    }
}
