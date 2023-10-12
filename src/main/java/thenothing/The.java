package thenothing;

import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import pinacolada.resources.PGR;
import thenothing.resources.the.TheResources;

@SpireInitializer
public class The
{
    public static void initialize()
    {
        PGR.registerResource(TheResources.the);
    }
}