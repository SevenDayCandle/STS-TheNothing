package thenothing.resources.the;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.relics.*;
import extendedui.EUIUtils;
import pinacolada.cards.base.PCLCustomCardSlot;
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
        super(resources, 75, 99, 5, 3, 0, true, true);
    }

    @Override
    public String[] getAdditionalCardIDs() {
        return EUIUtils.arrayMap(PCLCustomCardSlot.getCards(resources.cardColor, AbstractCard.CardColor.COLORLESS),
                String.class, slot -> slot.ID
        );
    }

    @Override
    public String[] getAdditionalRelicIDs() {
        return EUIUtils.arrayMap(PCLCustomRelicSlot.getRelics(resources.cardColor, AbstractCard.CardColor.COLORLESS),
                String.class, slot -> slot.ID
        );
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
