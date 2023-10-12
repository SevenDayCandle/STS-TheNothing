package thenothing.resources.the;

import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.helpers.CardLibrary;

public class TheEnum
{
    public static class Library {
        @SpireEnum
        public static CardLibrary.LibraryType THE;

        public Library() {
        }
    }

    public static class Cards {
        @SpireEnum
        public static AbstractCard.CardColor THE;

        public Cards() {
        }
    }

    public static class Characters {
        @SpireEnum
        public static AbstractPlayer.PlayerClass THE;

        public Characters() {
        }
    }
}
