package ivysola.voidmagic.items;

import cpw.mods.fml.common.registry.GameRegistry;

public class VoidItems
{
    public static ItemMatrix itemMatrix;
    public static ItemVoidShard itemVoidShard;
    public static ItemVoidVortex itemVoidVortex;
    public static ItemYuuki itemYuuki;

    public static void initItems()
    {
        itemMatrix = new ItemMatrix();
        itemVoidShard = new ItemVoidShard();
        itemVoidVortex = new ItemVoidVortex();
        itemYuuki = new ItemYuuki();
        GameRegistry.registerItem(itemMatrix, itemMatrix.getUnlocalizedName());
        GameRegistry.registerItem(itemVoidShard, itemVoidShard.getUnlocalizedName());
        GameRegistry.registerItem(itemVoidVortex, itemVoidVortex.getUnlocalizedName());
        GameRegistry.registerItem(itemYuuki, itemYuuki.getUnlocalizedName());

    }
}
