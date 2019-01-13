package ivysola.voidmagic;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class VoidAspect {
    public static Aspect VOID;
    public static Aspect PUSLE;


    public static void initAspect()
    {
        VOID = new Aspect("Voiduum", 0x421061, new Aspect[] { Aspect.ENTROPY, Aspect.VOID },
                VoidMagic.fromResource("textures/aspects/void.png"), 1);
    }
    public static void addAspects()
    {
        AspectList list;

        list = getAspectList(new ItemStack(Blocks.bedrock));
        list.add(VOID, 1);
        ThaumcraftApi.registerObjectTag(new ItemStack(Blocks.portal, 1, OreDictionary.WILDCARD_VALUE), list);
    }

    private static AspectList getAspectList(ItemStack stack) {
        AspectList list = ThaumcraftApiHelper.getObjectAspects(stack);
        return list != null ? list : new AspectList();
    }
}
