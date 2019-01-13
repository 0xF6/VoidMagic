package ivysola.voidmagic.research;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;

public class DarkResearchItem extends ResearchItem {
    String inter = null;

    public DarkResearchItem(String par1, String x) {
        super(par1, x);
    }

    public DarkResearchItem(String par1, String x, AspectList tags, int y, int z, int par5, ResourceLocation icon) {
        super(par1, x, tags, y, z, par5, icon);
    }

    public DarkResearchItem(String par1, String x, AspectList tags, int y, int z, int par5, ItemStack icon) {
        super(par1, x, tags, y, z, par5, icon);
    }

    public DarkResearchItem(String par1, String x, String mod, AspectList tags, int y, int z, int par5, ResourceLocation icon) {
        super(par1, x, tags, y, z, par5, icon);
        inter = mod;
    }

    public DarkResearchItem(String par1, String x, String mod, AspectList tags, int y, int z, int par5, ItemStack icon) {
        super(par1, x, tags, y, z, par5, icon);
        inter = mod;
    }

    @SideOnly(Side.CLIENT)
    public String getName() {
        return StatCollector.translateToLocal("void_magic.research_name." + key);
    }

    @SideOnly(Side.CLIENT)
    public String getText() {
        return StatCollector.translateToLocal("void_magic.research_text." + key);
    }
}