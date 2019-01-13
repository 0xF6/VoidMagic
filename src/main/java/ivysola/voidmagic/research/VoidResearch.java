package ivysola.voidmagic.research;

import ivysola.voidmagic.VoidAspect;
import ivysola.voidmagic.VoidMagic;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import ivysola.voidmagic.items.VoidItems;
import ivysola.voidmagic.recipe.NodalRecipes;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class VoidResearch
{
    public static void initResearch()
    {
        ResearchCategories.registerCategory("VOID_MAGIC",
                VoidMagic.fromResource( "textures/items/itemVoidVortex.png"),
                VoidMagic.fromResource( "textures/research/gui_research_background_void.png"));


        (new DarkResearchItem("VOID_SHARD", "VOID_MAGIC",
                (new AspectList()).add(Aspect.FIRE, 3)
                        .add(Aspect.ENERGY, 3)
                        .add(Aspect.MAGIC, 3)
                        .add(Aspect.ORDER, 6), 0, 0, 2, new ItemStack(VoidItems.itemVoidShard)))
                .setPages(new ResearchPage("void_magic.research_page.void_shard.1"))
                .setConcealed()
                .registerResearchItem();

        InfusionRecipe a = ThaumcraftApi.addInfusionCraftingRecipe("VOID_VORTEX",
                new ItemStack(VoidItems.itemVoidVortex), 1,
                (new AspectList()).add(Aspect.MAGIC, 256).add(Aspect.LIFE, 256),
                new ItemStack(VoidItems.itemYuuki, 1, 1),
                new ItemStack[] { new ItemStack(VoidItems.itemVoidShard, 1, 4),
                        new ItemStack(VoidItems.itemVoidShard, 1, 4),
                        new ItemStack(VoidItems.itemVoidShard, 1, 4),
                        new ItemStack(VoidItems.itemVoidShard, 1),
                        new ItemStack(VoidItems.itemVoidShard, 1, 2) });

/*IArcaneRecipe a = ThaumcraftApi.addInfusionCraftingRecipe("VOID_VORTEX",
                new ItemStack(VoidItems.itemVoidVortex),
                (new AspectList()).add(Aspect.MAGIC, 256).add(Aspect.LIFE, 256),
                " S ", "SXS", " S ", 'S',
                new ItemStack(VoidItems.itemVoidShard, 1),
                'X', new ItemStack(VoidItems.itemYuuki, 1, 1));*/


        (new DarkResearchItem("VOID_VORTEX", "VOID_MAGIC",
                (new AspectList()).add(VoidAspect.VOID, 3)
                        .add(Aspect.MAGIC, 3), 5, 3, 2, new ItemStack(VoidItems.itemVoidVortex)))
                .setPages(new ResearchPage("void_magic.research_page.void_shard.1"), new ResearchPage(a))
                .setConcealed()
                .setParents("VOID_SHARD")
                .registerResearchItem();

        ThaumcraftApi.addWarpToResearch("VOID_SHARD", 5);
        ThaumcraftApi.addWarpToResearch("VOID_VORTEX", 15);
    }
}
