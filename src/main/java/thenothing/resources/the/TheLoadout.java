package thenothing.resources.the;

import com.megacrit.cardcrawl.cards.AbstractCard;
import extendedui.EUIUtils;
import pinacolada.cards.base.PCLCardData;
import pinacolada.cards.base.PCLCustomCardSlot;
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
            values.add(slot.ID);
        }
        return values;
    }

    @Override
    public ArrayList<String> getBaseStartingRelics() {
        return EUIUtils.arrayList(ARelic.DATA.ID);
    }

    protected void setDefaultCardsForData(PCLLoadoutData data) {
        ArrayList<String> cards = getAvailableCardIDs();
        if (cards.size() > 0) {
            data.addCardSlot(cards.get(0), 5);
        }
        if (cards.size() > 1) {
            data.addCardSlot(cards.get(1), 5);
        }
    }
}
