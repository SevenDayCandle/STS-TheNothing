package thenothing.resources.the;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import extendedui.EUIUtils;
import pinacolada.cards.base.PCLCardData;
import pinacolada.cards.base.PCLCustomCardSlot;
import pinacolada.relics.PCLCustomRelicSlot;
import pinacolada.resources.loadout.PCLLoadout;
import pinacolada.resources.loadout.PCLLoadoutData;
import thenothing.relics.the.ARelic;

import java.util.ArrayList;
import java.util.Collections;

public class TheLoadout extends PCLLoadout
{
    public TheLoadout() {
        super(TheEnum.Cards.THE, createID(TheResources.ID, TheLoadout.class), 0);
    }

    @Override
    public ArrayList<String> getAvailableCardIDs() {
        ArrayList<String> values = super.getAvailableCardIDs();
        // Add custom cards from this color
        for (PCLCustomCardSlot slot : PCLCustomCardSlot.getCards(color)) {
            AbstractCard.CardRarity rarity = slot.getBuilder(0).cardRarity;
            switch (rarity) {
                case BASIC:
                case COMMON:
                case CURSE:
                    values.add(slot.ID);
            }
        }
        return values;
    }

    @Override
    public ArrayList<String> getAvailableRelicIDs() {
        ArrayList<String> values = super.getAvailableRelicIDs();
        // Add custom starter relics from this color
        for (PCLCustomRelicSlot slot : PCLCustomRelicSlot.getRelics(color)) {
            if (slot.getBuilder(0).tier == AbstractRelic.RelicTier.STARTER) {
                values.add(slot.ID);
            }
        }
        return values;
    }

    @Override
    public ArrayList<String> getBaseStartingRelics() {
        return EUIUtils.arrayList(ARelic.DATA.ID);
    }

    @Override
    protected void setDefaultCardsForData(PCLLoadoutData data) {
        ArrayList<PCLCustomCardSlot> slots = EUIUtils.filter(PCLCustomCardSlot.getCards(color), slot -> slot.getBuilder(0).cardRarity == AbstractCard.CardRarity.BASIC);
        if (slots.size() > 1) {
            data.addCardSlot(slots.get(0).ID, 5);
            data.addCardSlot(slots.get(1).ID, 5);
        }
        else if (slots.size() > 0) {
            data.addCardSlot(slots.get(0).ID, 5);
        }
        else {
            ArrayList<String> cards = getAvailableCardIDs();
            if (cards.size() > 0) {
                data.addCardSlot(cards.get(0), 5);
            }
            if (cards.size() > 1) {
                data.addCardSlot(cards.get(1), 5);
            }
        }
    }

    @Override
    protected void setDefaultRelicsForData(PCLLoadoutData data) {
        ArrayList<PCLCustomRelicSlot> slots = EUIUtils.filter(PCLCustomRelicSlot.getRelics(color), slot -> slot.getBuilder(0).tier == AbstractRelic.RelicTier.STARTER);
        if (slots.size() > 0) {
            data.addRelicSlot(slots.get(0).ID);
        }
    }
}
