package ivysola.voidmagic;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import ivysola.voidmagic.gui.VoidTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.apache.logging.log4j.Logger;
import ivysola.voidmagic.items.VoidItems;
import ivysola.voidmagic.net.CommonProxy;
import ivysola.voidmagic.recipe.NodalRecipes;
import ivysola.voidmagic.research.VoidResearch;

@Mod(modid = VoidMagic.modID, name = VoidMagic.modName, version = VoidMagic.modVersion,
        dependencies = "required-after:Thaumcraft")
public class VoidMagic
{
    @SidedProxy(clientSide = "ivysola.voidmagic.net.ClientProxy", serverSide = "ivysola.voidmagic.net.CommonProxy")
    public static CommonProxy proxy;

    public static final String modID = "VoidMagic";
    public static final String modName = "VoidMagic";
    public static final String modVersion = "1.7.10-1.2RC";

    public static Logger logger;

    public static CreativeTabs mainTab = new VoidTab(StatCollector.translateToLocal("void_magic.tab"));

    @Mod.Instance(modID)
    public static VoidMagic instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent evt)
    {
        logger = evt.getModLog();
        VoidItems.initItems();
        VoidAspect.initAspect();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent evt)
    {
        NodalRecipes recipes = new NodalRecipes();
        recipes.initRecipes();
        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent evt)
    {
        VoidResearch.initResearch();
        VoidAspect.addAspects();
    }



    public static ResourceLocation fromResource(String key)
    {
        return new ResourceLocation("voidmagic", key);
    }
}
